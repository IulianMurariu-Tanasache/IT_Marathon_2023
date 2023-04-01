package com.it.marathon.service.impl;

import com.it.marathon.config.AppProperties;
import com.it.marathon.dto.UserIdDTO;
import com.it.marathon.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceClientImpl implements UserServiceClient {

    private final WebClient webClient;

    private final AppProperties appProperties;

    @Override
    public List<Integer> getListOfOperators() {
        return webClient.get()
                .uri(URI.create(appProperties.getUserServiceURI()))
                .retrieve()
                .toEntityList(UserIdDTO.class)
                .block().getBody()
                .stream().map(UserIdDTO::getId)
                .collect(Collectors.toList());
    }
}
