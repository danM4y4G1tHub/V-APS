package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.MedicationRequest;
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
@Table(name = "medication_requests")
public class MedicationRequestModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private MedicationRequest resource;

  @CreatedDate
  private LocalDateTime timestamp;

  private MedicationRequestModel.Type type;
  private MedicationRequestModel.Status status;

  public MedicationRequest getResource() {
    return resource;
  }

  public void setResource(MedicationRequest resource) {
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
