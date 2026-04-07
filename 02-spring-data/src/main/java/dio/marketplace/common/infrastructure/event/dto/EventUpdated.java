package dio.marketplace.common.infrastructure.event.dto;


import dio.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;

import java.math.BigDecimal;
import java.util.List;


public record EventUpdated(String id, List<Sector> sectors) {

    public static EventUpdated from(EventMetadata event) {
        List<Sector> sectors = event.getSectors().stream()
                .map(s -> Sector.from(s, event.getSeats()))
                .toList();

        return new EventUpdated(event.getEventId().toString(), sectors);
    }

    public record Sector(String id, BigDecimal price, List<Seat> seats) {

        public static Sector from(EventMetadata.Sector sector, List<EventMetadata.Seat> allSeats) {
            List<Seat> sectorSeats = allSeats.stream()
                    .filter(seat -> seat.getSectorName().equals(sector.getName()))
                    .map(Seat::from)
                    .toList();

            return new Sector(sector.getName(), sector.getPrice(), sectorSeats);
        }

        public record Seat(String number) {
            public static Seat from(EventMetadata.Seat seat) {
                return new Seat(seat.getCode());
            }
        }
    }
}