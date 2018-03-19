package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.interfaithsanctuary.donationapi.repository.NeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/needs")
public class NeedController {
    @Autowired
    NeedRepository needRepository;
    
    @GetMapping("/all")
    public @ResponseBody Page<Need> getAllNeeds(Pageable pageable) {
        return needRepository.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Need getNeedById(@PathVariable("id") long id)  {
        return needRepository.findOne(id);
    }

    @PostMapping("/")
    public ResponseEntity<Need> createNeed(@RequestBody Need need) {
        Need savedNeed = needRepository.save(need);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(savedNeed.getId()).toUri();

        return ResponseEntity.created(location).body(savedNeed);
    }

    @DeleteMapping("/{id}")
    public void deleteNeedById(@PathVariable("id") long id) {
        needRepository.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Need> updateNeedById(@RequestBody Need need, @PathVariable("id") long id) {
        Optional<Need> needOptional = Optional.ofNullable(needRepository.findOne(id));

        if(!needOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        need.setId(id);

        needRepository.save(need);

        return ResponseEntity.ok().build();
    }
}
