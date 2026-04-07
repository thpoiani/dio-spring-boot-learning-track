package dio.marketplace.catalog.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private SeatId id;
    private SectorId sectorId;

    public Seat(SeatId id, SectorId sectorId) {
        this.id = id;
        this.sectorId = sectorId;
    }
}
