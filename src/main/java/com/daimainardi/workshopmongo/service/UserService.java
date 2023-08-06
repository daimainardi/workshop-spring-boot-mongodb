package com.daimainardi.workshopmongo.service;

import com.daimainardi.workshopmongo.domain.User;
import com.daimainardi.workshopmongo.dto.UserDTO;
import com.daimainardi.workshopmongo.repository.UserRepository;
import com.daimainardi.workshopmongo.service.exception.ObjectNotFoundException;
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
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }
    public User fromDTO (UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
