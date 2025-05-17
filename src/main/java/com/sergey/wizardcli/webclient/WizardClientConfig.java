package com.sergey.wizardcli.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WizardClientConfig {

    @Bean
    public WebClient wizardWebClient() {
        return WebClient.builder()
                .baseUrl("https://wizard-world-api.herokuapp.com")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Bean
    public WizardClient wizardClient(WebClient client) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(client))
                .build();

        return factory.createClient(WizardClient.class);
    }

}