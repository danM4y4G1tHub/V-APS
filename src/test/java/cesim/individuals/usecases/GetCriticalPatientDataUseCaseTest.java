package cesim.individuals.usecases;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;
import cesim.individuals.domain.usecases.report.GetCriticalPatientDataUseCase;
import cesim.individuals.domain.usecases.report.dependencies.GetCriticalPatientDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetCriticalPatientDataUseCaseTest {

  @Mock
  private GetCriticalPatientDataService dataService;

  @InjectMocks
  private GetCriticalPatientDataUseCase useCase;

  @Test
  void execute_shouldReturnPatientData() throws Exception {
    // Configurar mock
    String testCI = "85010112345";

    CriticalPatientDataDTO mockData = new CriticalPatientDataDTO(
            // PatientInfo
            new CriticalPatientDataDTO.PatientInfo(
                    List.of(new HumanName(
                            HumanName.Use.OFFICIAL,
                            "Carlos García",
                            "García",
                            List.of("Carlos"),
                            List.of("Sr."),
                            List.of(),
                            null
                    )),
                    Patient.Gender.MALE,
                    LocalDate.of(1985, 1, 1),
                    List.of(new ContactPoint(
                            ContactPoint.System.PHONE,
                            "+5355512345",
                            ContactPoint.Use.HOME,
                            null,
                            null
                    )),
                    List.of(new Address(
                            Address.Type.BOTH,
                            Address.Use.HOME,
                            List.of("Calle 23 #456"),
                            null,
                            "La Habana",
                            "Cuba",
                            "Plaza",
                            "10400",
                            "Calle 23 #456, Plaza, La Habana, Cuba",
                            null,
                            null
                    )),
                    new CodeableConcept(null, "Soltero")
            ),

            // AllergiesInfo
            List.of(new CriticalPatientDataDTO.AllergiesInfo(
                    new CodeableConcept(null, "Polvo doméstico"),
                    new CodeableConcept(null, "activo"),
                    List.of(new AllergyIntolerance.Reaction(
                            new CodeableConcept(
                                    null,
                                    "Estornudos"),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    ))
            )),

            // MedicationsInfo
            List.of(new CriticalPatientDataDTO.MedicationsInfo(
                    MedicationRequest.Status.ACTIVE,
                    MedicationRequest.Intent.ORDER,
                    new Reference("Medication/aspirin", "Medication", null, "Aspirina"),
                    List.of(new Dosage(
                            1,
                            "Tomar una cada 8 horas",
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    )),
                    List.of(new CodeableConcept(null, "Dolor de cabeza"))
            )),

            // ConditionsInfo
            List.of(new CriticalPatientDataDTO.ConditionsInfo(
                    new CodeableConcept(null, "Activo"),
                    new CodeableConcept(null, "Hipertensión arterial"),
                    LocalDateTime.of(2023, 5, 12, 14, 30)
            )),

            // EncounterInfo
            List.of(new CriticalPatientDataDTO.EncounterInfo(
                    new Period(new Date(), new Date()),
                    List.of(new CodeableConcept(null, "Consulta general")),
                    List.of(new Encounter.Reason(
                            List.of(new CodeableConcept(
                                    null,
                                    "Dolor persistente")),
                            null))
            )),

            // ObservationsInfo
            List.of(new CriticalPatientDataDTO.ObservationsInfo(
                    new CodeableConcept(null, "Presión arterial"),
                    new Quantity(120.0, null, "mmHg", null, null),
                    LocalDateTime.of(2023, 5, 12, 14, 30)
            )),

            // PractitionerInfo
            new CriticalPatientDataDTO.PractitionerInfo(
                    List.of(new HumanName(
                            HumanName.Use.OFFICIAL,
                            "Dr. Juan Pérez",
                            "Pérez",
                            List.of("Juan"),
                            List.of("Dr."),
                            List.of(),
                            null
                    )),
                    List.of(new Identifier(
                            Identifier.Use.OFFICIAL,
                            null,
                            "http://hospital.cu/doctor-id",
                            "DR-001",
                            null,
                            null
                    )),
                    List.of(new Practitioner.Qualification(
                            null,
                            new CodeableConcept(
                                    null,
                                    "Médico General")
                            ,
                            null,
                            null
                    ))
            ),

            // RelatedPersonInfo
            List.of(new CriticalPatientDataDTO.RelatedPersonInfo(
                    List.of(new HumanName(
                            HumanName.Use.OFFICIAL,
                            "Ana García",
                            "García",
                            List.of("Ana"),
                            List.of(),
                            List.of(),
                            null
                    )),
                    List.of(new CodeableConcept(null, "Madre")),
                    List.of(new ContactPoint(
                            ContactPoint.System.PHONE,
                            "+5355587654",
                            ContactPoint.Use.MOBILE,
                            null,
                            null
                    ))
            )),

            // CarePlanInfo
            List.of(new CriticalPatientDataDTO.CarePlanInfo(
                    CarePlan.Status.ACTIVE,
                    CarePlan.Intent.PLAN,
                    List.of(new CarePlan.Activity(
                                    null,
                                    null,
                                    null
                            )
                    )
            ))
    );


    when(dataService.getCriticalDataByIdentification(testCI)).thenReturn(mockData);

    // Ejecutar
    var result = useCase.execute(new GetCriticalPatientDataUseCase.Input(testCI)).get();

    // Verificar
    assertEquals(mockData, result.patientData());
    verify(dataService, times(1)).getCriticalDataByIdentification(testCI);
  }

  @Test
  void execute_shouldPropagateException() throws Exception {
    when(dataService.getCriticalDataByIdentification(any())).thenThrow(new RuntimeException("Error de prueba"));

    assertThrows(RuntimeException.class, () -> {
      useCase.execute(new GetCriticalPatientDataUseCase.Input("invalid")).join();
    });
  }
}
