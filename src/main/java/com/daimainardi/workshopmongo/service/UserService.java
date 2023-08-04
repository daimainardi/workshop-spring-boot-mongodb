package com.daimainardi.workshopmongo.service;

import com.daimainardi.workshopmongo.domain.User;
import com.daimainardi.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
