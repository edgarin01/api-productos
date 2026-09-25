package com.medcontrol.api_productos.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricasService {

    private final Counter productosCreados;

    public MetricasService(MeterRegistry meterRegistry) {
        this.productosCreados = Counter.builder("productos_creados_total")
                .description("Cantidad de productos creados")
                .register(meterRegistry);
    }

    public void incrementarProductosCreados() {
        productosCreados.increment();
    }
}