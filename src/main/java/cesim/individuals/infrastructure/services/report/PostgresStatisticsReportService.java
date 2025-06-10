package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.MonthlyStatisticsReportDTO;
import cesim.individuals.domain.usecases.report.dependencies.StatisticsReportService;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.EncounterRepository;
import cesim.individuals.infrastructure.repository.ObservationRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.EncounterModel;
import cesim.individuals.infrastructure.repository.models.ObservationModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import org.springframework.stereotype.Service;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresStatisticsReportService implements StatisticsReportService {
  private final PatientRepository patientRepository;
  private final ConditionRepository conditionRepository;
  private final EncounterRepository encounterRepository;
  private final ObservationRepository observationRepository;

  @Override
  public MonthlyStatisticsReportDTO generateMonthlyReport(YearMonth month) {
    LocalDate startDate = month.atDay(1);
    LocalDate endDate = month.atEndOfMonth();
    String startDateStr = startDate.toString();
    String endDateStr = endDate.plusDays(1).toString();

    List<PatientModel> allPatients = patientRepository.findAll();
    List<ConditionModel> monthlyConditions = conditionRepository.findByRecordedDate(startDateStr, endDateStr);
    List<EncounterModel> monthlyEncounters = encounterRepository.findByDateBetween(startDateStr, endDateStr);

    return new MonthlyStatisticsReportDTO(
            calculatePatientsByAgeGroup(allPatients),
            calculatePatientsByGender(allPatients),
            calculateChronicConditions(allPatients),
            calculateNewDiseaseCases(monthlyConditions),
            calculatePregnantWomen(allPatients, startDate, endDate),
            calculateOneYearOldChildren(allPatients, startDate),
            calculateConsultationsByPathology(monthlyEncounters)
    );
  }

  private Map<String, Integer> calculatePatientsByAgeGroup(List<PatientModel> allPatients) {
    Map<String, Integer> results = new TreeMap<>();

    allPatients.forEach(patient -> {
      LocalDate birthDate = patient.getResource().birthDate();

      if (birthDate != null) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        String ageGroup = getAgeGroup(age);
        results.put(ageGroup, results.getOrDefault(ageGroup, 0) + 1);
      }
    });

    return results;
  }

  private String getAgeGroup(int age) {
    if (age < 1) return "0-1";
    if (age <= 5) return "2-5";
    if (age <= 12) return "6-12";
    if (age <= 18) return "13-18";
    if (age <= 30) return "19-30";
    if (age <= 50) return "31-50";
    if (age <= 65) return "51-65";
    return "65+";
  }

  private Map<String, Integer> calculatePatientsByGender(List<PatientModel> allPatients) {
    return allPatients.stream().collect(Collectors.groupingBy(
            p -> p.getResource().gender().name(),
            Collectors.summingInt(p -> 1)
    ));
  }

  private Map<String, Integer> calculateChronicConditions(List<PatientModel> allPatients) {
    List<String> patientIds = allPatients.stream().map(PatientModel::getId).toList();

    List<ConditionModel> conditions = conditionRepository.findByPatientIds(patientIds);

    Map<String, Integer> results = new HashMap<>();
    results.put("HIPERTENCIÓN", countConditionsByCode(conditions, "38341003"));
    results.put("DIABETES", countConditionsByCode(conditions, "44054006"));
    results.put("ENFERMEDAD_CARDIACA", countConditionsByCode(conditions, "414545008"));

    return results;
  }

  private int countConditionsByCode(List<ConditionModel> conditions, String code) {
    return (int) conditions.stream()
            .filter(c -> c.getResource().code().coding().stream()
                    .anyMatch(coding -> code.equals(coding.code())
                    )
            ).count();
  }

  private int calculateNewDiseaseCases(List<ConditionModel> monthlyConditions) {
    return monthlyConditions.size();
  }

  private int calculatePregnantWomen(List<PatientModel> patients, LocalDate start, LocalDate end) {
    List<String> patientsId = patients.stream()
            .filter(p -> "female".equalsIgnoreCase(p.getResource().gender().name()))
            .map(PatientModel::getId).toList();

    return (int) observationRepository.findPregnancyObservations(patientsId, start.toString(), end.toString())
            .stream()
            .map(ObservationModel::getResource)
            .filter(obs -> "77386006".equals(obs.code().coding().get(0).code()))
            .count();
  }

  private int calculateOneYearOldChildren(List<PatientModel> patients, LocalDate start) {
    LocalDate oneYearAgo = start.minusYears(1);
    return (int) patients.stream().filter(p -> {
      LocalDate birthDate = p.getResource().birthDate();
      return birthDate != null && birthDate.isAfter(oneYearAgo) && birthDate.isBefore(oneYearAgo.plusDays(1));
    }).count();
  }

  private Map<String, Integer> calculateConsultationsByPathology(List<EncounterModel> monthlyEncounters) {
    return monthlyEncounters.stream()
            .flatMap(e -> e.getResource().reason().stream())
            .flatMap(r -> r.use().stream())
            .map(cc -> cc.text())
            .filter(text -> text != null && !text.trim().isEmpty())
            .collect(Collectors
                    .groupingBy(text -> text, Collectors.summingInt(text -> 1)));
  }
}
