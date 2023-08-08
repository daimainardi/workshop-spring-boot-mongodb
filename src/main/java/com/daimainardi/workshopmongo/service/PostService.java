package com.daimainardi.workshopmongo.service;

import com.daimainardi.workshopmongo.domain.Post;
import com.daimainardi.workshopmongo.repository.PostRepository;
import com.daimainardi.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }
    /*public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }*/
     public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }
}
