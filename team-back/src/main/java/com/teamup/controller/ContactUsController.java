package com.teamup.controller;

import com.teamup.model.ContactUs;
import com.teamup.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/contact")
    public boolean initiateContact(@RequestBody ContactUs contactUs, Model model){
        return contactUsService.saveMessages(contactUs);
    }

    @RequestMapping("/see")
    public List<ContactUs> getMessage(){
        return contactUsService.seeAll();
    }

}
