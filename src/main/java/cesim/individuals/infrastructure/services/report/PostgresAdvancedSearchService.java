package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.outputDTO.AdvancedSearchResultsDTO;
import cesim.individuals.domain.usecases.report.dependencies.AdvancedSearchService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostgresAdvancedSearchService implements AdvancedSearchService {
  private final PatientRepository patientRepository;

  public AdvancedSearchResultsDTO searchPatients(Pageable pageable, AdvancedSearchRequestSpec searchRequest) {

    Specification<PatientModel> patientSpec = createSearchSpecification(searchRequest);

    var sort = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var results = patientRepository.findAll(patientSpec, PageRequest.of(
            pageable.page(),
            pageable.size(),
            sort));

    Page<Patient> patientPage = new Page<>(
            results.getNumber(),
            results.getSize(),
            results.getTotalPages(),
            results.toList().stream().map(PatientModel::getResource).toList()
    );

    return new AdvancedSearchResultsDTO(patientPage);
  }

  private Specification<PatientModel> createSearchSpecification(AdvancedSearchRequestSpec searchRequest) {
    Specification<PatientModel> spec = (
            (root, query, criteriaBuilder) -> {
              List<Predicate> predicates = new ArrayList<>();

              addPatientNameToPredicate(searchRequest.name(), root, criteriaBuilder, predicates);
              addPatientIdentifierToPredicate(searchRequest.identification(), root, criteriaBuilder, predicates);
              addPatientDiagnosisToPredicate(searchRequest.diagnosis(), root, query, criteriaBuilder, predicates);
              addDateToPredicate(searchRequest.fromDate(), searchRequest.toDate(), root, criteriaBuilder, predicates);

              if (predicates.isEmpty()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

              return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            });


    return spec;
  }

  private void addPatientNameToPredicate(String patientName, Root<PatientModel> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
    if (patientName != null && !patientName.isEmpty()) {
      Expression<String> familyExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("name"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("family")
      );

      Expression<String> givenExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("name"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("given"),
              criteriaBuilder.literal("0")
      );

      String searchTerm = "%" + patientName.toLowerCase() + "%";
      Predicate familyPredicate = criteriaBuilder.like(
              criteriaBuilder.lower(familyExpression),
              searchTerm
      );
      Predicate givenPredicate = criteriaBuilder.like(
              criteriaBuilder.lower(givenExpression),
              searchTerm
      );

      predicates.add(criteriaBuilder.or(familyPredicate, givenPredicate));
    }
  }

  private void addPatientIdentifierToPredicate(String identifier, Root<PatientModel> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
    if (identifier != null && !identifier.isEmpty()) {
      Expression<String> identificerExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("identifier"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("value")
      );
      Predicate identifierPatientExpression = criteriaBuilder.like(
              identificerExpression,
              "%" + identifier + "%"
      );

      predicates.add(identifierPatientExpression);
    }
  }

  private void addPatientDiagnosisToPredicate(String diagnosis, Root<PatientModel> root, CriteriaQuery query, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
    if (diagnosis != null && !diagnosis.isEmpty()) {
      Subquery<String> subquery = query.subquery(String.class);
      Root<ConditionModel> conditionRoot = subquery.from(ConditionModel.class);

      Expression<String> subjectRef = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              conditionRoot.get("resource"),
              criteriaBuilder.literal("subject"),
              criteriaBuilder.literal("reference")
      );

      Expression<String> displayExpression = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              conditionRoot.get("resource"),
              criteriaBuilder.literal("code"),
              criteriaBuilder.literal("coding"),
              criteriaBuilder.literal("0"),
              criteriaBuilder.literal("display")
      );

      subquery.select(
              criteriaBuilder.function(
                      "split_part",
                      String.class,
                      subjectRef,
                      criteriaBuilder.literal("/"),
                      criteriaBuilder.literal(2)
              )
      ).where(
              criteriaBuilder.like(
                      criteriaBuilder.lower(displayExpression),
                      "%" + diagnosis + "%"
              )
      );

      Expression<String> patientId = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("id")
      );

      predicates.add(criteriaBuilder.in(patientId).value(subquery));
    }

  }

  private void addDateToPredicate(LocalDate fromDate, LocalDate toDate, Root<PatientModel> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
    if (fromDate != null || toDate != null) {
      Expression<String> birthDateStr = criteriaBuilder.function(
              "jsonb_extract_path_text",
              String.class,
              root.get("resource"),
              criteriaBuilder.literal("birthDate")
      );

      Expression<LocalDate> birthDate = criteriaBuilder.function(
              "to_date",
              LocalDate.class,
              birthDateStr,
              criteriaBuilder.literal("YYYY-MM-DD")
      );

      if (fromDate != null && toDate != null) {
        predicates.add(criteriaBuilder.between(birthDate, fromDate, toDate));
      } else if (fromDate != null) {
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(birthDate, fromDate));
      } else {
        predicates.add(criteriaBuilder.lessThanOrEqualTo(birthDate, toDate));
      }
    }
  }
}
