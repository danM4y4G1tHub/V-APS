package cesim.individuals.entity;

import cesim.individuals.domain.entities.Patient;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PatientValidator {
  public static void validate(Patient patient) {
    if (patient.birthDate() != null && patient.birthDate().isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Birth date cannot be in the future.");
    }

    if (Boolean.TRUE.equals(patient.deceasedBoolean()) && patient.deceasedDateTime() == null) {
      throw new IllegalArgumentException("Deceased patients must have a date of death.");
    }
  }
}
