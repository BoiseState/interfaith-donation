package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.interfaithsanctuary.donationapi.repository.CalloutNeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/needcallouts")
public class CalloutNeedController {
    @Autowired
    private CalloutNeedRepository calloutNeedRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<CalloutNeed> getAllNeedCallouts(Pageable pageable) {
        return calloutNeedRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CalloutNeed getNeedCalloutById(@PathVariable("id") long id) {
        return calloutNeedRepository.findOne(id);
    }
}
