package org.interfaithsanctuary.donationapi.controller;


import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.interfaithsanctuary.donationapi.model.Donation;
import org.interfaithsanctuary.donationapi.repository.CalloutNeedRepository;
import org.interfaithsanctuary.donationapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/donations")
public class DonationController {
    @Autowired
    private DonationRepository donationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Donation> getDonations(Pageable pageable) {
        return donationRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Donation getDonationById(@PathVariable("id") long id) {
        return donationRepository.findOne(id);
    }
}
