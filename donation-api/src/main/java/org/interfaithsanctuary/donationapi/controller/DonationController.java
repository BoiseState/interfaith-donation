package org.interfaithsanctuary.donationapi.controller;


import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.interfaithsanctuary.donationapi.model.Donation;
import org.interfaithsanctuary.donationapi.repository.CalloutNeedRepository;
import org.interfaithsanctuary.donationapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/donations")
public class DonationController {
    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("/all")
    public Page<Donation> getDonations(Pageable pageable) {
        return donationRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Donation getDonationById(@PathVariable("id") long id) {
        return donationRepository.findOne(id);
    }
}
