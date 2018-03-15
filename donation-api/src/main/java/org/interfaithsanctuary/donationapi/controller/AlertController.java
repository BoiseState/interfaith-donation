package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Alert;
import org.interfaithsanctuary.donationapi.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/alerts")
public class AlertController {
    @Autowired
    private AlertRepository alertRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page<Alert> getAllAlerts(Pageable pageable) {
        return alertRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Alert getAlertById(@PathVariable("id") long id)  {
        return alertRepository.findOne(id);
    }
}