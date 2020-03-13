package com.main.general.controllers;

import com.main.general.entities.Subscriber;
import com.main.general.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

  @Autowired
    private SubscriberRepository subscriberRepository;

    @RequestMapping("/add")
    public String addSubscriber(@RequestBody Subscriber subscriber) throws UnsupportedEncodingException {
        String source = subscriber.getSubscriberName();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);

        subscriber.setId(String.valueOf(uuid));
        System.out.println(subscriber.toString());
        subscriberRepository.insert(subscriber);
        return "Record Inserted successfully";
    }


}
