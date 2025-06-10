package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Immunization;
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
@Table(name = "immunizations")
public class ImmunizationModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Immunization resource;

  private ImmunizationModel.Type type;
  private ImmunizationModel.Status status;

  public String getId() {
    return id;
  }

  public Immunization getResource() {
    return resource;
  }

  public void setResource(Immunization resource) {
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
