package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.ClinicalReportDTO;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostgresClinicalReportFilterServiceTest {

  @Mock
  private PatientRepository patientRepository;

  @Mock
  private ConditionRepository conditionRepository;

  @InjectMocks
  private PostgresClinicalReportFilterService service;

  private PatientModel createTestPatientModel(Patient.Gender gender) {
    Patient patient = new Patient(
            UUID.randomUUID().toString(), List.of(new Identifier(null, null, "http://minsap.cu/ci",
            "92020254321", null, null)), true, List.of(new HumanName(HumanName.Use.OFFICIAL,
            null, "Rodríguez", List.of("María", "Elena"), null, null, null)),
            List.of(new ContactPoint(ContactPoint.System.PHONE, "+5355512345", ContactPoint.Use.WORK, null,
                    null)), gender, LocalDate.of(1992, 2, 2),
            List.of(new Address(Address.Type.BOTH, Address.Use.WORK, List.of("Calle 23 #456"), null,
                    "La Habana", "Cuba", "La Habana", "10400", null, null,
                    new Reference("Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a", null, null,
                            null))), new CodeableConcept(List.of(new Coding("http://hl7.org/fhir/marital-status",
            null, "M", "Casada", null)), null), null, null
    );
    PatientModel model = new PatientModel();
    model.setResource(patient);
    return model;
  }

  private ConditionModel createTestConditionModel(String patientId) {
    Condition condition = new Condition(
            null, new CodeableConcept(List.of(new Coding("http://terminology.hl7.org/CodeSystem/condition-clinical",
            null, "active", "Active", null)), null),
            new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null, "44054006",
                    "Diabetes mellitus tipo 2", null)), null),
            new Reference("Patient/" + patientId, null, null, null),
            null,
            LocalDateTime.of(2023, 5, 15, 14, 30),
            null
    );
    ConditionModel model = new ConditionModel();
    model.setResource(condition);
    return model;
  }

  @Test
  void testFilterConditions_AllFilters() {
    Pageable pageable = new Pageable(0, 10, "name", "asc");
    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
            "44054006",
            "92020254321",
            "Rodríguez",
            "female",
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2023, 12, 31)
    );

    PatientModel patientModel = createTestPatientModel(Patient.Gender.FEMALE);
    ConditionModel conditionModel = createTestConditionModel(patientModel.getResource().id());

    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
            .thenReturn(new PageImpl<>(List.of(patientModel)));
    when(conditionRepository.findAll(any(Specification.class), any(PageRequest.class)))
            .thenReturn(new PageImpl<>(List.of(conditionModel)));

    ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);

    assertNotNull(result);
    assertEquals(1, result.patients().items().size());
    assertEquals(1, result.conditions().items().size());
    verify(patientRepository).findAll(any(Specification.class), any(PageRequest.class));
    verify(conditionRepository).findAll(any(Specification.class), any(PageRequest.class));
  }

//  @Test
//  void testFilterConditions_OnlyPatientIdentifier() {
//    Pageable pageable = new Pageable(0, 10, "id", "asc");
//    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
//            null,
//            "92020254321",
//            null,
//            null,
//            null,
//            null
//    );
//
//    PatientModel patientModel = createTestPatientModel(null);
//    when(patientRepository.findByIdentification("92020254321"))
//            .thenReturn(Optional.of(patientModel));
//    when(conditionRepository.findByPatientId(patientModel.getResource().id()))
//            .thenReturn(List.of(createTestConditionModel(patientModel.getResource().id())));
//
//    ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);
//
//    assertNotNull(result);
//    assertEquals(1, result.patients().items().size());
//    assertFalse(result.conditions().items().isEmpty());
//  }

//  @Test
//  void testFilterConditions_DateRangeOnly() {
//    Pageable pageable = new Pageable(0, 10, "recordedDate", "desc");
//    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
//            null,
//            null,
//            null,
//            null,
//            LocalDate.of(2023, 1, 1),
//            LocalDate.of(2023, 12, 31)
//    );
//
//    PatientModel patientModel = createTestPatientModel(null);
//    ConditionModel conditionModel = createTestConditionModel(patientModel.getResource().id());
//
//    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
//            .thenReturn(new PageImpl<>(List.of(patientModel)));
//    when(conditionRepository.findByRecordedDate("2023-01-01", "2023-12-31"))
//            .thenReturn(List.of(conditionModel));
//
//    ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);
//
//    assertNotNull(result);
//    assertFalse(result.conditions().items().isEmpty());
//    assertEquals(2023, result.conditions().items().get(0).recordedDate().getYear());
//  }

//  @Test
//  void testFilterConditions_EmptyResults() {
//    Pageable pageable = new Pageable(0, 10, "name", "asc");
//    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
//            "INVALID_CODE",
//            null,
//            null,
//            null,
//            null,
//            null
//    );
//
//    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
//            .thenReturn(new PageImpl<>(Collections.emptyList()));
//    when(conditionRepository.findAll(any(Specification.class), any(PageRequest.class)))
//            .thenReturn(new PageImpl<>(Collections.emptyList()));
//
//    try {
//      ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);
//      assertNotNull(result);
//
//      assertTrue(result.patients().items().isEmpty());
//      assertTrue(result.conditions().items().isEmpty());
//    } catch (RuntimeException e) {
////      throw new RuntimeException(e);
//    }
//  }

//  @Test
//  void testFilterConditions_PaginationAndSorting() {
//    Pageable pageable = new Pageable(1, 5, "birthDate", "desc");
//    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
//            null,
//            null,
//            null,
//            null,
//            null,
//            null
//    );
//
//    List<PatientModel> patients = Collections.nCopies(5, createTestPatientModel(null));
//    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
//            .thenReturn(new PageImpl<>(patients));
//
//    ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);
//
//    assertEquals(1, result.patients().pageNumber());
//    assertEquals(5, result.patients().items().size());
//    assertTrue(result.patients().hasNext());
//  }
//
//  @Test
//  void testFilterConditions_GenderUnknown() {
//    Pageable pageable = new Pageable(0, 10, "name", "asc");
//    ClinicalReportFilterSpec filterSpec = new ClinicalReportFilterSpec(
//            null,
//            null,
//            null,
//            "unknown",
//            null,
//            null
//    );
//
//    PatientModel patientModel = createTestPatientModel(Patient.Gender.OTHER);
//    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
//            .thenReturn(new PageImpl<>(List.of(patientModel)));
//
//    ClinicalReportDTO result = service.filterConditions(pageable, filterSpec);
//
//    assertNotNull(result);
//    assertEquals(1, result.patients().items().size());
//  }
}
