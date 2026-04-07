package dio.marketplace.catalog.domain;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId() {
        this(UUID.randomUUID());
    }
}
