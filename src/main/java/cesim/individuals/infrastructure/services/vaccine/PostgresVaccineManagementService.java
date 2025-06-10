package cesim.individuals.infrastructure.services.vaccine;

import cesim.individuals.domain.entities.Immunization;
import cesim.individuals.domain.entities.ImmunizationRecommendation;
import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;
import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;
import cesim.individuals.infrastructure.repository.ImmunizationRecommendationRepository;
import cesim.individuals.infrastructure.repository.ImmunizationRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ImmunizationModel;
import cesim.individuals.infrastructure.repository.models.ImmunizationRecommendationModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresVaccineManagementService implements VaccineManagementService {

  private final ImmunizationRepository immunizationRepository;
  private final PatientRepository patientRepository;
  private final ImmunizationRecommendationRepository recommendationRepository;
  private final List<ImmunizationRecommendation> vaccineRecommendations;

  @Override
  public VaccineReportDTO generateVaccineReport(LocalDate reportDate) {
    List<ImmunizationModel> allImmunizations = immunizationRepository.findAll();
    Map<String, List<Immunization>> immunizationsByPatient = allImmunizations.stream()
            .collect(Collectors.groupingBy(
                    imm -> imm.getResource().patient().reference().split("/")[1],
                    Collectors.mapping(ImmunizationModel::getResource, Collectors.toList())
            ));

    List<PatientModel> patientModels = patientRepository.findAll();

    List<VaccineReportDTO.PatientVaccineStatus> statuses = new ArrayList<>();
    List<VaccineReportDTO.UpcomingDoseAlert> alerts = new ArrayList<>();
    List<ImmunizationRecommendationModel> recommendationModels =
            recommendationRepository.findAll();

    for (PatientModel pm : patientModels) {
      Patient patient = pm.getResource();
      String patientId = pm.getId();
      LocalDate birthDate = patient.birthDate();
      if (birthDate == null) continue;

      List<Immunization> patientImmunizations = immunizationsByPatient.getOrDefault(patientId, List.of());

      for (ImmunizationRecommendationModel rec : recommendationModels) {
        if (!rec.getResource().patient().reference().endsWith(patientId)) continue;

        for (ImmunizationRecommendation.Recommendation recommendation : rec.getResource().recommendation()) {
          String vaccineId = recommendation.vaccineCode().coding().get(0).code();
          String vaccineName = recommendation.vaccineCode().coding().get(0).display();
          int appliedDoses = countAppliedDoses(patientImmunizations, vaccineId);
          int nextDoseNumber = Integer.parseInt(recommendation.doseNumber());
          LocalDate nextDoseDate = recommendation.dateCriterion().get(0).value().toLocalDate();

          statuses.add(new VaccineReportDTO.PatientVaccineStatus(
                  patientId,
                  patient.name().get(0).given().get(0) + " " + patient.name().get(0).family(),
                  vaccineName,
                  appliedDoses,
                  nextDoseNumber,
                  nextDoseDate
          ));

          if (nextDoseDate.isBefore(reportDate.plusWeeks(2))) {
            alerts.add(new VaccineReportDTO.UpcomingDoseAlert(
                    patientId,
                    patient.name().get(0).given().get(0) + " " + patient.name().get(0).family(),
                    vaccineName,
                    nextDoseNumber,
                    nextDoseDate
            ));
          }
        }
      }
    }

    return new VaccineReportDTO(statuses, alerts);
  }

  private int countAppliedDoses(List<Immunization> immunizations, String vaccineId) {
    return (int) immunizations.stream()
            .filter(imm -> vaccineId.equals(imm.vaccineCode().coding().get(0).code())).count();
  }

  public List<ImmunizationRecommendation> getVaccineRecommendations() {
    return vaccineRecommendations;
  }
}


