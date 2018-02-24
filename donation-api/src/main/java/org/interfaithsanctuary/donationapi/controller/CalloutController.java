package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.interfaithsanctuary.donationapi.repository.CalloutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/api/callouts")
public class CalloutController {
    @Autowired
    private CalloutRepository calloutRepository;

    @RequestMapping(path="/all", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Callout> getAllCallouts() {
        return calloutRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Callout getCalloutById(@PathVariable("id") long id)  {
        return calloutRepository.findOne(id);
    }
}