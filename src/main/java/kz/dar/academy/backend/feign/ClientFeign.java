package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClient();

    @GetMapping("/client/all")
    List<ClientResponse> getAllClients();

    @GetMapping("/client/{clientId}")
    ClientResponse getClientById(@PathVariable String clientId);

}
