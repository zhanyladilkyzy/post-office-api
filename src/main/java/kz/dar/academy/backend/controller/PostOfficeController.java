package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.model.PostResponse;
import kz.dar.academy.backend.service.PostDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-office")
public class PostOfficeController {

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    PostFeign postFeign;

    @Autowired
    PostDetailsService postDetailsService;

    @GetMapping("/check")
    public String checkPostOffice() {
        return "Post-office controller is working!!!";
    }

    @GetMapping("/client/check")
    public String checkClient() {
        return clientFeign.checkClient();
    }

    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(String clientId) {
        return clientFeign.getClientById(clientId);
    }

    @GetMapping("/post/check")
    public String checkPost() {
        return postFeign.checkPost();
    }

    @GetMapping("/post/all")
    public List<PostResponse> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostResponse getPostById(String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/post-detail/{postId}")
    public PostResponse getPostDetail(String postId) {
        return postDetailsService.getPostDetailsByPostId(postId);
    }
}
