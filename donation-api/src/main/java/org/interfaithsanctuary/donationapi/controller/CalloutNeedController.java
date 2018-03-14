package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.interfaithsanctuary.donationapi.repository.CalloutNeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/calloutneeds")
public class CalloutNeedController {
    @Autowired
    private CalloutNeedRepository calloutNeedRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<CalloutNeed> getAllCalloutNeeds(Pageable pageable) {
        return calloutNeedRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CalloutNeed getCalloutNeedById(@PathVariable("id") long id) {
        return calloutNeedRepository.findOne(id);
    }
}
