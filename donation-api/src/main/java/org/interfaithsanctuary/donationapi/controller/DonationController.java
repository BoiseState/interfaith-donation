package org.interfaithsanctuary.donationapi.controller;


import java.net.URI;
import java.util.Optional;

import org.interfaithsanctuary.donationapi.model.Donation;
import org.interfaithsanctuary.donationapi.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    @GetMapping(value = "/{id}")
    public Donation getDonationById(@PathVariable("id") long id) {
        return donationRepository.findOne(id);
    }
    
    @CrossOrigin
    @PostMapping(value = "/")
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationRepository.save(donation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedDonation.getId()).toUri();
        return ResponseEntity.created(location).body(savedDonation);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteDonationById(@PathVariable("id") long id) {
        donationRepository.delete(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Donation> updateDonationById(@RequestBody Donation donation, @PathVariable("id") long id) {
        Optional<Donation> donationOptional = Optional.ofNullable(donationRepository.findOne(id));
        if(!donationOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        donationRepository.save(donation);
        return ResponseEntity.ok().build();
    }
}
