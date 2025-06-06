package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Patient;
import org.springframework.data.domain.Sort;
import cesim.individuals.domain.entities.Condition;
import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.usecases.report.dependencies.ClinicalReportFilterService;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;

import cesim.individuals.infrastructure.repository.models.PatientModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.PageRequest;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresClinicalReportFilterService implements ClinicalReportFilterService {
  private final PatientRepository patientRepository;
  private final ConditionRepository conditionRepository;
  private List<Predicate> predicates;

  public ClinicalReportDTO filterConditions(Pageable pageable, ClinicalReportFilterSpec filterSpec) {
    Specification<ConditionModel> pathologySpec = createPathologySpecification(filterSpec);

    PatientModel patientModel = null;
    Page<Patient> patientPage = null;

    if (filterSpec.patientIdentifier() != null && filterSpec.patientName() == null && filterSpec.patientGender() == null) {
      patientModel = patientRepository.findByIdentication(filterSpec.patientIdentifier())
              .orElseThrow(() ->
                      new IllegalArgumentException("Patient not found with CI: "
                              + filterSpec.patientIdentifier())
              );
    } else {
      var sort = Sort.by(
              pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
              pageable.sortBy());

      Specification<PatientModel> patientSpec = crearePatientSpecifications(filterSpec);
      var patientResults = patientRepository.findAll(patientSpec, PageRequest.of(
              pageable.page(),
              pageable.size(),
              sort));

      patientPage = new Page<>(
              patientResults.getNumber(),
              patientResults.getSize(),
              patientResults.getTotalPages(),
              patientResults.toList().stream().map(PatientModel::getResource).toList()
      );
    }

    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var pathologyResults = conditionRepository.findAll(pathologySpec, PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort));

    Page<Condition> conditions = new Page<>(
            pathologyResults.getNumber(),
            pathologyResults.getSize(),
            pathologyResults.getTotalPages(),
            pathologyResults.toList().stream().map(ConditionModel::getResource).toList()
    );

    return new ClinicalReportDTO(
            createClinicalPatientReport(patientModel),
            createClinicalPatientReport(patientPage),
            createClinicalConditionsReport(conditions)
    );
  }

  private Specification<PatientModel> crearePatientSpecifications(ClinicalReportFilterSpec filterSpec) {
    Specification<PatientModel> spec = ((root, query, criteriaBuilder) -> {
      predicates = new ArrayList<>();

      addPatientNameToPredicate(filterSpec.patientName(), root, criteriaBuilder);
      addPatientGenderToPredicate(filterSpec.patientGender(), root, criteriaBuilder);

      if (predicates.isEmpty()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });

    return spec;
  }

  private void addPatientNameToPredicate(String patientName, Root<PatientModel> root, CriteriaBuilder criteriaBuilder) {
    if (patientName == null || patientName.isEmpty()) return;

    if (patientName != null && !patientName.isEmpty()) {
      String lowerCasePatientName = patientName.toLowerCase();
      String searchPattern = "%" + lowerCasePatientName + "%";

      Expression<String> familyNameExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resourse"),
              criteriaBuilder.literal("name"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("familty")
      );
      Predicate familyPredicate = criteriaBuilder.like(criteriaBuilder.lower(familyNameExpression), searchPattern);

      Expression<String> givenNameAsTextExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("name"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("given")
      );
      Predicate givenPredicate = criteriaBuilder.like(criteriaBuilder.lower(givenNameAsTextExpression), searchPattern);

      predicates.add(criteriaBuilder.or(familyPredicate, givenPredicate));
    }
  }

  private void addPatientGenderToPredicate(String patientGender, Root<PatientModel> root, CriteriaBuilder criteriaBuilder) {
    if (patientGender == null || patientGender.isEmpty()) return;

    if (patientGender != null && !patientGender.isEmpty()) {
      Expression<String> genderExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("gender")
      );
      predicates.add(criteriaBuilder.equal(genderExpression, patientGender));
    }
  }

  private Specification<ConditionModel> createPathologySpecification(ClinicalReportFilterSpec filterSpec) {
    Specification<ConditionModel> spec = (
            (root, query, criteriaBuilder) -> {
              predicates = new ArrayList<>();

              addPathologyToPredicate(filterSpec.pathologyCode(), root, criteriaBuilder);
              addRangeDateToPredicate(filterSpec.startDate(), filterSpec.endDate(), root, criteriaBuilder);

              if (predicates.isEmpty()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

              return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
    );

    return spec;
  }

  private void addPathologyToPredicate(String pathology, Root<ConditionModel> root, CriteriaBuilder criteriaBuilder) {
    if (pathology == null || pathology.isEmpty()) return;

    if (pathology != null && !pathology.isEmpty()) {
      String jsonPathExpression = "$.code.coding[*] ? (@.code == \"" + pathology + "\")";

      Expression<Boolean> jsonPathExists = criteriaBuilder.function(
              "jsonb_path_exists",
              Boolean.class,
              root.get("resource"),
              criteriaBuilder.literal(jsonPathExpression)
      );

      predicates.add(criteriaBuilder.isTrue(jsonPathExists));
    }
  }

  private void addRangeDateToPredicate(LocalDate startDate, LocalDate endDate, Root<ConditionModel> root, CriteriaBuilder criteriaBuilder) {
    Expression<LocalDate> startedDate = extractStartedDate(root, criteriaBuilder);
    if (startDate == null && endDate == null) {
      return;
    }

    if (startDate != null && endDate == null) {
      predicates.add(criteriaBuilder.greaterThanOrEqualTo(startedDate, startDate));
    } else if (startDate != null && endDate != null) {
      predicates.add(criteriaBuilder.between(startedDate, startDate, endDate));
    } else {
      predicates.add(criteriaBuilder.lessThanOrEqualTo(startedDate, endDate));
    }
  }

  private Expression<LocalDate> extractStartedDate(Root<ConditionModel> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.function(
            "to_Date",
            LocalDate.class,
            extractStartedDateStr(root, criteriaBuilder),
            criteriaBuilder.literal("YYYY-MM-DD")
    );
  }

  private Expression<String> extractStartedDateStr(Root<ConditionModel> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.function(
            "jsonb_extract_path_text",
            String.class,
            root.get("resource"),
            criteriaBuilder.literal("recordedDate")
    );
  }

  private ClinicalReportDTO.PatientInfo createClinicalPatientReport(PatientModel patientModel) {
    if (patientModel != null) {
      ClinicalReportDTO.PatientInfo patientInfo = new ClinicalReportDTO.PatientInfo(
              patientModel.getResource().identifier(),
              patientModel.getResource().name(),
              patientModel.getResource().gender(),
              patientModel.getResource().birthDate(),
              patientModel.getResource().telecom(),
              patientModel.getResource().address(),
              patientModel.getResource().maritalStatus()
      );
      return patientInfo;
    }
    return null;
  }

  private Page<ClinicalReportDTO.PatientInfo> createClinicalPatientReport(Page<Patient> patientPage) {
    if (patientPage == null) return null;

    List<Patient> patientList = patientPage.items();
    List<ClinicalReportDTO.PatientInfo> patientInfoList = patientList.stream().map(
            p -> new ClinicalReportDTO.PatientInfo(
                    p.identifier(),
                    p.name(),
                    p.gender(),
                    p.birthDate(),
                    p.telecom(),
                    p.address(),
                    p.maritalStatus()
            )
    ).toList();

    return new Page<>(
            patientPage.pageNumber(),
            patientPage.pageSize(),
            patientPage.totalPages(),
            patientInfoList
    );
  }

  private Page<ClinicalReportDTO.ConditionsInfo> createClinicalConditionsReport(Page<Condition> conditionsPage) {
    if (conditionsPage == null) return null;

    List<Condition> conditionList = conditionsPage.items();

    List<ClinicalReportDTO.ConditionsInfo> conditionsInfoList = conditionList.stream().map(
            c -> new ClinicalReportDTO.ConditionsInfo(
                    c.clinicalStatus(),
                    c.code(),
                    c.recordedDate(),
                    c.onsetDateTime(),
                    c.subject()
            )
    ).collect(Collectors.toList());

    return new Page<>(
            conditionsPage.pageNumber(),
            conditionsPage.pageSize(),
            conditionsPage.totalPages(),
            conditionsInfoList
    );
  }
}
