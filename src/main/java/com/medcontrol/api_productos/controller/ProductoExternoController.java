package com.medcontrol.api_productos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcontrol.api_productos.service.ProductoExternoService;

@RestController
@RequestMapping("/api-externa")
public class ProductoExternoController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductoExternoController.class);

    private final ProductoExternoService productoExternoService;

    public ProductoExternoController(
            ProductoExternoService productoExternoService) {

        this.productoExternoService = productoExternoService;
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> obtenerProductoExterno(
            @PathVariable Long id) {

        try {

            logger.info("Consultando producto externo con ID: {}", id);

            String respuesta =
                    productoExternoService.obtenerProductoExterno(id);

            logger.info(
                    "Producto externo consultado correctamente con ID: {}",
                    id
            );

            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {

            logger.error(
                    "Error al consultar el producto externo con ID: {}",
                    id,
                    e
            );

            return ResponseEntity
                    .status(502)
                    .body("No fue posible consultar la API externa");
        }
    }
}