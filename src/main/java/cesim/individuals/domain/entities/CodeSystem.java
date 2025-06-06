package cesim.individuals.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CodeSystem(
        Boolean caseSensitive,
        Boolean compositional,
        Boolean experimental,
        Boolean versionNeeded,
        Coding versionAlgorithmCoding,
        Integer count,
        List<CodeableConcept> jurisdiction,
        List<CodeableConcept> topic,
        List<Concept> concept,
        List<ContactDetail> author,
        List<ContactDetail> contact,
        List<ContactDetail> editor,
        List<ContactDetail> endorser,
        List<ContactDetail> reviewer,
        List<Filter> filter,
        List<Identifier> identifier,
        List<Property> property,
        List<RelatedArtifact> relatedArtifact,
        List<UsageContext> useContext,
        LocalDate approvalDate,
        LocalDate lastReviewDate,
        LocalDateTime date,
        Period effectivePeriod,
        String content,
        String copyright,
        String copyrightLabel,
        String description,
        String hierarchyMeaning,
        String id,
        String name,
        String publisher,
        String purpose,
        String status,
        String supplements,
        String title,
        String url,
        String valueSet,
        String version,
        String versionAlgorithmString) {
}
