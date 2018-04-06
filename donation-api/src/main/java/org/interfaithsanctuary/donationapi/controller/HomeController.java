package org.interfaithsanctuary.donationapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() { return "redirect:swagger-ui.html"; }
}
