package com.medcontrol.api_productos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProductoExternoService {

    private final RestClient restClient;

    public ProductoExternoService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
    }

    public String obtenerProductoExterno(Long id) {

        return restClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .body(String.class);
    }
}