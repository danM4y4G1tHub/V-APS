package cesim.individuals.infrastructure.repository.models;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import cesim.individuals.domain.entities.Practitioner;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "practitioners")
public class PractitionerModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedDate
  private LocalDateTime timestamp;

  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Practitioner resource;

  private PractitionerModel.Type type;
  private PractitionerModel.Status status;

  public Practitioner getResource() {
    return resource;
  }

  public void setResource(Practitioner resource) {
    this.resource = resource;
  }

  public String getId() {
    return id;
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
