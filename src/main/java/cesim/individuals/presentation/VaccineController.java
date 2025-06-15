package cesim.individuals.presentation;

import cesim.individuals.domain.entities.ImmunizationRecommendation;
import cesim.individuals.domain.entities.vaccine.VaccineReportDTO;
import cesim.individuals.domain.usecases.vacinne.GenerateVaccineReportUseCase;
import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/vaccine")
@RequiredArgsConstructor
public class VaccineController {
  private final GenerateVaccineReportUseCase generateVaccineReportUseCase;
  private final VaccineManagementService managementService;

  //RF11
  @GetMapping("/report")
  public CompletableFuture<VaccineReportDTO> generateVaccineReport(
          @RequestParam(value = "date", required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  ){
    if(date == null) date = LocalDate.now();

    return generateVaccineReportUseCase.execute(
            new GenerateVaccineReportUseCase.Input(date)
    ).thenApply(GenerateVaccineReportUseCase.Output::reportDTO);
  }

  @GetMapping("/schedule")
  public ResponseEntity<List<ImmunizationRecommendation>> getVaccineSchedules() {
    return ResponseEntity.ok(managementService.getVaccineRecommendations());
  }
}
