package dio.catalog.domain;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Book {
    private final BookId id;
    private final String title;
    private final Isbn isbn;

    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "Title cannot be null");
        Assert.notNull(isbn, "ISBN cannot be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }
}
