package com.hotlist.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConditionService {
    private final WebClient webClient;

    @Value("${spring.datasource.externalUrl}")
    private String externalUrl;

    public ConditionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(externalUrl).build();
    }

    @Scheduled(cron = "0 0/14 * * * ?")
    public void checkAvailability() {
        System.out.println(webClient.get().uri("/condition")
                .retrieve().toEntity(String.class)
                .block());
    }
}
