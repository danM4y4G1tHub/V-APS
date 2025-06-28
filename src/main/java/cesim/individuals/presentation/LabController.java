package cesim.individuals.presentation;

import cesim.individuals.domain.entities.DiagnosticReport;
import cesim.individuals.domain.entities.Specimen;
import cesim.individuals.domain.usecases.specimen.GetSpecimensUseCase;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import lombok.*;

@RestController
@RequestMapping("/api/v1/lab")
@RequiredArgsConstructor
public class LabController {
  private final GetSpecimensUseCase getSpecimensUseCase;

  @PostMapping("/diagnostic-report")
//  @PreAuthorize("hasRole('LAB_TECHNICIAN')")
  public void createDiagnosticReport(@RequestBody DiagnosticReport diagnosticReport) {

  }

  //RF08
  @GetMapping("/specimen")
//  @PreAuthorize("hasRole('LAB_TECHNICIAN')")
  public CompletableFuture<Page<Specimen>> getSpecimens(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "asc") String sortDirection,
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestParam("after") LocalDateTime afterDate
  ) {
    return getSpecimensUseCase.execute(
                    new GetSpecimensUseCase.Input(
                            new Pageable(page, size, sortBy, sortDirection),
                            afterDate))
            .thenApply(GetSpecimensUseCase.Output::specimenPage);
  }
}
