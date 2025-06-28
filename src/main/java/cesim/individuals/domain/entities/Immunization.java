package cesim.individuals.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Immunization(
        String resourceType,
        String id,
        List<Identifier> identifier,
        List<Reference> basedOn,
        Immunization.Status status,
        CodeableConcept statusReason,
        CodeableConcept vaccineCode,
        Reference administeredProduct,
        Reference manufacturer,
        String lotNumber,
        LocalDate expirationDate,
        Reference patient,
        Reference encounter,
        List<Reference> supportingInformation,
        LocalDateTime occurrenceDateTime,
        String occurrenceString,
        Boolean primarySource,
        Reference informationSource,
        Reference location,
        CodeableConcept site,
        CodeableConcept route,
        Quantity doseQuantity,
        List<Immunization.Performer> performer,
        List<Annotation> note,
        List<Reference> reason,
        Boolean isSubpotent,
        List<CodeableConcept> subpotentReason,
        List<Immunization.ProgramEligibility> programEligibility,
        CodeableConcept fundingSource,
        List<Immunization.Reaction> reaction,
        List<Immunization.ProtocolApplied> protocolApplied
) {

  public enum Status {
    COMPLETED("completed"),
    ENTERED_IN_ERROR("entered-in-error"),
    NOT_DONE("not-done");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public record Performer(
          CodeableConcept function,
          Reference actor
  ) {
  }

  public record ProgramEligibility(
          CodeableConcept program,
          CodeableConcept programStatus
  ) {
  }

  public record Reaction(
          LocalDateTime date,
          Reference manifestation,
          Boolean reported
  ) {
  }

  public record ProtocolApplied(
          String series,
          Reference authority,
          List<CodeableConcept> targetDisease,
          String doseNumber,
          String seriesDoses
  ) {
  }
}
