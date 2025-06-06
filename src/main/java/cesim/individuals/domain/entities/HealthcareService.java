package cesim.individuals.domain.entities;

import java.util.List;

public record HealthcareService(
        String resourceType,
        String id,
        Meta meta,
        Narrative text,
        List<Identifier> identifier,
        Boolean active,
        Reference providedBy,
        List<CodeableConcept> category,
        List<CodeableConcept> type,
        List<CodeableConcept> specialty,
        List<Reference> location,
        String name,
        String comment,
        String extraDetails,
        Attachment photo,
        List<ContactPoint> telecom,
        List<Reference> coverageArea,
        List<CodeableConcept> serviceProvisionCode,
        List<Eligibility> eligibility,
        List<CodeableConcept> program,
        List<CodeableConcept> characteristic,
        List<CodeableConcept> communication,
        List<CodeableConcept> referralMethod,
        Boolean appointmentRequired,
        List<AvailableTime> availableTime,
        List<NotAvailable> notAvailable,
        String availabilityExceptions,
        List<Reference> endpoint
) {

  public record Eligibility(
          CodeableConcept code,
          String comment
  ) {
  }

  public record AvailableTime(
          List<String> daysOfWeek,
          Boolean allDay,
          String availableStartTime,
          String availableEndTime
  ) {
  }

  public record NotAvailable(
          String description,
          Period during
  ) {
  }
}
