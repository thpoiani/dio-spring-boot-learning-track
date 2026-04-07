package dio.marketplace.ticketing.infrastructure.persistence.repository;

import dio.marketplace.ticketing.domain.Customer;
import dio.marketplace.ticketing.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresCustomerRepository implements CustomerRepository {
    private final CustomerCrudRepository customerCrudRepository;

    public PostgresCustomerRepository(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }

    @Override
    public void save(Customer customer) {
        var entity = new dio.marketplace.ticketing.infrastructure.persistence.entity.Customer(
                customer.getId(),
                customer.getCorrelationId().id(),
                customer.getName()
        );
        customerCrudRepository.save(entity);
    }
}
