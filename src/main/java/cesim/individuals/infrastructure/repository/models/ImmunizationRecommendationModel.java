package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.ImmunizationRecommendation;
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
@Table(name = "immunization_recommendations")
public class ImmunizationRecommendationModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private ImmunizationRecommendation resource;

  private ImmunizationRecommendationModel.Type type;
  private ImmunizationRecommendationModel.Status status;

  public String getId() {
    return id;
  }

  public ImmunizationRecommendation getResource() {
    return resource;
  }

  public void setResource(ImmunizationRecommendation resource) {
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
