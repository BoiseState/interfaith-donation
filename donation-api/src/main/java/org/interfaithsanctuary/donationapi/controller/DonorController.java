package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    DonorRepository donorRepository;

    @GetMapping("/all")
    public @ResponseBody Page<Donor> getAllDonors(Pageable pageable) {
        System.out.println("in DonorController.getAllDonors()");
        return donorRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Donor getDonorById(@PathVariable("id") long id)  {
        return donorRepository.findOne(id);
    }
}


