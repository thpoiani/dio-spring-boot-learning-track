package dio.marketplace.ticketing.domain;

import org.springframework.util.Assert;

public record SeatId(String id) {
    public SeatId {
        Assert.notNull(id, "id must not be null");
    }
}
