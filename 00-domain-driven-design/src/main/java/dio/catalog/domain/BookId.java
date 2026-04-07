package dio.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID id) {
    public BookId {
        Assert.notNull(id, "Book ID cannot be null");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
