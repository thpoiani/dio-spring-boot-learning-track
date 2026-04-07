package dio.proposalmanagement.proposal.application;

import dio.proposalmanagement.proposal.application.input.CreateProposalInput;
import dio.proposalmanagement.proposal.application.output.ProposalOutput;
import dio.proposalmanagement.proposal.domain.Owner;
import dio.proposalmanagement.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public ProposalOutput execute(CreateProposalInput input, Owner owner) {
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);

        return ProposalOutput.from(saved);
    }
}
