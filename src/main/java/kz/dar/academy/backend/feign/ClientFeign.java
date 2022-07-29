package kz.dar.academy.backend.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClient();
}
