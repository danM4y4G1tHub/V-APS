package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.Practitioner;
import cesim.individuals.domain.entities.report.outputDTO.CriticalPatientDataDTO;
import cesim.individuals.domain.usecases.report.dependencies.GetCriticalPatientDataService;
import cesim.individuals.infrastructure.repository.*;
import cesim.individuals.infrastructure.repository.models.*;
import cesim.individuals.infrastructure.services.practitioner.PostgresGetPractitionerByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresGetCriticalPatientDataService implements GetCriticalPatientDataService {

  private final PatientRepository patientRepository;
  private final AllergyIntoleranceRepository intoleranceRepository;
  private final MedicationRequestRepository medicationReqRepository;
  private final ConditionRepository conditionRepository;
  private final EncounterRepository encounterRepository;
  private final ObservationRepository observationRepository;
  private final PostgresGetPractitionerByIdService practitionerByIdService;
  private final RelatedPersonRepository relatedPersonRepository;
  private final CarePlanRepository carePlanRepository;

  @Override
  public CriticalPatientDataDTO getCriticalDataByIdentification(String CI) throws Exception {
    try {
      PatientModel patientModel = patientRepository.findByIdentification(CI)
              .orElseThrow(() -> new IllegalArgumentException("Patient not found with CI: " + CI));

      Patient patient = patientModel.getResource();
      String patientId = patient.id();

      List<AllergyIntoleranceModel> intoleranceModels = intoleranceRepository.findByPatientId(patientId);

      List<MedicationRequestModel> medicationModels = medicationReqRepository.findByPatientId(patientId);

      List<ConditionModel> conditionModels = conditionRepository.findByPatientId(patientId);
      List<EncounterModel> encounterModels = encounterRepository.findByPatientId(patientId);
      List<ObservationModel> observationModels = new ArrayList<>();

      if (encounterModels.size() != 0) {
        String encounterId = encounterModels.get(0).getResource().id();
        observationModels = observationRepository.findByEncounterId(encounterId);
      }

      String practitionerReference = "";
      Practitioner practitioner = null;
      if (!medicationModels.isEmpty() &&
              medicationModels.get(0).getResource() != null &&
              medicationModels.get(0).getResource().requester() != null
      ) {
        practitionerReference = medicationModels.get(0).getResource().requester().reference();

        if(practitionerReference.contains("/")){
          String practitionerId = practitionerReference.split("/")[1];

          try {
          practitioner = practitionerByIdService.getById(practitionerId);

          } catch (RuntimeException ex){
            practitioner = null;
          }
        }
      }

      List<RelatedPersonModel> relatedPersonModels = relatedPersonRepository.getByPatientId(patientId);
      List<CarePlanModel> carePlanModel = carePlanRepository.findByPatientId(patientId);

      return new CriticalPatientDataDTO(
              createPatientInfo(patientModel),
              createAllergiesInfo(intoleranceModels),
              createMedicationsInfo(medicationModels),
              createContionsInfo(conditionModels),
              createEncounterInfo(encounterModels),
              createObservationsInfo(observationModels),
              createPractitionerInfo(practitioner),
              createRelatedPersonsInfo(relatedPersonModels),
              createCarePlansInfo(carePlanModel)
      );
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage(), e.getCause());
    }
  }

  private CriticalPatientDataDTO.PatientInfo createPatientInfo(PatientModel patientModel) {
    return new CriticalPatientDataDTO.PatientInfo(
            patientModel.getResource().name(),
            patientModel.getResource().gender(),
            patientModel.getResource().birthDate(),
            patientModel.getResource().telecom(),
            patientModel.getResource().address(),
            patientModel.getResource().maritalStatus()
    );
  }

  private List<CriticalPatientDataDTO.AllergiesInfo> createAllergiesInfo(List<AllergyIntoleranceModel> intoleranceModels) {
    if (intoleranceModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.AllergiesInfo> allergiesInfos = intoleranceModels.stream()
            .map(a ->
                    new CriticalPatientDataDTO.AllergiesInfo(
                            a.getResource().code(),
                            a.getResource().clinicalStatus(),
                            a.getResource().reaction()
                    )
            ).collect(Collectors.toList());

    return allergiesInfos;
  }

  private List<CriticalPatientDataDTO.MedicationsInfo> createMedicationsInfo(List<MedicationRequestModel> medicationModels) {
    if (medicationModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.MedicationsInfo> medicationsInfos = medicationModels.stream()
            .map(m ->
                    new CriticalPatientDataDTO.MedicationsInfo(
                            m.getResource().status(),
                            m.getResource().intent(),
                            m.getResource().medication(),
                            m.getResource().dosageInstruction(),
                            m.getResource().reasonCode()
                    )
            ).collect(Collectors.toList());

    return medicationsInfos;
  }

  private List<CriticalPatientDataDTO.ConditionsInfo> createContionsInfo(List<ConditionModel> conditionModels) {
    if (conditionModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.ConditionsInfo> conditions = conditionModels.stream()
            .map(c ->
                    new CriticalPatientDataDTO.ConditionsInfo(
                            c.getResource().clinicalStatus(),
                            c.getResource().code(),
                            c.getResource().recordedDate()
                    ))
            .collect(Collectors.toList());
    return conditions;
  }

  private List<CriticalPatientDataDTO.EncounterInfo> createEncounterInfo(List<EncounterModel> encounterModels) {
    if (encounterModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.EncounterInfo> encounterInfos = encounterModels.stream()
            .map(e ->
                    new CriticalPatientDataDTO.EncounterInfo(
                            e.getResource().actualPeriod(),
                            e.getResource().type(),
                            e.getResource().reason()
                    )
            )
            .collect(Collectors.toList());

    return encounterInfos;
  }

  private List<CriticalPatientDataDTO.ObservationsInfo> createObservationsInfo(List<ObservationModel> observationModels) {
    if (observationModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.ObservationsInfo> observationsInfos = observationModels.stream()
            .map(o ->
                    new CriticalPatientDataDTO.ObservationsInfo(
                            o.getResource().code(),
                            o.getResource().valueQuantity(),
                            o.getResource().effectiveDateTime()
                    )

            ).collect(Collectors.toList());

    return observationsInfos;
  }

  private CriticalPatientDataDTO.PractitionerInfo createPractitionerInfo(Practitioner practitioner) {
    if (practitioner == null) return new CriticalPatientDataDTO
            .PractitionerInfo(null, null, null);

    return new CriticalPatientDataDTO.PractitionerInfo(
            practitioner.name(),
            practitioner.identifier(),
            practitioner.qualification()
    );
  }

  private List<CriticalPatientDataDTO.RelatedPersonInfo> createRelatedPersonsInfo(List<RelatedPersonModel> relatedPersonModels) {
    if (relatedPersonModels.size() == 0) return new ArrayList<>();

    List<CriticalPatientDataDTO.RelatedPersonInfo> relatedPersonInfos = relatedPersonModels.stream()
            .map(r ->
                    new CriticalPatientDataDTO.RelatedPersonInfo(
                            r.getResource().name(),
                            r.getResource().relationship(),
                            r.getResource().telecom()
                    )
            ).collect(Collectors.toList());

    return relatedPersonInfos;
  }

  private List<CriticalPatientDataDTO.CarePlanInfo> createCarePlansInfo(List<CarePlanModel> carePlanModels) {
    if (carePlanModels.size() == 0) return new ArrayList<>();

    return carePlanModels.stream()
            .map(c -> {
                      return new CriticalPatientDataDTO.CarePlanInfo(
                              c.getResource().status(),
                              c.getResource().intent(),
                              c.getResource().activity()
                      );
                    }
            ).collect(Collectors.toList());
  }

}
