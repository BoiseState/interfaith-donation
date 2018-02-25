package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Alert;
import org.interfaithsanctuary.donationapi.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/alerts")
public class AlertController {
    @Autowired
    private AlertRepository alertRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Alert getAlertById(@PathVariable("id") long id)  {
        return alertRepository.findOne(id);
    }
}