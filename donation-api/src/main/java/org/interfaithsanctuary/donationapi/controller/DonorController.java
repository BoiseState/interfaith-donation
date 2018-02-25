package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    DonorRepository donorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Donor getDonorById(@PathVariable("id") long id)  {
        return donorRepository.findOne(id);
    }
}
