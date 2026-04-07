package dio.compliance.infrastructure.persistence.entity;

import dio.compliance.domain.Company;
import dio.compliance.domain.CompanyId;
import dio.compliance.domain.RiskAssessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.Optional;
import java.util.UUID;

@KeySpace("companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    private UUID id;
    private String name, registrationNumber;
    private RiskAssessment riskAssessment;

    public static CompanyEntity from(Company company) {
        return new CompanyEntity(
                company.getId().id(),
                company.getName(),
                company.getRegistrationNumber(),
                company.getRiskAssessment().orElse(null));
    }

    public Company toDomain() {
        return new Company(
                new CompanyId(this.getId()),
                this.getName(),
                this.registrationNumber,
                Optional.ofNullable(getRiskAssessment()));
    }
}
