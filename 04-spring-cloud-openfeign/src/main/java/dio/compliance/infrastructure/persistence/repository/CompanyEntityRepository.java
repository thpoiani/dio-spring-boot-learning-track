package dio.compliance.infrastructure.persistence.repository;

import dio.compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "companies")
public interface CompanyEntityRepository extends CrudRepository<CompanyEntity, UUID> {
}
