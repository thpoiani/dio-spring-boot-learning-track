package dio.marketplace.catalog.application;

import dio.marketplace.catalog.domain.Event;
import dio.marketplace.catalog.domain.EventMetadataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventEnricher {
    private static final Logger logger = LoggerFactory.getLogger(EventEnricher.class);

    private final EventMetadataRepository eventMetadataRepository;

    public EventEnricher(EventMetadataRepository eventMetadataRepository) {
        this.eventMetadataRepository = eventMetadataRepository;
    }

    @Async
    public CompletableFuture<Event> enrich(Event event) {
        logger.info("Enriching event: {}", event);

        var metadata = eventMetadataRepository.findByEventId(event.getId());
        event.setMetadata(metadata);

        return CompletableFuture.completedFuture(event);
    }
}
