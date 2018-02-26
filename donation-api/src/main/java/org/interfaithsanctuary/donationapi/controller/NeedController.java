package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.interfaithsanctuary.donationapi.repository.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/needs")
public class NeedController {

    @Autowired
    NeedRepository needRepository;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Page<Need> getAllNeeds(Pageable pageable) {
        return needRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Need getNeedById(@PathVariable("id") long id)  {

        return needRepository.findOne(id);
    }
}
