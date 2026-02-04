package com.delta.Deltafolio.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
@CrossOrigin(origins = "*")
public class ChatbotController {
    
    private final ChatbotService chatbotService;
    
    @Autowired
    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }
    
    @PostMapping("/chat")
    public ResponseEntity<ChatbotResponseDTO> chat(@Valid @RequestBody ChatbotRequestDTO request) {
        ChatbotResponseDTO response = chatbotService.processMessage(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/clear-consent/{userId}")
    public ResponseEntity<Void> clearConsent(@PathVariable Long userId) {
        chatbotService.clearConsent(userId);
        return ResponseEntity.ok().build();
    }
}

