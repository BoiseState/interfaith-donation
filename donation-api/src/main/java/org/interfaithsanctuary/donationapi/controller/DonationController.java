package org.interfaithsanctuary.donationapi.controller;


import org.interfaithsanctuary.donationapi.model.Donation;
import org.interfaithsanctuary.donationapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/donations")
public class DonationController {
    @Autowired
    private DonationRepository donationRepository;

    @CrossOrigin
    @GetMapping("/all")
    public Page<Donation> getDonations(Pageable pageable) {
        return donationRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Donation getDonationById(@PathVariable("id") long id) {
        return donationRepository.findOne(id);
    }

    @CrossOrigin
    @GetMapping(value = "/donor/{id}")
    public List<Donation> getDonationsByDonorId(@PathVariable("id") long id) {
        return donationRepository.findByDonorId(id);
    }
}
