package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Alert;
import org.interfaithsanctuary.donationapi.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/alert/") // This means URL's start with /api (after Application path)
public class AlertController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AlertRepository alertRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Alert> getAllAlerts() {
        // This returns a JSON or XML with the callouts
        return alertRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Alert getAlertById(@PathVariable("id") long id)  {

        return alertRepository.findOne(id);
    }

}