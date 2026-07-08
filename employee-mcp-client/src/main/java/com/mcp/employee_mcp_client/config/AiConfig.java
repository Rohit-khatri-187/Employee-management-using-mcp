package com.mcp.employee_mcp_client.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.Arrays;

@Configuration
public class AiConfig {

    @Value("classpath:prompts/system.st")
    private Resource systemPrompt;

    @Bean
    ChatClient chatClient(
            ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider
            ) {

        return builder
                .defaultTools(toolCallbackProvider)
                .defaultSystem(systemPrompt)
                .build();
    }

}
