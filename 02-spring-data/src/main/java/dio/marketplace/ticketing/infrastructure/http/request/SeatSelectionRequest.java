package dio.marketplace.ticketing.infrastructure.http.request;

import dio.marketplace.ticketing.domain.SeatId;

public record SeatSelectionRequest(String id) {
    public SeatId toInput() {
        return new SeatId(id);
    }
}
