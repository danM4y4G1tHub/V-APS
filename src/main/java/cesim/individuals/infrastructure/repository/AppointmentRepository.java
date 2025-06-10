package cesim.individuals.infrastructure.repository;

import cesim.individuals.infrastructure.repository.models.AppointmentModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.LocalDate;

@Tag(
        name = "Appointments",
        description = "The appointments related service"
)
@RepositoryRestResource(path = "Appointments")
public interface AppointmentRepository extends JpaRepository<AppointmentModel, String>,
        JpaSpecificationExecutor<AppointmentModel>,
        CrudRepository<AppointmentModel, String>,
        PagingAndSortingRepository<AppointmentModel, String> {
  @RestResource()
  @Query(value = "SELECT a.id, " +
          "a.resource->>'start' AS scheduled_date, " +
          "p.id, " +
          "p.resource->'name'->0->>'family', " +
          "p.resource->'name'->0->>'given' " +
          "FROM appointments a " +
          "LEFT JOIN encounters e ON e.resource->'appointment'->>'reference' = 'Appointment/' || a.id " +
          "JOIN patients p ON p.id = split_part(a.resource->'participant'->0->'actor'->>'reference', '/', 2) " +
          "WHERE e.id IS NULL " +
          "AND a.resource->>'status' = 'booked' " +
          "AND to_date(a.resource->>'start', 'YYYY-MM-DD') BETWEEN :startDate AND :endDate",
          nativeQuery = true)
  Page<Object[]> findAbsencesByDateRange(
          Pageable pageable,
          @Param("startDate") LocalDate startDate,
          @Param("endDate") LocalDate endDate
  );
}
