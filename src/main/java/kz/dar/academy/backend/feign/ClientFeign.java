package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClient();

    @PostMapping("/client/create")
    ClientResponse createClient(@RequestBody ClientRequest clientRequest);

    @PutMapping("/client/{clientId}")
    ClientResponse updateClient(@PathVariable String clientId, ClientRequest clientRequest);

    @GetMapping("/client/{clientId}")
    ClientResponse getClientById(@PathVariable String clientId);

    @GetMapping("/client/all")
    List<ClientResponse> getAllClients();

    @DeleteMapping("/client/{clientId}")
    ResponseEntity<String> deleteClient(@PathVariable String clientId);


}
