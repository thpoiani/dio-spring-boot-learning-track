package dio.marketplace.catalog.infrastructure.persistence.entity;

import dio.marketplace.catalog.infrastructure.event.EventListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@EntityListeners(EventListener.class)
@Data
@RequiredArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @NotBlank
    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private Instant date;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdOn;
}
