package dio.marketplace.catalog.infrastructure.event;

import dio.marketplace.catalog.infrastructure.persistence.entity.Event;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @PostPersist
    public void onEventCreated(Event event) {
        logger.info("Event created via @PostPersist {}", event);
    }

    @PostUpdate
    public void onEventUpdated(Event event) {
        logger.info("Event updated via @PostUpdate {}", event);
    }

    @PostRemove
    public void onEventDeleted(Event event) {
        logger.info("Event deleted via @PostRemove {}", event);
    }

}
