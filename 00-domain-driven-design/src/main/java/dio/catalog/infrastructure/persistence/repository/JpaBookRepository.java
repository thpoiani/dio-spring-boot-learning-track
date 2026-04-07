package dio.catalog.infrastructure.persistence.repository;

import dio.catalog.domain.Book;
import dio.catalog.domain.BookRepository;
import dio.catalog.infrastructure.persistence.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookRepository implements BookRepository {
    private final BookEntityRepository bookEntityRepository;

    public JpaBookRepository(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = new BookEntity(book.getId().id(), book.getTitle(), book.getIsbn().value());
        bookEntityRepository.save(entity);
        return book;
    }
}
