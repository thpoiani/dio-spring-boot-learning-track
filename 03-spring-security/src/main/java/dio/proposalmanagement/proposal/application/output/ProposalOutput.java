package dio.proposalmanagement.proposal.application.output;

import dio.proposalmanagement.proposal.domain.Proposal;

import java.util.Optional;

public record ProposalOutput(String id, String title, Optional<String> description, String ownerId, String ownerName) {
    public static ProposalOutput from(Proposal proposal) {
        return new ProposalOutput(
                proposal.getId().id().toString(),
                proposal.getTitle(),
                proposal.getDescription(),
                proposal.getOwner().id().toString(),
                proposal.getOwner().name());
    }
}
