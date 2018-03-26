package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.User;
import org.interfaithsanctuary.donationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping(path="/add") // Map ONLY GET Requests
//    public @ResponseBody String addNewUser (@RequestParam String name
//            , @RequestParam String email, @RequestParam String password
//            ,@RequestParam Users.PermissionLevel permissions) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Users n = new Users();
//        n.setUserName(name);
//        n.setEmail(email);
//        n.setPassword(password);
//        n.setPermissions(permissions);
//        userRepository.save(n);
//        return "Saved";
//    }
    @GetMapping("/all")
    public @ResponseBody Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id)  {
        return userRepository.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable("id") long id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findOne(id));
        System.out.println("the user: " + user.getUserName());

        if(!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.setId(id);

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Create user: " + user.getUserName());

        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

}