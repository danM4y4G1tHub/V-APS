package cesim.individuals.infrastructure.repository.models;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import cesim.individuals.domain.entities.Person;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class PersonModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @CreatedDate
  private LocalDateTime timestamp;
  private PersonModel.Type type;
  @Column(columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private Person resource;
  private PersonModel.Status status;

  public Person getResource() {
    return resource;
  }

  public void setResource(Person resource) {
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
