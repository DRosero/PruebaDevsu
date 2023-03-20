package com.devsu.controller;


import com.devsu.model.MessageDevsu;
import com.devsu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/DevOps")
    public ResponseEntity sendMessageServer(@RequestBody MessageDevsu messageDevsu){

        String result = "Hello "+messageDevsu.getTo()+" your message will be send";
        return ResponseEntity.status(200).body(result);


        /*if (messageService.saveMessage(messageDevsu)){
            return "Hello "+messageDevsu.getTo()+" your message will be send";
        }
        else {
            return "Error";
        }*/
    }

}
