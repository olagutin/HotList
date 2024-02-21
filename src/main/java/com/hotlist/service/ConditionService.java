package com.hotlist.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Service
public class ConditionService {
    private final WebClient webClient;

    @Value("${spring.datasource.externalUrl}")
    private String externalUrl;

    public ConditionService(WebClient.Builder webClientBuilder) {
        var httpClient = HttpClient.newConnection().keepAlive(false);
        var reactorClientHttpConnector = new ReactorClientHttpConnector(httpClient);
        this.webClient = webClientBuilder.clientConnector(reactorClientHttpConnector).build();
        LOGGER.info("webClient is built");
    }

    @Scheduled(cron = "0 0/14 * * * ?")
    public void checkAvailability() throws InterruptedException {
        LOGGER.info(getDetails().toString());
    }

    public ResponseEntity<String> getDetails() {
        return webClient
                .get()
                .uri(externalUrl + "/condition")
                .retrieve()
                .toEntity(String.class)
                .block();
    }
}
