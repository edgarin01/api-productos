package com.medcontrol.api_productos.controller;

import com.medcontrol.api_productos.dto.ProductoDTO;
import com.medcontrol.api_productos.entity.Producto;
import com.medcontrol.api_productos.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/productos")
public ResponseEntity<?> listarProductos() {
    return ResponseEntity.ok(productoRepository.findAll());
}

    @GetMapping("/productos/{id}")
public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
    return productoRepository.findById(id)
            .map(producto -> ResponseEntity.ok(producto))
            .orElse(ResponseEntity.notFound().build());
}
@PutMapping("/productos/{id}")
public ResponseEntity<Producto> actualizarProducto(
        @PathVariable Long id,
        @RequestBody ProductoDTO productoDTO) {

    return productoRepository.findById(id)
            .map(producto -> {
                producto.setNombre(productoDTO.nombre());
                producto.setPrecio(productoDTO.precio());
                producto.setCategoria(productoDTO.categoria());

                Producto actualizado = productoRepository.save(producto);

                return ResponseEntity.ok(actualizado);
            })
            .orElse(ResponseEntity.notFound().build());
}
@DeleteMapping("/productos/{id}")
public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {

    if (!productoRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    productoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
}
    @GetMapping("/productos/buscar")
public ResponseEntity<List<Producto>> buscarPorCategoria(
        @RequestParam String categoria) {

    return ResponseEntity.ok(
            productoRepository.findByCategoria(categoria)
    );
}

    @PostMapping("/productos")
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO productoDTO) {

        Producto producto = new Producto(
                productoDTO.nombre(),
                productoDTO.precio(),
                productoDTO.categoria()
        );

        Producto productoGuardado = productoRepository.save(producto);

        return ResponseEntity.status(201).body(productoGuardado);
    }
}