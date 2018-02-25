package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Gift;
import org.interfaithsanctuary.donationapi.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/gifts") // This means URL's start with /api (after Application path)
public class GiftController {

    @Autowired // This means to get the bean called giftRepository
    private GiftRepository giftRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Gift> getAllGifts() {
        return giftRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Gift getGiftById(@PathVariable("id") long id)  {

        return giftRepository.findOne(id);
    }

    @PostMapping("/")
    public ResponseEntity<Gift> createGift(@RequestBody Gift gift) {

        Gift savedGift = giftRepository.save(gift);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedGift.getGiftId()).toUri();

        return ResponseEntity.created(location).body(savedGift);

    }

    @DeleteMapping("/{id}")
    public void deleteGiftById(@PathVariable("id") long id) {
        giftRepository.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gift> updateGiftById(@RequestBody Gift gift, @PathVariable long id) {

        Optional<Gift> giftOptional = Optional.ofNullable(giftRepository.findOne(id));


        if (!giftOptional.isPresent())
            return ResponseEntity.notFound().build();

        gift.setGiftId(id);

        giftRepository.save(gift);

        return ResponseEntity.noContent().build();

    }

}
