package dio.marketplace.catalog.infrastructure.http;

import dio.marketplace.catalog.application.BrowseShowcaseUseCase;
import dio.marketplace.catalog.application.dto.EventOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {
    private final BrowseShowcaseUseCase browseShowcaseUseCase;

    public ShowcaseController(BrowseShowcaseUseCase browseShowcaseUseCase) {
        this.browseShowcaseUseCase = browseShowcaseUseCase;
    }

    @GetMapping
    List<EventOutput> browseShowcase() {
        return browseShowcaseUseCase.execute();
    }
}
