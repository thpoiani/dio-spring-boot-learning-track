package dio.catalog.infrastructure.integration.openlibrary.client;

import dio.catalog.application.BookInformation;
import dio.catalog.application.BookSearchGateway;
import dio.catalog.domain.Isbn;
import dio.catalog.infrastructure.integration.openlibrary.dto.OpenLibraryIsbnSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
class OpenLibraryBookSearchGateway implements BookSearchGateway {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenLibraryBookSearchGateway.class);

    private final RestClient restClient;

    public OpenLibraryBookSearchGateway(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://openlibrary.org").build();
    }

    public BookInformation search(Isbn isbn) {
        var result = restClient
                .get()
                .uri("/isbn/{isbn}.json", isbn.value())
                .accept(APPLICATION_JSON)
                .retrieve()
                .toEntity(OpenLibraryIsbnSearchResult.class);

        LOGGER.info("Book search result: {}", result);

        return new BookInformation(result.getBody().title());
    }
}
