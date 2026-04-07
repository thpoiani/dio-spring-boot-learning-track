package dio.catalog.application;

import dio.catalog.domain.Isbn;

public interface BookSearchGateway {
    BookInformation search(Isbn isbn);
}
