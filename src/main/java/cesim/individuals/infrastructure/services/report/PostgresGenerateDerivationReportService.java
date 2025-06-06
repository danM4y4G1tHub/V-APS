package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.entities.report.outputDTO.DerivationReportDTO;
import cesim.individuals.domain.usecases.report.dependencies.GenerateDerivationReportService;
import cesim.individuals.infrastructure.repository.AllergyIntoleranceRepository;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.MedicationRequestRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.AllergyIntoleranceModel;
import cesim.individuals.infrastructure.repository.models.ConditionModel;
import cesim.individuals.infrastructure.repository.models.MedicationRequestModel;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostgresGenerateDerivationReportService implements GenerateDerivationReportService {
  private final PatientRepository patientRepository;
  private final ConditionRepository conditionRepository;
  private final MedicationRequestRepository medicationRequestRepository;
  private final AllergyIntoleranceRepository allergyIntoleranceRepository;

  @Override
  public DerivationReportDTO generateDerivationReport(String patientId) {
    PatientModel patientModel = patientRepository.findById(patientId)
            .orElseThrow(
                    () -> new EntityNotFoundException("Patient not found with id: " + patientId)
            );

    List<ConditionModel> conditions = conditionRepository.findByPatientId(patientId);
    List<MedicationRequestModel> medicationsRequest = medicationRequestRepository.findByPatientId(patientId);
    List<AllergyIntoleranceModel> allergies = allergyIntoleranceRepository.findByPatientId(patientId);

    Patient patient = patientModel.getResource();

    return new DerivationReportDTO(
            new DerivationReportDTO.PatientInfo(patient.name()),
            getDiagnostics(conditions),
            getTreatments(medicationsRequest),
            getAllergyIntolerances(allergies)
    );
  }

  private List<DerivationReportDTO.ConditionInfo> getDiagnostics(List<ConditionModel> conditions) {
    List<DerivationReportDTO.ConditionInfo> diagnostics = conditions.stream()
            .map(c ->
                    new DerivationReportDTO.ConditionInfo(c.getResource().code()))
            .collect(Collectors.toList());

    return diagnostics;
  }

  private List<DerivationReportDTO.MedicationInfo> getTreatments(List<MedicationRequestModel> medicationsRequest) {
    List<DerivationReportDTO.MedicationInfo> treatments = medicationsRequest.stream()
            .map(m ->
                    new DerivationReportDTO.MedicationInfo(m.getResource().dosageInstruction()))
            .collect(Collectors.toList());

    return treatments;
  }

  private List<DerivationReportDTO.AllergyInfo> getAllergyIntolerances(List<AllergyIntoleranceModel> allergies) {
    List<DerivationReportDTO.AllergyInfo> allergyIntolerances = allergies.stream()
            .map(a ->
                    new DerivationReportDTO.AllergyInfo(a.getResource().code()))
            .collect(Collectors.toList());

    return allergyIntolerances;
  }
}
