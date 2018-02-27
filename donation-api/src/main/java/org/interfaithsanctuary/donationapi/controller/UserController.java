package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Users;
import org.interfaithsanctuary.donationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUserById(@PathVariable("id") long id)  {
        return userRepository.findOne(id);
    }
}