package com.medcontrol.api_productos.controller;

import com.medcontrol.api_productos.dto.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @GetMapping("/productos")
    public String listarProductos() {
        return "Lista de productos funcionando";
    }

    @GetMapping("/productos/{id}")
    public String obtenerProducto(@PathVariable int id) {
        return "Producto solicitado: " + id;
    }

    @GetMapping("/productos/buscar")
    public String buscarPorCategoria(@RequestParam String categoria) {
        return "Buscando productos de la categoría: " + categoria;
    }

    @PostMapping("/productos")
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO producto) {
        return ResponseEntity.status(201).body(producto);
    }
}