package com.medcontrol.api_productos.service;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class EstadoApiHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        return Health.up()
                .withDetail("servicio", "API de productos")
                .withDetail("estado", "Operativo")
                .build();
    }
}