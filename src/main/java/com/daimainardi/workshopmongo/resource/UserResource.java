package com.daimainardi.workshopmongo.resource;

import com.daimainardi.workshopmongo.domain.User;
import com.daimainardi.workshopmongo.dto.UserDTO;
import com.daimainardi.workshopmongo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll().stream().map(UserDTO::new).toList();
    }
    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable String id){
        return new UserDTO(userService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.insert(userService.fromDTO(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        userService.delete(id);
    }

}
