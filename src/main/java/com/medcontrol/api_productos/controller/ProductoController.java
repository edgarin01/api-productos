package com.medcontrol.api_productos.controller;

import com.medcontrol.api_productos.dto.ProductoDTO;
import com.medcontrol.api_productos.entity.Categoria;
import com.medcontrol.api_productos.entity.Producto;
import com.medcontrol.api_productos.repository.CategoriaRepository;
import com.medcontrol.api_productos.repository.ProductoRepository;
import com.medcontrol.api_productos.service.MetricasService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MetricasService metricasService;

    public ProductoController(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository,
            MetricasService metricasService) {

        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.metricasService = metricasService;
    }

    @GetMapping("/productos")
    public ResponseEntity<?> listarProductos() {
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/productos")
    public ResponseEntity<?> crearProducto(
            @RequestBody ProductoDTO productoDTO) {

        Categoria categoria = categoriaRepository
                .findById(productoDTO.categoriaId())
                .orElse(null);

        if (categoria == null) {
            return ResponseEntity.badRequest()
                    .body("La categoría no existe");
        }

        Producto producto = new Producto(
                productoDTO.nombre(),
                productoDTO.precio(),
                categoria
        );

        Producto productoGuardado = productoRepository.save(producto);

        // Incrementar métrica personalizada
        metricasService.incrementarProductosCreados();

        return ResponseEntity.status(201).body(productoGuardado);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoDTO productoDTO) {

        return productoRepository.findById(id)
                .map(producto -> {

                    Categoria categoria = categoriaRepository
                            .findById(productoDTO.categoriaId())
                            .orElse(null);

                    if (categoria == null) {
                        return ResponseEntity.badRequest()
                                .body("La categoría no existe");
                    }

                    producto.setNombre(productoDTO.nombre());
                    producto.setPrecio(productoDTO.precio());
                    producto.setCategoria(categoria);

                    Producto actualizado = productoRepository.save(producto);

                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long id) {

        if (!productoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productos/buscar")
    public ResponseEntity<List<Producto>> buscarPorCategoria(
            @RequestParam Long categoriaId) {

        return ResponseEntity.ok(
                productoRepository.findByCategoriaId(categoriaId)
        );
    }
}