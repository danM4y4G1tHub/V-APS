package cesim.individuals.domain.usecases.specimen.dependencies;

import cesim.individuals.domain.entities.Specimen;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface GetSpecimensService {
  Page<Specimen> getSpecimensAfterDate(Pageable pageable, LocalDateTime afterDate);
}
