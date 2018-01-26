package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.interfaithsanctuary.donationapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    DonorRepository donorRepository;

    @RequestMapping("/test")
    @ResponseBody
    public List<Donor> testDonorController() {
        List<Donor> donors = new ArrayList<>();
        for (Donor donor : donorRepository.findAll()) {
            donors.add(donor);
        }
        return donors;
    }
}
