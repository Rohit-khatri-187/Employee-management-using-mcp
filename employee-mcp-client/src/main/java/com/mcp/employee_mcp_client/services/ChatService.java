package com.mcp.employee_mcp_client.services;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/user.st")
    private Resource userPrompt;

    public Flux<String> chat(String query) {
        return chatClient.prompt()
                .user(user -> user.text(this.userPrompt).param("message",query))
                .stream()
                .content();
    }

}
