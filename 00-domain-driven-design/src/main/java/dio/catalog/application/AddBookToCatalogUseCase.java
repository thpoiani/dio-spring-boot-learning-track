package dio.catalog.application;

import dio.catalog.domain.Book;
import dio.catalog.domain.BookRepository;
import dio.catalog.domain.Isbn;
import org.springframework.stereotype.Service;

@Service
public class AddBookToCatalogUseCase {
    private final BookSearchGateway bookSearchGateway;
    private final BookRepository bookRepository;

    public AddBookToCatalogUseCase(BookSearchGateway bookSearchGateway,
                                   BookRepository bookRepository) {
        this.bookSearchGateway = bookSearchGateway;
        this.bookRepository = bookRepository;
    }

    public Book execute(Isbn isbn) {
        var bookInformation = bookSearchGateway.search(isbn);
        var book = new Book(bookInformation.title(), isbn);
        return bookRepository.save(book);
    }
}
