package com.example.restapp.service;


import com.example.restapp.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    Message save(Message message);
    Message update(Message messageFromDb, Message message);
    void delete(Message message);
}
