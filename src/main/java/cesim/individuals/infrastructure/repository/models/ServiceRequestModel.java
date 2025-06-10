package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.ServiceRequest;
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
@Table(name = "service_requests")
public class ServiceRequestModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private ServiceRequest resource;

  private ServiceRequestModel.Type type;
  private ServiceRequestModel.Status status;

  public String getId() {
    return id;
  }

  public ServiceRequest getResource() {
    return resource;
  }

  public void setResource(ServiceRequest resource) {
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
