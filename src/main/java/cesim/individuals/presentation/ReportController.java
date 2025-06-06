package cesim.individuals.presentation;

import cesim.individuals.application.report.ReportScheduler;
import cesim.individuals.domain.entities.report.outputDTO.*;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.specInput.ClinicalReportFilterSpec;
import cesim.individuals.domain.entities.report.specInput.RecentEncounterSpec;
import cesim.individuals.domain.usecases.report.*;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {
  private final GenerateDerivationReportUsecase derivationReportUseCase;
  private final GetCriticalPatientDataUseCase criticalPatientDataUseCase;
  private final ClinicalReportFilterUseCase clinicalReportFilterUseCase;
  private final AdvancedSearchUseCase advancedSearchUsecase;
  private final GetRecentEncountersUseCase recentEncountersUseCase;
  private final AssessPatientsRiskUseCase assessPatientsRiskUsecase;
  private final ReportScheduler reportScheduler;

  @GetMapping("/derivation/{patienId}")
  public CompletableFuture<DerivationReportDTO> generateDerivationReport(@PathVariable String patienId) {
    return derivationReportUseCase.execute(
                    new GenerateDerivationReportUsecase.Input(patienId))
            .thenApply(GenerateDerivationReportUsecase.Output::derivationReport);
  }

  @GetMapping("/urgency/{CI}")
  public CompletableFuture<CriticalPatientDataDTO> getCriticalPatienData(@PathVariable String CI) {
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
          @RequestBody ClinicalReportFilterSpec filterSpecs
  ) {
    return clinicalReportFilterUseCase.execute(
            new ClinicalReportFilterUseCase.Input(
                    new Pageable(page, size, sortBy, sortDirection),
                    filterSpecs)
    ).thenApply(ClinicalReportFilterUseCase.Output::clinicalReportDTO);
  }

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

  @GetMapping("/monthly-report")
  public String getMonthlyReport() {
    System.out.println("Requesting Monthly Report");
    reportScheduler.generateMonthlyReport();
    return "";
  }

  // Download PDF ReportMonthly
  // Download EXCEL ReportMonthly
}
