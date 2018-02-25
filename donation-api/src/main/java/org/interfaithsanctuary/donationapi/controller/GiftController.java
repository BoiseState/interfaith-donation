package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Gift;
import org.interfaithsanctuary.donationapi.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/gifts")
public class GiftController {
    @Autowired
    private GiftRepository giftRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Gift> getAllGifts() {
        return giftRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Gift getGiftById(@PathVariable("id") long id)  {
        return giftRepository.findOne(id);
    }
}
