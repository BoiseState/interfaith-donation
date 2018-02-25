package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.interfaithsanctuary.donationapi.repository.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/needs")
public class NeedController {
    @Autowired
    NeedRepository needRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Need> getAllNeeds() {
        return needRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Need getNeedById(@PathVariable("id") long id)  {
        return needRepository.findOne(id);
    }
}
