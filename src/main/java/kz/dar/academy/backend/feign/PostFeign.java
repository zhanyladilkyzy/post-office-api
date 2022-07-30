package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String checkPost();

    @GetMapping("/post/all")
    List<PostResponse> getAllPosts();

    @GetMapping("/post/{postId}")
    PostResponse getPostById(@PathVariable String postId);
}
