package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.usecases.report.dependencies.ClinicalReportFilterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresClinicalReportFilterService implements ClinicalReportFilterService {
        private final PatientRepository patientRepository;
        private final ConditionRepository conditionRepository;

        public ClinicalReportDTO filterConditions(Pageable pageable, ClinicalReportFilterSpec filterSpec) {
                Specification<PatientModel> patientSpec = createPatientSpecification(filterSpec);
                var patientSort = Sort.by(
                                pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                                pageable.sortBy());

                var patientResults = patientRepository.findAll(
                                patientSpec, PageRequest.of(pageable.page(), pageable.size(), patientSort));

                if (patientResults.isEmpty())
                        return new ClinicalReportDTO(
                                        new Page<>(
                                                        0,
                                                        0,
                                                        0,
                                                        new ArrayList<>()),
                                        new Page<>(
                                                        0,
                                                        0,
                                                        0,
                                                        new ArrayList<>()));

                List<String> patientsId = patientResults.getContent().stream()
                                .map(p -> p.getResource().id())
                                .collect(Collectors.toList());

                Specification<ConditionModel> conditionsSpec = createConditionSpecification(filterSpec, patientsId);
                var conditionResults = conditionRepository.findAll(conditionsSpec, PageRequest.of(pageable.page(),
                                pageable.size(),
                                patientSort));

                if (conditionResults == null)
                        conditionResults = new PageImpl<>(new ArrayList<>());

                List<ClinicalReportDTO.PatientInfo> patientContent = patientResults.getContent().stream()
                                .map(p -> new ClinicalReportDTO.PatientInfo(
                                                p.getResource().identifier(),
                                                p.getResource().name(),
                                                p.getResource().gender(),
                                                p.getResource().birthDate(),
                                                p.getResource().telecom(),
                                                p.getResource().address(),
                                                p.getResource().maritalStatus()))
                                .collect(Collectors.toList());

                List<ClinicalReportDTO.ConditionsInfo> content = conditionResults.getContent().stream()
                                .map(c -> new ClinicalReportDTO.ConditionsInfo(
                                                c.getResource().clinicalStatus(),
                                                c.getResource().code(),
                                                c.getResource().recordedDate(),
                                                c.getResource().onsetDateTime(),
                                                c.getResource().subject()))
                                .collect(Collectors.toList());

                if (content == null)
                        content = new ArrayList<>();

                return new ClinicalReportDTO(
                                new Page<>(
                                                patientResults.getNumber(),
                                                patientResults.getSize(),
                                                patientResults.getTotalPages(),
                                                patientContent),
                                new Page<>(
                                                conditionResults.getNumber(),
                                                conditionResults.getSize(),
                                                conditionResults.getTotalPages(),
                                                content));
        }

        private Specification<PatientModel> createPatientSpecification(ClinicalReportFilterSpec filterSpec) {
                return (root, query, criteriaBuilder) -> {
                        List<Predicate> predicates = new ArrayList<>();

                        if (filterSpec.patientIdentifier() != null) {
                                predicates.add(criteriaBuilder.equal(
                                                criteriaBuilder.function(
                                                                "jsonb_extract_path_text",
                                                                String.class,
                                                                root.get("resource"),
                                                                criteriaBuilder.literal("identifier"),
                                                                criteriaBuilder.literal("0"),
                                                                criteriaBuilder.literal("value")),
                                                filterSpec.patientIdentifier()));
                        }

                        if (filterSpec.patientName() != null) {
                                String searchPattern = "%" + filterSpec.patientName().toLowerCase() + "%";

                                Expression<String> familyName = criteriaBuilder.function(
                                                "jsonb_extract_path_text", String.class,
                                                root.get("resource"),
                                                criteriaBuilder.literal("name"),
                                                criteriaBuilder.literal("0"),
                                                criteriaBuilder.literal("family"));

                                Expression<String> givenName = criteriaBuilder.function(
                                                "jsonb_extract_path_text",
                                                String.class,
                                                root.get("resource"),
                                                criteriaBuilder.literal("name"),
                                                criteriaBuilder.literal("0"),
                                                criteriaBuilder.literal("given"));

                                predicates.add(criteriaBuilder.or(
                                                criteriaBuilder.like(criteriaBuilder.lower(familyName), searchPattern),
                                                criteriaBuilder.like(criteriaBuilder.lower(givenName), searchPattern)));
                        }

                        if (filterSpec.patientGender() != null) {
                                predicates.add(criteriaBuilder.equal(
                                                criteriaBuilder.function(
                                                                "jsonb_extract_path_text",
                                                                String.class,
                                                                root.get("resource"),
                                                                criteriaBuilder.literal("gender")),
                                                filterSpec.patientGender()));
                        }

                        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                };
        }

        private Specification<ConditionModel> createConditionSpecification(
                        ClinicalReportFilterSpec filterSpec,
                        List<String> patientIds) {
                return (root, query, criteriaBuilder) -> {
                        List<Predicate> predicates = new ArrayList<>();

                        if (!patientIds.isEmpty()) {
                                Expression<String> subjectRef = criteriaBuilder.function(
                                                "jsonb_extract_path_text",
                                                String.class,
                                                root.get("resource"),
                                                criteriaBuilder.literal("subject"),
                                                criteriaBuilder.literal("reference"));

                                predicates.add(criteriaBuilder.or(patientIds.stream()
                                                .map(id -> criteriaBuilder.like(subjectRef, "%Patient/" + id + "%"))
                                                .toArray(Predicate[]::new)));
                        }

                        if (filterSpec.pathologyCode() != null) {
                                String jsonPath = "$.code.coding[*] ? (@.code == \"" + filterSpec.pathologyCode()
                                                + "\")";
                                predicates.add(criteriaBuilder.isTrue(
                                                criteriaBuilder.function("jsonb_path_exists", Boolean.class,
                                                                root.get("resource"),
                                                                criteriaBuilder.literal(jsonPath))));
                        }

                        if (filterSpec.startDate() != null || filterSpec.endDate() != null) {
                                Expression<LocalDate> recordedDate = criteriaBuilder.function("to_date",
                                                LocalDate.class,
                                                criteriaBuilder.function("jsonb_extract_path_text", String.class,
                                                                root.get("resource"),
                                                                criteriaBuilder.literal("recordedDate")),
                                                criteriaBuilder.literal("YYYY-MM-DD"));

                                if (filterSpec.startDate() != null && filterSpec.endDate() != null) {
                                        predicates.add(criteriaBuilder.between(recordedDate, filterSpec.startDate(),
                                                        filterSpec.endDate()));
                                } else if (filterSpec.startDate() != null) {
                                        predicates.add(criteriaBuilder.greaterThanOrEqualTo(recordedDate,
                                                        filterSpec.startDate()));
                                } else {
                                        predicates.add(criteriaBuilder.lessThanOrEqualTo(recordedDate,
                                                        filterSpec.endDate()));
                                }
                        }

                        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                };
        }
}