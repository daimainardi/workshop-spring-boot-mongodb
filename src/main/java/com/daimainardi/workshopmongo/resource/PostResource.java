package com.daimainardi.workshopmongo.resource;

import com.daimainardi.workshopmongo.domain.Post;
import com.daimainardi.workshopmongo.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable String id) {
        return postService.findById(id);
    }
}
