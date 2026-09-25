package com.medcontrol.api_productos.dto;

public record ProductoDTO(
        String nombre,
        double precio,
        Long categoriaId
) {
}