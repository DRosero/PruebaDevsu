package com.devsu.service;

import com.devsu.model.MessageDevsu;
import com.devsu.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageImplementation implements MessageService{

    @Autowired
    MessageRepository messageRepository;
    @Override
    public Boolean saveMessage(MessageDevsu messageDevsu) {
        try {
            messageRepository.save(messageDevsu);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public String returnMessageByID(long id) {
        return "Error";
    }

    @Override
    public String deleteUserByID(long id) {
        return "Error";
    }

    @Override
    public String getAllMessages() {
        return "Error";
    }


}
