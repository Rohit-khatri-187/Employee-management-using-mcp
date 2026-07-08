package com.mcp.employee_mcp_client.controllers;


import com.mcp.employee_mcp_client.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public ResponseEntity<Flux<String>> chat(
            @RequestParam(value = "q",required = true) String q
    ){
        Flux<String> response = chatService.chat(q);

        return ResponseEntity.ok(response);

    }

}
