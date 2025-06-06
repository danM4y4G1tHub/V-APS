package cesim.individuals.domain.entities;

import java.util.List;

public record VirtualServiceDetail(
        String channelType,
        String addressUrl,
        String addressString,
        ContactPoint addressContactPoint,
        List<String> addressExtendedContactDetail,
        List<String> additionalInfo
) {}
