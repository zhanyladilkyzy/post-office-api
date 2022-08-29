package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.PostRequest;
import kz.dar.academy.backend.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String checkPost();

    @PostMapping("/post/create")
    PostResponse createPost(@RequestBody PostRequest postRequest);

    @PutMapping("/post/{postId}")
    PostResponse updatePost(@PathVariable String postId, @RequestBody PostRequest postRequest);

    @GetMapping("/post/all")
    List<PostResponse> getAllPosts();

    @GetMapping("/post/{postId}")
    PostResponse getPostById(@PathVariable String postId);

    @DeleteMapping("/post/{postId}")
    ResponseEntity<String> deletePost(@PathVariable String postId);
}
