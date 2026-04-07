package dio.marketplace.catalog.domain;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();
}
