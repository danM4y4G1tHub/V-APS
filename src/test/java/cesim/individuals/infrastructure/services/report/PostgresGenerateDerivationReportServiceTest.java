package cesim.individuals.infrastructure.services.report;

import cesim.individuals.infrastructure.repository.AllergyIntoleranceRepository;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.MedicationRequestRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import cesim.individuals.infrastructure.repository.models.*;
import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.DerivationReportDTO;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class PostgresGenerateDerivationReportServiceTest {
  @Mock
  PatientRepository patientRepository;
  @Mock
  ConditionRepository conditionRepository;
  @Mock
  MedicationRequestRepository medicationRequestRepository;
  @Mock
  AllergyIntoleranceRepository allergyIntoleranceRepository;

  @InjectMocks
  private PostgresGenerateDerivationReportService service;

  @Test
  void generateDerivationReport_patientExistsWithAllData_returnsCompleteReport() {
    when(patientRepository.findById(anyString())).thenReturn(Optional.of(createSamplePatient()));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of(createSampleCondition()));
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(List.of(createSampleMedication()));
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(List.of(createSampleAllergy()));

    DerivationReportDTO report = service.generateDerivationReport("bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a");

    assertEquals(1, report.patient().name().size());
    assertEquals("Rodríguez", report.patient().name().get(0).family());

    assertEquals(1, report.diagnostic().size());
    assertEquals("44054006", report.diagnostic().get(0).code().coding().get(0).code());

    assertEquals(1, report.medications().size());
    assertTrue(report.medications().get(0).dosageInstruction().get(0).text().contains("10 unidades"));

    assertEquals(1, report.allergies().size());
    assertEquals("91930004", report.allergies().get(0).code().coding().get(0).code());
  }

  @Test
  void generateDerivationReport_patientWithoutMedicalData_returnsEmptyLists() {
    PatientModel patient = createSamplePatient();
    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of());
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(List.of());
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(List.of());

    DerivationReportDTO report = service.generateDerivationReport("patient-without-data");

    assertTrue(report.diagnostic().isEmpty());
    assertTrue(report.medications().isEmpty());
    assertTrue(report.allergies().isEmpty());
  }

  @Test
  void generateDerivationReport_patientNotFound_throwsException() {
    when(patientRepository.findById(anyString())).thenReturn(Optional.empty());

    assertThrows(
            EntityNotFoundException.class,
            () -> service.generateDerivationReport("non-existent-id")
    );
  }

  @Test
  void generateDerivationReport_multipleMedicalItems_correctCounts() {
    ConditionModel condition1 = createSampleCondition();
    ConditionModel condition2 = createSampleCondition();
    MedicationRequestModel med1 = createSampleMedication();
    MedicationRequestModel med2 = createSampleMedication();
    MedicationRequestModel med3 = createSampleMedication();

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(createSamplePatient()));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of(condition1, condition2));
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(List.of(med1, med2, med3));
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(List.of());

    DerivationReportDTO report = service.generateDerivationReport("patient-with-multiple-items");

    assertEquals(2, report.diagnostic().size());
    assertEquals(3, report.medications().size());
    assertEquals(0, report.allergies().size());
  }

  @Test
  void generateDerivationReport_nullFhirFields_handlesGracefully() {
    MedicationRequestModel med = new MedicationRequestModel();
    med.setResource(new MedicationRequest(null, null, null, null,
            null, null,null,null,
            null,null)
    );

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(createSamplePatient()));
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(List.of(med));

    DerivationReportDTO report = service.generateDerivationReport("patient-with-null-fields");

    assertNotNull(report.medications().get(0));
    assertNull(report.medications().get(0).dosageInstruction());
  }

  @Test
  void generateDerivationReport_missingFhirFields_handlesNulls() {
    PatientModel patientModel = new PatientModel();
    patientModel.setResource(new Patient(null, null, false, null, null, null, null, null, null,
            null, null)
    );

    ConditionModel condition = new ConditionModel();
    condition.setResource(new Condition(null, null, null, null, null,
            null, null)
    );

    MedicationRequestModel medication = new MedicationRequestModel();
    medication.setResource(new MedicationRequest(null, null, null, null,
            null, null,null,null,
            null,null)
    );

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patientModel));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of(condition));
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(List.of(medication));
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(Collections.emptyList());

    DerivationReportDTO report = service.generateDerivationReport("patient-with-missing-fields");

    assertNull(report.diagnostic().get(0).code());
    assertNull(report.medications().get(0).dosageInstruction());
  }

  @Test
  void generateDerivationReport_emptyPatientId_throwsException() {
    when(patientRepository.findById("")).thenReturn(Optional.empty());

    assertThrows(
            EntityNotFoundException.class,
            () -> service.generateDerivationReport("")
    );
    verify(patientRepository).findById("");
  }

  @Test
  void generateDerivationReport_nullCollections_handlesGracefully() {
    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(null, null, false, null, null, null,
            null, null, null,null, null)
    );

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(null);
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(null);
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(null);

    DerivationReportDTO report = service.generateDerivationReport("patient-with-null-collections");

    assertTrue(report.diagnostic().isEmpty());
    assertTrue(report.medications().isEmpty());
    assertTrue(report.allergies().isEmpty());
  }

  @Test
  void generateDerivationReport_largeDataset_processesAllItems() {
    // Crear 1000 instancias de cada tipo
    List<ConditionModel> conditions = Collections.nCopies(1000, createSampleCondition());
    List<MedicationRequestModel> medications = Collections.nCopies(1000, createSampleMedication());
    List<AllergyIntoleranceModel> allergies = Collections.nCopies(1000, createSampleAllergy());

    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(null, null, false, null, null, null,
            null, null, null,null, null));

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(conditions);
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(medications);
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(allergies);

    DerivationReportDTO report = service.generateDerivationReport("patient-with-large-data");

    assertEquals(1000, report.diagnostic().size());
    assertEquals(1000, report.medications().size());
    assertEquals(1000, report.allergies().size());
  }

  @Test
  void generateDerivationReport_boundaryValues_handlesCorrectly() {
    ConditionModel condition = new ConditionModel();
    Condition conditionResource = new Condition("", null, new CodeableConcept(
            List.of(new Coding("system", null,"a".repeat(1000),"display",null)),
            null), null, null,null, null
    );
    condition.setResource(conditionResource);

    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(null, null, false, null, null, null,
            null, null, null,null, null));

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of(condition));
    when(medicationRequestRepository.findByPatientId(anyString())).thenReturn(Collections.emptyList());
    when(allergyIntoleranceRepository.findByPatientId(anyString())).thenReturn(Collections.emptyList());

    DerivationReportDTO report = service.generateDerivationReport("patient-with-boundary-values");

    assertEquals(1000, report.diagnostic().get(0).code().coding().get(0).code().length());
  }

  @Test
  void generateDerivationReport_nestedNullFields_handlesGracefully() {
    Patient patient = new Patient(null, null, false, null, null, null,
            null, null, null,null, null);

    PatientModel patientModel = new PatientModel();
    patientModel.setResource(patient);

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patientModel));

    DerivationReportDTO report = service.generateDerivationReport("patient-nested-null");

    assertNull(report.patient().name());
  }

  @Test
  void generateDerivationReport_invalidIdFormat_throwsException() {
    when(patientRepository.findById("invalid!id#")).thenReturn(Optional.empty());

    assertThrows(
            EntityNotFoundException.class,
            () -> service.generateDerivationReport("invalid!id#")
    );
  }

  @Test
  void generateDerivationReport_emptyFhirResources_emptyReport() {
    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(null, null, false, null, null, null,
            null, null, null,null, null));

    ConditionModel condition = new ConditionModel();
    condition.setResource(new Condition(null, null, null,
            null, null, null, null));

    when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(anyString())).thenReturn(List.of(condition));

    DerivationReportDTO report = service.generateDerivationReport("empty-resources");

    assertNull(report.diagnostic().get(0).code());
  }

  private PatientModel createSamplePatient() {
    Patient patient = new Patient(null, null, false, List.of(new HumanName(
            HumanName.Use.OFFICIAL, null, "Rodríguez", List.of("María", "Elena"),
            null, null, null)), null, null, null,
            null, null, null, null);

    PatientModel model = new PatientModel();
    model.setResource(patient);
    return model;
  }

  private ConditionModel createSampleCondition() {
    Condition condition = new Condition(null, null, new CodeableConcept(List.of(new Coding("http://snomed.info/sct",
                    null,"44054006", "Diabetes mellitus tipo 2", null)), null),
            null, null, null, null
    );

    ConditionModel model = new ConditionModel();
    model.setResource(condition);
    return model;
  }

  private MedicationRequestModel createSampleMedication() {
    MedicationRequest medication = new MedicationRequest(null, null, null, null, null,
            null, null, List.of(new Dosage( null,"Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
                    null, null, null, null, null, null,
            null, null, null, null, null, null, null,
                    null, null)), null, null
            );

    MedicationRequestModel model = new MedicationRequestModel();
    model.setResource(medication);
    return model;
  }

  private AllergyIntoleranceModel createSampleAllergy() {
    AllergyIntolerance allergy = new AllergyIntolerance(null, null,
            new CodeableConcept(List.of(new Coding("http://snomed.info/sct", null, "91930004",
                    "Penicilina", null)), null), null, null);

    AllergyIntoleranceModel model = new AllergyIntoleranceModel();
    model.setResource(allergy);
    return model;
  }
}
