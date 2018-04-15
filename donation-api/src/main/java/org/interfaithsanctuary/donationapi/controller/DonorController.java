package org.interfaithsanctuary.donationapi.controller;

import java.net.URI;
import java.util.Optional;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    DonorRepository donorRepository;

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody Page<Donor> getAllDonors(Pageable pageable) {
        return donorRepository.findAll(pageable);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Donor getDonorById(@PathVariable("id") long id)  {
        return donorRepository.findOne(id);
    }
    
    @CrossOrigin
    @PostMapping(value = "/")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        Donor savedDonor = donorRepository.save(donor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedDonor.getId()).toUri();
        return ResponseEntity.created(location).body(savedDonor);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteDonorById(@PathVariable("id") long id) {
        donorRepository.delete(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonorById(@RequestBody Donor donor, @PathVariable("id") long id) {
        Optional<Donor> donorOptional = Optional.ofNullable(donorRepository.findOne(id));
        if(!donorOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        donorRepository.save(donor);
        return ResponseEntity.ok().build();
    }
}


