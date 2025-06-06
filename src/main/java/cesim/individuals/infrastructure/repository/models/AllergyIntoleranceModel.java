package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.AllergyIntolerance;
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
@Table(name = "allergyIntolerances")
public class AllergyIntoleranceModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private AllergyIntolerance resource;

  private AllergyIntoleranceModel.Type type;
  private AllergyIntoleranceModel.Status status;

  public AllergyIntolerance getResource() {
    return resource;
  }

  public void setResource(AllergyIntolerance resource) {
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
