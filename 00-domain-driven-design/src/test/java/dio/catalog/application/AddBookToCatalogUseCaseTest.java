package dio.catalog.application;

import dio.catalog.domain.Book;
import dio.catalog.domain.Isbn;
import dio.catalog.infrastructure.persistence.repository.BookEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class AddBookToCatalogUseCaseTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:18.3-alpine");

    @Autowired
    AddBookToCatalogUseCase useCase;

    @Autowired
    BookEntityRepository repository;

    @Test
    void should_add_book_to_catalog() {
        // given
        var isbn = new Isbn("978-0-306-40615-7");

        // when
        Book book = useCase.execute(isbn);

        // then
        assertThat(book).isNotNull();
        assertThat(book.getId()).isNotNull();
        assertThat(book.getIsbn().value()).isEqualTo(isbn.value());
        assertThat(book.getTitle()).isEqualTo("Error-correction coding for digital communications");

        // persistence
        var entity = repository.findById(book.getId().id());
        assertThat(entity).isPresent();
        assertThat(entity.get().getCreatedOn()).isNotNull();
    }
}
