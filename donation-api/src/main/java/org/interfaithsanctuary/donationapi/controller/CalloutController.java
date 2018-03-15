package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.interfaithsanctuary.donationapi.repository.CalloutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/callouts")
public class CalloutController {
    @Autowired
    private CalloutRepository calloutRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page<Callout> getAllCallouts(Pageable pageable) {
        return calloutRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Callout getCalloutById(@PathVariable("id") long id)  {
        return calloutRepository.findOne(id);
    }
}