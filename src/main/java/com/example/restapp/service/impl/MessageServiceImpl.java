package com.example.restapp.service.impl;

import com.example.restapp.domain.Message;
import com.example.restapp.domain.Views;
import com.example.restapp.repo.MessageRepo;
import com.example.restapp.service.MessageService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepo messageRepo;

    @JsonView(Views.IdName.class)
    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    public Message update(Message messageFromDB, Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");
        return messageRepo.save(messageFromDB);
    }

    public Message save(Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

    public void delete(Message message) {
        messageRepo.delete(message);
    }
}
