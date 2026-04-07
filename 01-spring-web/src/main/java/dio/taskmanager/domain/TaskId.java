package dio.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record TaskId(UUID id) {
    public TaskId {
        Assert.notNull(id, "id must not be null");
    }

    public TaskId() {
        this(UUID.randomUUID());
    }
}
