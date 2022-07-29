package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.feign.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post-office")
public class ClientController {
    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/check")
    public String checkPostOffice() {
        return "Post-office controller is working!!!";
    }

    @GetMapping("/client/check")
    public String checkClient() {
        return clientFeign.checkClient();
    }
}
