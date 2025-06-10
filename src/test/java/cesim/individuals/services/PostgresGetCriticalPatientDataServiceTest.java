package cesim.individuals.services;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;
import cesim.individuals.infrastructure.repository.*;
import cesim.individuals.infrastructure.repository.models.*;
import cesim.individuals.infrastructure.services.practitioner.PostgresGetPractitionerByIdService;
import cesim.individuals.infrastructure.services.report.PostgresGetCriticalPatientDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostgresGetCriticalPatientDataServiceTest {

  @Mock private PatientRepository patientRepo;
  @Mock private AllergyIntoleranceRepository allergyRepo;
  @Mock private MedicationRequestRepository medicationRepo;
  @Mock private ConditionRepository conditionRepo;
  @Mock private EncounterRepository encounterRepository;
  @Mock private ObservationRepository observationRepository;
  @Mock private PostgresGetPractitionerByIdService practitionerByIdService;
  @Mock private RelatedPersonRepository relatedPersonRepository;
  @Mock private CarePlanRepository carePlanRepository;

  @InjectMocks
  private PostgresGetCriticalPatientDataService service;

  @Test
  void getCriticalData_shouldReturnCompleteData() throws Exception {
    String testCI = "85010112345";

    Identifier identifier = new Identifier(
            Identifier.Use.OFFICIAL,
            new CodeableConcept(null, "CI"),
            "http://minsap.cu/ci",
            testCI, null, null
    );

    HumanName name = new HumanName(
            HumanName.Use.OFFICIAL,
            "Carlos García",
            "García", List.of("Carlos"),
            List.of("Sr."), List.of(), null
    );

    Patient mockPatientEntity = new Patient(
            "Patient", "pat-123",
            List.of(identifier), true,
            List.of(name), null,
            Patient.Gender.MALE,
            LocalDate.of(1985, 1, 1),
            false, null,
            null, null, null,
            null, null,
            null, null, null,
            null, null
    );

    PatientModel mockPatient = new PatientModel();
    mockPatient.setResource(mockPatientEntity);

    Encounter testEncounter = new Encounter(
            "Encounter", "enc-001", null, null, null, null,
            null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null
    );

    EncounterModel encounterModel = new EncounterModel();
    encounterModel.setResource(testEncounter);

    // Crea una referencia válida al practitioner
    Reference practitionerReference = new Reference(
            "Practitioner/prac-001",
            "Practitioner",
            new Identifier(null, null, null, null, null, null),
            null
    );

    MedicationRequest medicationRequest = new MedicationRequest(
            "MedicationRequest",
            "med-001",
            null, null, null, null, null, null, null, null, null, null, null, null, null, // 15
            null, null, null, null, null, null, null, null, null,
            practitionerReference,null, null, null, null, null,
            null, null, null,
            null, null);

    MedicationRequestModel mockMedicationModel = new MedicationRequestModel();
    mockMedicationModel.setResource(medicationRequest);

    when(patientRepo.findByIdentification(testCI))
            .thenReturn(Optional.of(mockPatient));
    when(allergyRepo.findByPatientId(any()))
            .thenReturn(List.of(new AllergyIntoleranceModel()));
    when(medicationRepo.findByPatientId(any()))
            .thenReturn(List.of(mockMedicationModel));
    when(encounterRepository.findByPatientId(any()))
            .thenReturn(List.of(encounterModel));
    when(conditionRepo.findByPatientId(any()))
            .thenReturn(List.of(new ConditionModel()));
    when(observationRepository.findByEncounterId(any()))
            .thenReturn(List.of(new ObservationModel()));
    when(relatedPersonRepository.getByPatientId(any()))
            .thenReturn(List.of(new RelatedPersonModel()));
    when(carePlanRepository.findByPatientId(any()))
            .thenReturn(List.of(new CarePlanModel()));
    when(practitionerByIdService.getById(any()))
            .thenReturn(new Practitioner(
                    "Practitioner", "prac-001", null,
                    true, null, null, null,
                    null, null, null, null,
                    null, null, null
            ));

    // Ejecutar
    CriticalPatientDataDTO result = service.getCriticalDataByIdentification(testCI);

    // Verificar
    assertNotNull(result);
    assertEquals("García", result.patient().name().get(0).family());
    verify(patientRepo, times(1)).findByIdentification(testCI);
  }

  @Test
  void getCriticalData_shouldThrowWhenPatientNotFound() {
    when(patientRepo.findByIdentification(any()))
            .thenReturn(Optional.empty());

    assertThrows(IllegalArgumentException.class, () -> {
      service.getCriticalDataByIdentification("invalid");
    });
  }
}
