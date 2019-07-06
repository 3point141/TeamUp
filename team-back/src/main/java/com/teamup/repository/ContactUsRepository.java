package com.teamup.repository;

import com.teamup.model.ContactUs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactUsRepository extends MongoRepository<ContactUs,String> {
}
