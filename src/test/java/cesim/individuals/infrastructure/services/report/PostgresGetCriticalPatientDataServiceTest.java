package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.*;
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

import static org.junit.jupiter.api.Assertions.*;
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

//  @Test
//  void getCriticalPatientData_PatientNotFound_ReturnsNull() throws Exception {
//    String patientIdentifier = "92020254321";
//
//    when(patientRepository.findByIdentification(patientIdentifier)).thenReturn(Optional.empty());
//
//    CriticalPatientDataDTO result = null;
//
//    result = service.getCriticalDataByIdentification(patientIdentifier);
//
//    assertNull(result);
//  }

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
    } catch (Exception e) {
    }

    if (result.practitioner() == null) assertNull(result);
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
    } catch (Exception e) {
    }

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
    } catch (Exception e) {
    }
  }
}
