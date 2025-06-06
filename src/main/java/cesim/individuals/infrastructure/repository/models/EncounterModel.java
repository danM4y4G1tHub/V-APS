package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Encounter;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "encounters")
public class EncounterModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Encounter resource;

  private EncounterModel.Type type;
  private EncounterModel.Status status;

  public Encounter getResource() {
    return resource;
  }

  public void setResource(Encounter resource) {
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
