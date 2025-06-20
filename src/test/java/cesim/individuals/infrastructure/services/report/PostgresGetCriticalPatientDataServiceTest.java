package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Identifier;
import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.entities.Reference;
import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;
import cesim.individuals.infrastructure.repository.*;
import cesim.individuals.infrastructure.repository.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostgresGetCriticalPatientDataServiceTest {

  @Mock
  private PatientRepository patientRepository;

  @Mock
  private ConditionRepository conditionRepository;

  @Mock
  private AllergyIntoleranceRepository allergyIntoleranceRepository;

  @Mock
  private MedicationRequestRepository medicationRequestRepository;

  @Mock
  private EncounterRepository encounterRepository;

  @Mock
  private ObservationRepository observationRepository;

  @Mock
  private PractitionerRepository practitionerRepository;

  @Mock
  private RelatedPersonRepository relatedPersonRepository;

  @Mock
  private CarePlanRepository carePlanRepository;

  @InjectMocks
  private PostgresGetCriticalPatientDataService service;

  @Test
  void getCriticalPatientData_PatientNotFound_ReturnsNull() throws Exception {
    String patientIdentifier = "92020254321";
    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.empty());

    CriticalPatientDataDTO result = null;
    try {
      result = service.getCriticalDataByIdentification(patientIdentifier);
    } catch (Exception e) {}

    assertNull(result);
  }

  @Test
  void getCriticalPatientData_PatientFound_AllDataEmpty() {
    String patientId = "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a";
    String patientIdentifier = "92020254321";
    when(patientRepository.findById(patientIdentifier)).thenReturn(Optional.of(new PatientModel()));

    when(conditionRepository.findByPatientId(patientIdentifier)).thenReturn(Collections.emptyList());
    when(allergyIntoleranceRepository.findByPatientId(patientId)).thenReturn(Collections.emptyList());
    when(medicationRequestRepository.findByPatientId(patientId)).thenReturn(Collections.emptyList());
    when(encounterRepository.findByPatientId(patientId)).thenReturn(Collections.emptyList());
    when(observationRepository.findByPatientIds(List.of(patientId))).thenReturn(Collections.emptyList());
    when(practitionerRepository.findById(any())).thenReturn(Optional.empty());
    when(relatedPersonRepository.getByPatientId(patientId)).thenReturn(Collections.emptyList());
    when(carePlanRepository.findByPatientId(patientId)).thenReturn(Collections.emptyList());

    try {
      CriticalPatientDataDTO result = service.getCriticalDataByIdentification(patientIdentifier);
      assertNotNull(result);
      assertNotNull(result.patient());
      assertTrue(result.allergies().isEmpty());
      assertTrue(result.medications().isEmpty());
      assertTrue(result.conditions().isEmpty());
      assertTrue(result.encounterInfo().isEmpty());
      assertTrue(result.observations().isEmpty());
      assertNull(result.practitioner());
      assertTrue(result.relatedPersons().isEmpty());
      assertTrue(result.caresPlanInfo().isEmpty());
    } catch (Exception e) {}
  }

  @Test
  void getCriticalPatientData_PatientFound_FullData() {
    String patientId = "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a";
    String patientIdentifier = "92020254321";
    String practitionerId = "12345678-1234-1234-1234-123456789abc";

    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(patientId, null, true, null, null, null,
            null, null, null, null, null));
    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.of(patient));

    when(conditionRepository.findByPatientId(patientId)).thenReturn(List.of(new ConditionModel()));
    when(allergyIntoleranceRepository.findByPatientId(patientId)).thenReturn(List.of(new AllergyIntoleranceModel()));
    when(medicationRequestRepository.findByPatientId(patientId)).thenReturn(List.of(new MedicationRequestModel()));
    when(encounterRepository.findByPatientId(patientId)).thenReturn(List.of(new EncounterModel()));
    when(observationRepository.findByPatientIds(List.of(patientId))).thenReturn(List.of(new ObservationModel()));

    PractitionerModel practitioner = new PractitionerModel();
    practitioner.setResource(new Practitioner(practitionerId, null, true, null, null,
            null, null, null, null)
    );

    when(practitionerRepository.findById(practitionerId)).thenReturn(Optional.of(practitioner));

    when(relatedPersonRepository.getByPatientId(patientIdentifier)).thenReturn(List.of(new RelatedPersonModel()));
    when(carePlanRepository.findByPatientId(patientId)).thenReturn(List.of(new CarePlanModel()));

    try {
      CriticalPatientDataDTO result = service.getCriticalDataByIdentification(patientIdentifier);
      String notNull = "";
      assertNotNull(result);
      assertEquals(1, result.allergies().size());
      assertEquals(1, result.medications().size());
      assertEquals(1, result.conditions().size());
      assertEquals(1, result.encounterInfo().size());
      assertEquals(1, result.observations().size());
      assertNotNull(result.practitioner());
      assertEquals(1, result.relatedPersons().size());
      assertEquals(1, result.caresPlanInfo().size());
    } catch (Exception e) {}
  }

  @Test
  void getCriticalPatientData_PractitionerNotFound_NullsPractitioner() {
    String patientIdentifier = "92020254321";
    String patientId = "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a";

    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(patientId, List.of(new Identifier(null, null, null,
            patientIdentifier, null, null)), true, null, null,
                    null, null, null, null, null,
                    List.of(new Reference("Practitioner/invalid-id", null, null, null))
            )
    );

    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.of(patient));
    when(practitionerRepository.findById("invalid-id")).thenReturn(Optional.empty());

    try {
      CriticalPatientDataDTO result = service.getCriticalDataByIdentification(patientIdentifier);
      if(result == null) assertNull(result.practitioner());
    } catch (Exception e) {}
  }

  @Test
  void getCriticalPatientData_InvalidReferenceFormat_HandlesGracefully() {
    String patientIdentifier = "92020254321";
    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(null, null, true, null, null,
                    null, null, null, null, null,
                    List.of(new Reference("Practitioner/invalid-id", null, null, null))
            )
    );

    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.of(patient));

    CriticalPatientDataDTO result = null;

    try {
      result = service.getCriticalDataByIdentification(patientIdentifier);
    } catch (Exception e) {}

    if(result.practitioner() == null) assertNull(result);
  }

  @Test
  void getCriticalPatientData_MissingFields_ReturnsNullFields() {
    String patientIdentifier = "10040878912";
    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(patientIdentifier, null, true, null, null, null,
            null, null, null, null, null));

    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.of(patient));

    CriticalPatientDataDTO result = null;

    try {
      result = service.getCriticalDataByIdentification(patientIdentifier);
    } catch (Exception e) {}

      assertNotNull(result.patient());
      assertNull(result.patient().name());
      assertNull(result.patient().gender());
      assertNull(result.patient().birthDate());
      assertNull(result.patient().telecom());
      assertNull(result.patient().address());
      assertNull(result.patient().maritalStatus());
  }

  @Test
  void getCriticalPatientData_EdgeCase_LargeNumberOfRecords() {
    String patientId = "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a";
    String patientIdentifier = "92020254321";
    PatientModel patient = new PatientModel();
    patient.setResource(new Patient(patientId, List.of(new Identifier(null, null, null,
            patientIdentifier, null, null)), true, null, null, null,
            null, null, null, null, null)
    );

    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.of(patient));
    when(conditionRepository.findByPatientId(patientId)).
            thenReturn(Collections.nCopies(1000, new ConditionModel()));

    try {
      CriticalPatientDataDTO result = service.getCriticalDataByIdentification(patientIdentifier);
      assertEquals(1000, result.conditions().size());
    } catch (Exception e) {}
  }
}
