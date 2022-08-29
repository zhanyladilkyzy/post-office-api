package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.model.PostRequest;
import kz.dar.academy.backend.model.PostResponse;
import kz.dar.academy.backend.service.PostDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/client/create")
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientFeign.createClient(clientRequest);
    }
    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }

    @PutMapping("/client/{clientId}")
    public ClientResponse updateClient(@PathVariable String clientId, @RequestBody ClientRequest clientRequest) {
        return clientFeign.updateClient(clientId, clientRequest);
    }

    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable String clientId) {
        return clientFeign.deleteClient(clientId);
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
    public PostResponse getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/post-detail/{postId}")
    public PostResponse getPostDetail(@PathVariable String postId) {
        return postDetailsService.getPostDetailsByPostId(postId);
    }

    @PostMapping("/post")
    public PostResponse createPost(@RequestBody PostRequest postRequest) {
        return postFeign.createPost(postRequest);
    }

    @PutMapping("/post/{postId}")
    public PostResponse updatePost(@PathVariable String postId, @RequestBody PostRequest postRequest) {
        return postFeign.updatePost(postId, postRequest);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        return postFeign.deletePost(postId);
    }
}
