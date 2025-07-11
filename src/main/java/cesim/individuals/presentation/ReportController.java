package cesim.individuals.presentation;

import cesim.individuals.application.report.ReportScheduler;
import cesim.individuals.domain.entities.report.WhenPresent;
import cesim.individuals.domain.entities.report.outputDTO.*;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.usecases.report.*;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
@Validated(WhenPresent.class)
public class ReportController {
  private final GetCriticalPatientDataUseCase criticalPatientDataUseCase;
  private final GenerateDerivationReportUsecase derivationReportUseCase;
  private final ClinicalReportFilterUseCase clinicalReportFilterUseCase;
  private final AdvancedSearchUseCase advancedSearchUsecase;
  private final GetRecentEncountersUseCase recentEncountersUseCase;
  private final AssessPatientsRiskUseCase assessPatientsRiskUsecase;
  private final ReportScheduler reportScheduler;
  private final GenerateCommunityReportUseCase generateCommunityReportUseCase;
  private final GenerateCDRReportsUseCase generateCDRReportsUseCase;
  private final MedicalStaffFilterUseCase medicalStaffFilterUseCase;
  private final GenerateAbsenceTrackingReportUseCase generateAbsenceTrackingReportUseCase;

  @GetMapping("/urgency/{CI}")
  public CompletableFuture<CriticalPatientDataDTO> getCriticalPatientData(
          @Valid @PathVariable
          String CI
  ) {
    return criticalPatientDataUseCase.execute(
                    new GetCriticalPatientDataUseCase.Input(CI))
            .thenApply(GetCriticalPatientDataUseCase.Output::patientData);
  }

  @PostMapping("/filter")
  public CompletableFuture<ClinicalReportDTO> reportFilter(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @Valid @RequestBody ClinicalReportFilterSpec filterSpecs
  ) {
    return clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    filterSpecs)
    ).thenApply(ClinicalReportFilterUseCase.Output::clinicalReportDTO);
  }

  @GetMapping("/derivation/{patientId}")
  public CompletableFuture<DerivationReportDTO> generateDerivationReport(
          @Valid @PathVariable
          @Pattern(
                  regexp = "^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$",                  message = "Invalid UUID",
                  flags = Pattern.Flag.CASE_INSENSITIVE
          )
          String patientId) {
    return derivationReportUseCase.execute(
                    new GenerateDerivationReportUsecase.Input(patientId))
            .thenApply(GenerateDerivationReportUsecase.Output::derivationReport);
  }

  @PostMapping("/search")
  public CompletableFuture<AdvancedSearchResultsDTO> advancedSearch(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @Valid @RequestBody AdvancedSearchRequestSpec searchRequest
  ) {
    return advancedSearchUsecase.execute(
                    new AdvancedSearchUseCase.Input(
                            new Pageable(page, size, sortBy, sortDirection),
                            searchRequest)
            )
            .thenApply(AdvancedSearchUseCase.Output::resultsDTO);
  }

  @PostMapping("/recent-encounters")
  public CompletableFuture<Page<RecentEncounterDTO>> recentEncounters(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @Valid @RequestBody RecentEncounterSpec recentRequest
  ) {
    return recentEncountersUseCase.execute(
            new GetRecentEncountersUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    recentRequest
            )
    ).thenApply(GetRecentEncountersUseCase.Output::encounterDTO);
  }

  @GetMapping("/risk-priority")
  public CompletableFuture<Page<PatientRiskPriorityDTO>> riskPriorityList(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy
  ) {
    return assessPatientsRiskUsecase.execute(
            new AssessPatientsRiskUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection))
    ).thenApply(AssessPatientsRiskUseCase.Output::riskPriorities);
  }

  @GetMapping("/monthly-report")
  public String getMonthlyReport() {
    System.out.println("Requesting Monthly Report");
    reportScheduler.generateMonthlyReport();
    return "Request received successfully";
  }

  @GetMapping("/community/{communityId}")
  public CompletableFuture<CommunityReportDTO> generateCommunityReport(
          @Valid @PathVariable
          @Pattern(
                  regexp = "^[0-9a-zA-Z]{5}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$",
                  message = "Invalid UUID",
                  flags = Pattern.Flag.CASE_INSENSITIVE
          )
          String communityId
  ){
    return generateCommunityReportUseCase.execute(
            new GenerateCommunityReportUseCase.Input(communityId)
            )
            .thenApply(GenerateCommunityReportUseCase.Output::reportDTO);
  }

  @GetMapping("/cdrs/{communityId}")
  public CompletableFuture<List<CDRReportDTO>> generateCDRReports(
          @Valid @PathVariable
          @NotBlank(message = "Community´s id can't be empty")
          @Pattern(
                  regexp = "^[0-9a-zA-Z]{5}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$",
                  message = "Invalid UUID",
                  flags = Pattern.Flag.CASE_INSENSITIVE
          )
          String communityId
  ){
    return generateCDRReportsUseCase.execute(
            new GenerateCDRReportsUseCase.Input(communityId)
    ).thenApply(GenerateCDRReportsUseCase.Output::reportDTO);
  }

  @GetMapping("/medical-staff")
  public CompletableFuture<Page<MedicalStaffCountDTO>> generateMedicalStaffFilter(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy
  ){
    return medicalStaffFilterUseCase.execute(
            new MedicalStaffFilterUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection)
            )
    ).thenApply(MedicalStaffFilterUseCase.Output::resultsDTO);
  }

  @PostMapping("/absence")
  public CompletableFuture<Page<AbsenceReportDTO>> absenceTrackingReport(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @Valid
          @Validated(WhenPresent.class)
          @RequestBody() AbsenceTrackingSpec trackingSpec
          ){
    return generateAbsenceTrackingReportUseCase.execute(
            new GenerateAbsenceTrackingReportUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    trackingSpec
            )
    ).thenApply(GenerateAbsenceTrackingReportUseCase.OutPut::reportDTO);
  }
}
