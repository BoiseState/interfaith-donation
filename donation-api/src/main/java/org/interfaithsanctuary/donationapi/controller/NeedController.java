package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.interfaithsanctuary.donationapi.repository.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/need")
public class NeedController {

    @Autowired
    NeedRepository needRepository;

    @RequestMapping("/all")
    @ResponseBody
    public List<Need> testDonorController() {
        List<Need> needs = new ArrayList<>();
        for (Need need : needRepository.findAll()) {
            needs.add(need);
        }
        return needs;
    }
}
