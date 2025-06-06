package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Observation;
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
@Table(name = "observations")
public class ObservationModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @CreatedDate
  private LocalDateTime timestamp;
  private ObservationModel.Type type;
  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Observation resource;
  private ObservationModel.Status status;

  public Observation getResource() {
    return resource;
  }

  public void setResource(Observation resource) {
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
