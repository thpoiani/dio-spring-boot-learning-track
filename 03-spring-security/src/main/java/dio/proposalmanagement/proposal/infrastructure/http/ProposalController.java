package dio.proposalmanagement.proposal.infrastructure.http;

import dio.proposalmanagement.auth.domain.UserRole;
import dio.proposalmanagement.auth.infrastructure.persistence.entity.User;
import dio.proposalmanagement.proposal.application.CreateProposalUseCase;
import dio.proposalmanagement.proposal.application.ListProposalsUseCase;
import dio.proposalmanagement.proposal.application.list.AccessScope;
import dio.proposalmanagement.proposal.domain.Owner;
import dio.proposalmanagement.proposal.domain.OwnerId;
import dio.proposalmanagement.proposal.infrastructure.http.request.CreateProposalRequest;
import dio.proposalmanagement.proposal.infrastructure.http.response.ProposalResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
    private final CreateProposalUseCase createProposalUseCase;
    private final ListProposalsUseCase listProposalsUseCase;

    public ProposalController(CreateProposalUseCase createProposalUseCase,
                              ListProposalsUseCase listProposalsUseCase) {
        this.createProposalUseCase = createProposalUseCase;
        this.listProposalsUseCase = listProposalsUseCase;
    }

    private static AccessScope getAccessScope(UserRole role) {
        return switch (role) {
            case ROLE_INFLUENCER -> AccessScope.OWN;
            case ROLE_BRAND -> AccessScope.ALL;
        };
    }

    @PostMapping
    @PreAuthorize("hasRole('INFLUENCER')")
    public ProposalResponse createProposal(@RequestBody CreateProposalRequest request,
                                           @AuthenticationPrincipal User user) {
        var owner = new Owner(new OwnerId(user.getId()), user.getUsername());
        var output = this.createProposalUseCase.execute(request.toInput(), owner);

        return ProposalResponse.from(output);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('INFLUENCER','BRAND')")
    public List<ProposalResponse> findAllProposals(@AuthenticationPrincipal User user) {
        var accessScope = getAccessScope(user.getRole());
        var ownerId = new OwnerId(user.getId());

        return listProposalsUseCase.execute(accessScope, ownerId)
                .stream()
                .map(ProposalResponse::from)
                .toList();
    }
}
