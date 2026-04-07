package dio.marketplace.catalog.application;

import dio.marketplace.catalog.application.dto.EventOutput;
import dio.marketplace.catalog.domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BrowseShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);

    private final EventRepository eventRepository;
    private final EventEnricher eventEnricher;

    public BrowseShowcaseUseCase(EventRepository eventRepository, EventEnricher eventEnricher) {
        this.eventRepository = eventRepository;
        this.eventEnricher = eventEnricher;
    }

    @Cacheable(value = "showcase", unless = "#result.isEmpty()")
    public List<EventOutput> execute() {
        var futures = eventRepository.findAll().stream().map(eventEnricher::enrich).toList();

        var events = futures.stream()
                .map(CompletableFuture::join)
                .map(EventOutput::from)
                .toList();

        logger.info("{} events enriched", events.size());

        return events;
    }


}
