package com.devsu.service;


import com.devsu.model.MessageDevsu;

import java.util.Optional;

public interface MessageService {

    Boolean saveMessage(MessageDevsu message);
    String returnMessageByID(long id);
    String deleteUserByID(long id);
    String getAllMessages();

}
