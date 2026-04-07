package dio.proposalmanagement.proposal.application.list;

import dio.proposalmanagement.proposal.domain.OwnerId;
import dio.proposalmanagement.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposals(OwnerId ownerId);

    AccessScope getScope();
}
