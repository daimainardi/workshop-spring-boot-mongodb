package com.daimainardi.workshopmongo.resource;

import com.daimainardi.workshopmongo.domain.Post;
import com.daimainardi.workshopmongo.resource.util.URL;
import com.daimainardi.workshopmongo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/titlesearch")
    public List<Post> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return postService.findByTitle(text);
    }
}
