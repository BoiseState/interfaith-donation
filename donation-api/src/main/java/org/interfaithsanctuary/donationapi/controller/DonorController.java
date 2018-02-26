package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    DonorRepository donorRepository;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Page<Donor> getAllDonors(Pageable pageable) {
        return donorRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Donor getDonorById(@PathVariable("id") long id)  {

        return donorRepository.findOne(id);
    }
}
