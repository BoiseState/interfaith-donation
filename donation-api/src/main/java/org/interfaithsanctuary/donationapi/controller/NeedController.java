package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.interfaithsanctuary.donationapi.repository.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/needs")
public class NeedController {

    @Autowired
    NeedRepository needRepository;

//    @RequestMapping("/all")
//    @ResponseBody
//    public List<Need> getAllNeeds() {
//        List<Need> needs = new ArrayList<>();
//        for (Need need : needRepository.findAll()) {
//            needs.add(need);
//        }
//        return needs;
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Need> getAllNeeds() {
        // This returns a JSON or XML with the callouts
        return needRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Need getNeedById(@PathVariable("id") long id)  {

        return needRepository.findOne(id);
    }
}
