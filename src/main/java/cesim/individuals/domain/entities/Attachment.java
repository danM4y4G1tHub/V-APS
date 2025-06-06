package cesim.individuals.domain.entities;

import java.util.Date;

public record Attachment(
        Date creation,
        Double duration,
        Integer frames,
        Integer height,
        Integer pages,
        Integer width,
        Long size,
        String contentType,
        String data,
        String hash,
        String language,
        String title,
        String url) {
}
