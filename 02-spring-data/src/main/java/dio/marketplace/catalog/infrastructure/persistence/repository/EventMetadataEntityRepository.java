package dio.marketplace.catalog.infrastructure.persistence.repository;

import dio.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource
public interface EventMetadataEntityRepository extends MongoRepository<EventMetadata, String> {
    Optional<EventMetadata> findByEventId(UUID eventId);
}
