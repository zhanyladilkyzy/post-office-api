package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.PostResponse;

public interface PostDetailsService {
    PostResponse getPostDetailsByPostId(String postId);
}
