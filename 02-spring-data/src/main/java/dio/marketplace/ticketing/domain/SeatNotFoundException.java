package dio.marketplace.ticketing.domain;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(EventId eventId, SeatId seatId) {
        super("Seat with id " + seatId + " not found");
    }
}
