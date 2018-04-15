package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.User;
import org.interfaithsanctuary.donationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.mindrot.jbcrypt.BCrypt;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Value("${password.global.salt}")
    private String globalSalt;

    @CrossOrigin
    @GetMapping("/all")
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id)  {
        return userRepository.findOne(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable("id") long id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findOne(id));
        System.out.println("Update user: " + user.getUserName());
        if(!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Create user: " + user.getUserName());
        User usr = userRepository.findByEmail(user.getEmail());
        if(usr == null) {
            String prepPassword = user.getPassword()+ globalSalt;
            String hashedPwd = BCrypt.hashpw(prepPassword, BCrypt.gensalt());
            user.setPassword(hashedPwd);
            User savedUser = userRepository.save(user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                    buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).body(savedUser);
        } else {
            System.out.println("Email " + user.getEmail() + " already exist.");
            return null;
        }
    }

}