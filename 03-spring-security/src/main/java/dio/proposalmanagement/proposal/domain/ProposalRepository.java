package dio.proposalmanagement.proposal.domain;

import java.util.List;

public interface ProposalRepository {
    List<Proposal> findAll();

    List<Proposal> findAllByOwnerId(OwnerId ownerId);

    Proposal save(Proposal proposal);
}
