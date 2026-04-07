package dio.compliance.infrastructure.rest.dto;

import dio.compliance.domain.ComplianceScreening;

import java.util.List;

public record AmlResult(int riskScore, List<String> flags, Pep pep) {
    public ComplianceScreening.AmlProfile toDomain() {
        List<ComplianceScreening.AmlProfile.PoliticalExposure> exposures = pep().occurrences().stream()
                .map(occ -> new ComplianceScreening.AmlProfile.PoliticalExposure(
                        occ.personName(),
                        occ.position()
                ))
                .toList();

        return new ComplianceScreening.AmlProfile(
                riskScore(),
                flags() != null ? flags() : List.of(),
                pep().isPep(),
                exposures
        );
    }

    public record Pep(boolean isPep, List<PepOccurrence> occurrences) {
        public record PepOccurrence(
                String personName,
                String position
        ) {
        }
    }
}
