package dio.proposalmanagement.proposal.infrastructure.persistence.repository;

import dio.proposalmanagement.proposal.infrastructure.persistence.entity.ProposalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProposalEntityRepository extends CrudRepository<ProposalEntity, UUID> {
    List<ProposalEntity> findAllByOwnerId(UUID ownerId);
}
