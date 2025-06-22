package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;




@Service
public class AIService {

    @Bean
    public ChatClient chatClient() {

        return null;
    }
    private final ChatClient  chatClient;


    public AIService(ChatClient.Builder builder) {
        chatClient = builder.build();

    }
    public String chat(String prompt) {
        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
