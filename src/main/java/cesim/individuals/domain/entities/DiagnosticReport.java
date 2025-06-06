package cesim.individuals.domain.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public record DiagnosticReport(
        String resourceType,
        String id,
        List<Identifier> identifier,
        List<Reference> basedOn,
        DiagnosticReport.Status status,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        LocalDateTime effectiveDateTime,
        Period effectivePeriod,
        Instant issued,
        List<Reference> performer,
        List<Reference> resultsInterpreter,
        List<Reference> specimen,
        List<Reference> result,
        List<Annotation> note,
        List<Reference> study,
        List<DiagnosticReport.SupportingInfo> supportingInfo,
        List<DiagnosticReport.Media> media,
        Reference composition,
        String conclusion,
        List<CodeableConcept> conclusionCode,
        List<Attachment> presentedForm
) {

  public enum Status {
    REGISTERED("registered"),
    PARTIAL("partial"),
    PRELIMINARY("preliminary"),
    MODIFIED("modified"),
    FINAL("final"),
    AMENDED("amended"),
    CORRECTED("corrected"),
    APPENDED("appended"),
    CANCELLED("cancelled"),
    ENTERED_IN_ERROR("entered-in-error"),
    UNKNOWN("unknown");

    private final String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record SupportingInfo(
          CodeableConcept type,
          Reference reference
  ) {
  }

  public record Media(
          String comment,
          Reference link
  ) {
  }
}
