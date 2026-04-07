package dio.catalog.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    private UUID id;
    private String title;
    private String isbn;

    @CreationTimestamp
    private Instant createdOn;

    public BookEntity(UUID id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }
}
