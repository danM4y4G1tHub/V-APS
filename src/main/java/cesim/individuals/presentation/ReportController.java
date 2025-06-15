package cesim.individuals.presentation;

import cesim.individuals.application.report.ReportScheduler;
import cesim.individuals.domain.entities.report.outputDTO.*;
import cesim.individuals.domain.entities.report.specInput.AbsenceTrackingSpec;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.usecases.report.*;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
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

  //RF02
  @GetMapping("/urgency/{CI}")
  public CompletableFuture<CriticalPatientDataDTO> getCriticalPatientData(@PathVariable String CI) {
    return criticalPatientDataUseCase.execute(
                    new GetCriticalPatientDataUseCase.Input(CI))
            .thenApply(GetCriticalPatientDataUseCase.Output::patientData);
  }

  //RF03
  @PostMapping("/filter")
  public CompletableFuture<ClinicalReportDTO> reportFilter(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestBody ClinicalReportFilterSpec filterSpecs
  ) {
    return clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    filterSpecs)
    ).thenApply(ClinicalReportFilterUseCase.Output::clinicalReportDTO);
  }

  //RF04
  @GetMapping("/derivation/{patientId}")
  public CompletableFuture<DerivationReportDTO> generateDerivationReport(@PathVariable String patientId) {
    return derivationReportUseCase.execute(
                    new GenerateDerivationReportUsecase.Input(patientId))
            .thenApply(GenerateDerivationReportUsecase.Output::derivationReport);
  }

  //RF05
  @PostMapping("/search")
  public CompletableFuture<AdvancedSearchResultsDTO> advancedSearch(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestBody AdvancedSearchRequestSpec searchRequest
  ) {
    return advancedSearchUsecase.execute(
                    new AdvancedSearchUseCase.Input(
                            new Pageable(page, size, sortBy, sortDirection),
                            searchRequest)
            )
            .thenApply(AdvancedSearchUseCase.Output::resultsDTO);
  }

  //RF06
  @PostMapping("/recent-encounters")
  public CompletableFuture<Page<RecentEncounterDTO>> recentEncounters(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestBody RecentEncounterSpec recentRequest
  ) {
    return recentEncountersUseCase.execute(
            new GetRecentEncountersUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    recentRequest
            )
    ).thenApply(GetRecentEncountersUseCase.Output::encounterDTO);
  }

  //RF07
  @PostMapping("/risk-priority")
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

  //RF10
  @GetMapping("/monthly-report")
  public String getMonthlyReport() {
    System.out.println("Requesting Monthly Report");
    reportScheduler.generateMonthlyReport();
    return "Request received successfully";
  }

  // Download PDF ReportMonthly
  // Download EXCEL ReportMonthly

  //RF12-Community
  @GetMapping("/community/{communityId}")
  public CompletableFuture<CommunityReportDTO> generateCommunityReport(
          @PathVariable String communityId
  ){
    return generateCommunityReportUseCase.execute(
            new GenerateCommunityReportUseCase.Input(communityId)
            )
            .thenApply(GenerateCommunityReportUseCase.Output::reportDTO);
  }

  //RF12-CDR
  @GetMapping("/cdrs/{communityId}")
  public CompletableFuture<List<CDRReportDTO>> generateCDRReports(
          @PathVariable String communityId
  ){
    return generateCDRReportsUseCase.execute(
            new GenerateCDRReportsUseCase.Input(communityId)
    ).thenApply(GenerateCDRReportsUseCase.Output::reportDTO);
  }

  //RF13
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

  //RF14
  @PostMapping("/absence")
  public CompletableFuture<Page<AbsenceReportDTO>> absenceTrackingReport(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
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
