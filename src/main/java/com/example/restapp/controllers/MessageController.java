package com.example.restapp.controllers;

import com.example.restapp.domain.Message;
import com.example.restapp.domain.Views;
import com.example.restapp.repo.MessageRepo;
import com.example.restapp.service.MessageService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> list() {
        return messageService.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageService.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB, @RequestBody Message message) {
        return messageService.update(messageFromDB, message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageService.delete(message);
    }

    @MessageMapping("/changeMessage")
    @SendTo("/topic/activity")
    public Message change(Message message) {
        return messageService.save(message);
    }
}
