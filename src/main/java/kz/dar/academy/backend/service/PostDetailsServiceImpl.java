package kz.dar.academy.backend.service;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostDetailsServiceImpl implements PostDetailsService {
    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;

    @Override
    public PostResponse getPostDetailsByPostId(String postId) {
        return postFeign.getPostById(postId);
//        List<ClientResponse> clientResponses = clientFeign.getAllClients();
//        List<PostResponse> postResponses = postFeign.getAllPosts();
//        for (int i = 0; i < postResponses.size(); i++) {
//            postResponses.get(i).setClient(clientResponses.get(i));
//            postResponses.get(i).setReceiver(clientResponses.get(i));
//        }
//        List<PostResponse> response = postResponses.stream()
//                .filter(postResponse -> postResponse.getPostId().equals(postId)).collect(Collectors.toList());
//        return response.get(0);
    }
}
