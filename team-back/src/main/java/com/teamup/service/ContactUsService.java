package com.teamup.service;

import com.teamup.model.ContactUs;
import com.teamup.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@EnableMongoRepositories(basePackageClasses = ContactUsRepository.class)
@Configuration
@CrossOrigin
public class ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    public boolean saveMessages(ContactUs contactUs){
        contactUsRepository.save(contactUs);
        return true;
    }

    public ContactUs seeMessages(ContactUs contactUs){
        return contactUsRepository.findById(contactUs.getName()).get();
    }

    public List<ContactUs> seeAll(){
        return contactUsRepository.findAll();
    }
}
