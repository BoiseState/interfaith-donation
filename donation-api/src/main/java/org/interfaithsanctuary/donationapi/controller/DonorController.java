package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    DonorRepository donorRepository;

//    @RequestMapping("/all")
//    @ResponseBody
//    public List<Donor> getAllDonors() {
//        List<Donor> donors = new ArrayList<>();
//        for (Donor donor : donorRepository.findAll()) {
//            donors.add(donor);
//        }
//        return donors;
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Donor> getAllDonors() {
        // This returns a JSON or XML with the callouts
        return donorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Donor getDonorById(@PathVariable("id") long id)  {

        return donorRepository.findOne(id);
    }
}