//package cesim.individuals.infrastructure.services.vaccine;
//
//import cesim.individuals.domain.entities.Immunization;
//import cesim.individuals.domain.entities.Patient;
//import cesim.individuals.domain.entities.vaccine.OfficialVaccineCalendar;
//import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;
//import cesim.individuals.domain.entities.vaccine.VaccineScheduleDTO;
//import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;
//import cesim.individuals.infrastructure.repository.ImmunizationRepository;
//import cesim.individuals.infrastructure.repository.PatientRepository;
//import cesim.individuals.infrastructure.repository.models.ImmunizationModel;
//import cesim.individuals.infrastructure.repository.models.PatientModel;
//import org.springframework.stereotype.Service;
//
//import lombok.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class PostgresVaccineManagementService implements VaccineManagementService {
//
//  private final ImmunizationRepository immunizationRepository;
//  private final PatientRepository patientRepository;
//  private final OfficialVaccineCalendar officialVaccineCalendar;
//
//  @Override
//  public VaccineReportDTO generateVaccineReport(LocalDate reportDate) {
//    List<ImmunizationModel> allImmunizations = immunizationRepository.findAll();
//    Map<String, List<Immunization>> immunizationsByPatient = allImmunizations.stream()
//            .collect(Collectors.groupingBy(
//                    imm -> imm.getResource().patient().reference().split("/")[1],
//                    Collectors.mapping(ImmunizationModel::getResource, Collectors.toList())
//            ));
//
//    List<PatientModel> patientModels = patientRepository.findAll();
//
//    List<VaccineReportDTO.PatientVaccineStatus> statuses = new ArrayList<>();
//    List<VaccineReportDTO.UpcomingDoseAlert> alerts = new ArrayList<>();
//
//    for(PatientModel pm: patientModels){
//      Patient patient = pm.getResource();
//      String patientId = pm.getId();
//      LocalDate birthDate = pm.getResource().birthDate();
//
//      if(birthDate == null) continue;
//
//      List<Immunization> patientImmunizations = immunizationsByPatient.getOrDefault(patientId, List.of());
//
//      for (VaccineScheduleDTO vaccine: officialVaccineCalendar.getSchedules()){
//        int appliedDoses = countAppliedDoses(patientImmunizations, vaccine.vaccineId());
//
//        VaccineScheduleDTO.DoseSchedule nextDose = findNextDose(vaccine, appliedDoses, birthDate, reportDate);
//
//        if(nextDose != null){
//          LocalDate nextDoseDate = calculateNextDoseDate(birthDate, nextDose, reportDate);
//
//          statuses.add(new VaccineReportDTO.PatientVaccineStatus(
//                  patientId,
//                  patient.name().get(0).given().get(0) + " " + patient.name().get(0).family(),
//                  vaccine.displayName(),
//                  appliedDoses,
//                  nextDose.doseNumber(),
//                  nextDoseDate
//          ));
//
//          if(nextDoseDate.isBefore(reportDate.plusWeeks(2))) {
//            alerts.add(new VaccineReportDTO.UpcomingDoseAlert(
//                    patientId,
//                    patient.name().get(0).given().get(0) + " " + patient.name().get(0).family(),
//                    vaccine.displayName(),
//                    nextDose.doseNumber(),
//                    nextDoseDate
//            ));
//          }
//        }
//      }
//
//    }
//      return new VaccineReportDTO(statuses, alerts);
//  }
//
//
//  private int countAppliedDoses(List<Immunization> immunizations, String vaccineId){
//    return (int) immunizations.stream()
//            .filter(imm -> vaccineId.equals(imm.vaccineCode()
//                    .coding().get(0).code())).count();
//  }
//
//  private VaccineScheduleDTO.DoseSchedule findNextDose(
//          VaccineScheduleDTO vaccine, int appliedDoses, LocalDate birthDate, LocalDate reportDate){
//    List<VaccineScheduleDTO.DoseSchedule> doses = vaccine.doseSchedules();
//
//    if(appliedDoses >= doses.size()) return null;
//
//    VaccineScheduleDTO.DoseSchedule nextDose = doses.get(appliedDoses);
//    LocalDate minDate = birthDate.plus(nextDose.minAge());
//
//    return minDate.isBefore(reportDate) || minDate.isEqual(reportDate) ? nextDose : null;
//  }
//
//  private LocalDate calculateNextDoseDate(LocalDate birthDate, VaccineScheduleDTO.DoseSchedule dose, LocalDate reportDate){
//    LocalDate minDate  = birthDate.plus(dose.minAge());
//    return minDate.isAfter(reportDate) ? minDate : reportDate.plus(dose.recommendedInterval());
//  }
//
//}
