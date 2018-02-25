package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.interfaithsanctuary.donationapi.repository.CalloutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/callouts")
public class CalloutController {
    @Autowired
    private CalloutRepository calloutRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Callout> getAllCallouts() {
        return calloutRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Callout getCalloutById(@PathVariable("id") long id)  {
        return calloutRepository.findOne(id);
    }
}