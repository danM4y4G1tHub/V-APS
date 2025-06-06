package cesim.individuals.infrastructure.repository.models;

import cesim.individuals.domain.entities.Patient;
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
@Table(name = "patients")
public class PatientModel {


  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @CreatedDate
  private LocalDateTime timestamp;
  private PatientModel.Type type;
  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Patient resource;
  private PatientModel.Status status;

  public Patient getResource() {
    return resource;
  }

  public void setResource(Patient resource) {
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
