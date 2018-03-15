package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Users;
import org.interfaithsanctuary.donationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

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
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page<Users> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUserById(@PathVariable("id") long id)  {
        return userRepository.findOne(id);
    }
}