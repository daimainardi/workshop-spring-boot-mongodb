package com.daimainardi.workshopmongo.config;

import com.daimainardi.workshopmongo.domain.Post;
import com.daimainardi.workshopmongo.domain.User;
import com.daimainardi.workshopmongo.dto.AuthorDTO;
import com.daimainardi.workshopmongo.repository.PostRepository;
import com.daimainardi.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex,bob));

        Post post1 = new Post(null, sdf.parse("05/08/2023"), "Partiu viagem", "Vou viajar para Paris. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("07/08/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(List.of(post1,post2));

    }
}
