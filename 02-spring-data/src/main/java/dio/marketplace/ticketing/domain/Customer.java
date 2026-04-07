package dio.marketplace.ticketing.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {
    private UUID id;
    private CustomerId correlationId;
    private String name;


    public Customer(String correlationId, String name) {
        this.id = UUID.randomUUID();
        this.correlationId = new CustomerId(correlationId);
        this.name = name;
    }
}
