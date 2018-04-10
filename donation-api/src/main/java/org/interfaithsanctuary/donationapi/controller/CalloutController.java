package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.interfaithsanctuary.donationapi.repository.CalloutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/callouts")
public class CalloutController {
    @Autowired
    private CalloutRepository calloutRepository;

    @CrossOrigin
    @GetMapping("/all")
    public Page<Callout> getAllCallouts(Pageable pageable) {
        return calloutRepository.findAll(pageable);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Callout getCalloutById(@PathVariable("id") long id)  {
        return calloutRepository.findOne(id);
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Callout> createCallout(@RequestBody Callout callout) {
        Callout savedCallout = calloutRepository.save(callout);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedCallout.getId()).toUri();
        return ResponseEntity.created(location).body(savedCallout);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteCalloutById(@PathVariable("id") long id) {
        calloutRepository.delete(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Callout> updateCalloutById(@RequestBody Callout callout, @PathVariable("id") long id) {
        Optional<Callout> calloutOptional = Optional.ofNullable(calloutRepository.findOne(id));
        if(!calloutOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        callout.setId(id);
        calloutRepository.save(callout);
        return ResponseEntity.ok().build();
    }
}