package dio.marketplace.ticketing.application;

import dio.marketplace.ticketing.domain.*;
import org.springframework.stereotype.Service;

@Service
public class SelectSeatUseCase {
    private final EventRepository eventRepository;

    public SelectSeatUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void execute(EventId eventId, SeatId seatId, CustomerId customerId) {
        if (!eventRepository.existsSeat(eventId, seatId)) {
            throw new SeatNotFoundException(eventId, seatId);
        }

        boolean lock = eventRepository.tryLockSeat(eventId, seatId, customerId);

        if (!lock) {
            throw new SeatAlreadyReservedException();
        }

        // Order, Payment, ...
    }
}
