package dio.compliance.infrastructure.rest.client;

import dio.compliance.infrastructure.rest.dto.AmlResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("aml-client")
public interface AntiMoneyLaunderingClient {
    @GetMapping("/aml/v1/screening/{registrationNumber}")
    AmlResult screening(@PathVariable String registrationNumber);

}
