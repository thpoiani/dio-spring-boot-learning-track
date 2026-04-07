package dio.marketplace.catalog.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Sector {
    private SectorId id;
    private BigDecimal price;

    public Sector(SectorId id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}
