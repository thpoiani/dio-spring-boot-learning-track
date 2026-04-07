package dio.marketplace.ticketing.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId {
        Assert.notNull(id, "id must not be null");
    }

    public EventId(String id) {
        this(UUID.fromString(id));
    }
}
