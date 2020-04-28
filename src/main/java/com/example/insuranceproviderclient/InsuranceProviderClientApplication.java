package com.example.insuranceproviderclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "/list")

public class InsuranceProviderClientApplication {

    @Value("${insurance.url}")
    private String url;

    public static void main(String[] args) {

        SpringApplication.run(InsuranceProviderClientApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/new")
    public ResponseEntity getValue() {

        return getResponseEntity();
    }

    /** response entity is as same as List<></>
     * @return
     */
    private ResponseEntity getResponseEntity() {

        return getRestTemplate().
                exchange(url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<String>>() {
                        });
    }
}
