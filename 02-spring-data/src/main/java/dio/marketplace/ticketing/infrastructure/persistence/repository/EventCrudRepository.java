package dio.marketplace.ticketing.infrastructure.persistence.repository;

import dio.marketplace.ticketing.infrastructure.persistence.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false, path = "_event")
public interface EventCrudRepository extends CrudRepository<Event, UUID> {
    boolean existsByCorrelationIdAndSectors_Seats_CorrelationId(UUID eventId, String seatId);
}
