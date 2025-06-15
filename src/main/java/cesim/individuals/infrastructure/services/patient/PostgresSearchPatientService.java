package cesim.individuals.infrastructure.services.patient;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cesim.individuals.domain.entities.Patient;
import cesim.individuals.domain.usecases.patient.dependencies.SearchPatientService;
import cesim.individuals.domain.utils.Page;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import cesim.individuals.infrastructure.repository.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;

import lombok.*;
import org.springframework.data.domain.PageRequest;

@Service
@RequiredArgsConstructor
public class PostgresSearchPatientService implements SearchPatientService {
    private final PatientRepository patientRepository;

    @Override
    public Page<Patient> search(Pageable pageable, String query) {
        Specification<PatientModel> spec = Specification.where(null);

        if (query != null && !query.isEmpty()) {
            var rootNode = new RSQLParser().parse(query);
            spec = rootNode.accept(new CustomRsqlVisitor<>());
        }

        var sort = Sort.by(
                pageable.sortDirection().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                pageable.sortBy());

        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        var results = patientRepository.findAll(spec, PageRequest.of(
                pageable.page(),
                pageable.size(),
                sort));

        return new Page<>(
                results.getNumber(),
                results.getSize(),
                results.getTotalPages(),
                results.toList().stream().map(PatientModel::getResource).toList());
    }
}
