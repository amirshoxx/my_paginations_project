package com.example.chat_app_project.controller;
import com.example.chat_app_project.dto.MessageDto;
import com.example.chat_app_project.entity.Message;
import com.example.chat_app_project.entity.User;
import com.example.chat_app_project.projection.MessageProjection;
import com.example.chat_app_project.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

  @Autowired
  MessageRepo messageRepo;


  @Autowired
    SimpMessagingTemplate messagingTemplate;


    @GetMapping
    public ResponseEntity<?> getMessage(@RequestParam UUID fromId, @RequestParam UUID toId){
        List<MessageProjection> messages = messageRepo.myMessagesNative(fromId,toId);
        return ResponseEntity.ok(messages);
    }


    @PostMapping
    public ResponseEntity<?> saveMessage(@RequestBody MessageDto messageDto){
        Message message = new Message(messageDto.getText(), new User(messageDto.getFromId()), new User(messageDto.getToId()));
        Message save = messageRepo.save(message);
        messagingTemplate.convertAndSend("/topics/student-save",save);
        return ResponseEntity.ok(save);

    }


}
