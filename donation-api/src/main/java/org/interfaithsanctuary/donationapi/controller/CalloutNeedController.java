package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.interfaithsanctuary.donationapi.repository.CalloutNeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(path="/calloutneeds")
public class CalloutNeedController {
    @Autowired
    private CalloutNeedRepository calloutNeedRepository;

    @CrossOrigin
    @GetMapping("/all")
    public Page<CalloutNeed> getAllCalloutNeeds(Pageable pageable) {
        return calloutNeedRepository.findAll(pageable);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CalloutNeed getCalloutNeedById(@PathVariable("id") long id) {
        return calloutNeedRepository.findOne(id);
    }

    @CrossOrigin
    @PostMapping(value = "/create")
    public ResponseEntity<CalloutNeed> createCalloutNeed(@RequestBody CalloutNeed calloutneed) {
        CalloutNeed savedCalloutNeed = calloutNeedRepository.save(calloutneed);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedCalloutNeed.getId()).toUri();
        return ResponseEntity.created(location).body(savedCalloutNeed);
    }
}
