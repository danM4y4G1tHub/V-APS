package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Appointment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class AppointmentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Appointment resource;

  private AppointmentModel.Type type;
  private AppointmentModel.Status status;

  public String getId() {
    return id;
  }

  public Appointment getResource() {
    return resource;
  }

  public void setResource(Appointment resource) {
    this.resource = resource;
  }

  public enum Type {
    SYSTEM,
    VALUESET
  }

  public enum Status {
    DRAFT,
    ACTIVE,
    RETIRED
  }
}
