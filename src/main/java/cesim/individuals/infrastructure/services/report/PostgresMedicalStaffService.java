package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.report.outputDTO.MedicalStaffCountDTO;
import cesim.individuals.domain.usecases.report.dependencies.MedicalStaffFilterService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.OrganizationRepository;
import cesim.individuals.infrastructure.repository.PractitionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostgresMedicalStaffService implements MedicalStaffFilterService {
  private final OrganizationRepository organizationRepository;
  private final PractitionerRepository practitionerRepository;

  @Override
  public Page<MedicalStaffCountDTO> countDoctorsByClinic(Pageable pageable){
    var organizationSort  = Sort.by(
            pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
            pageable.sortBy());

    var organizations = organizationRepository.countDoctorsByClinic(
            PageRequest.of(pageable.page(), pageable.size(), organizationSort)
    );

    List<MedicalStaffCountDTO> counts = organizations.stream()
            .map(or -> new MedicalStaffCountDTO(
                    (String) or[0],
                    ((Number) or[1]).longValue()
            )).toList();

    return new Page<>(
            organizations.getNumber(),
            organizations.getSize(),
            organizations.getTotalPages(),
            counts
    );
  }
}
