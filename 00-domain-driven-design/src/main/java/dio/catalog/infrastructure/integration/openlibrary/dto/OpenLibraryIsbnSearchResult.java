package dio.catalog.infrastructure.integration.openlibrary.dto;

import java.util.List;

public record OpenLibraryIsbnSearchResult(List<String> publishers,
                                          String title,
                                          List<String> isbn_10,
                                          int revision) {
}
