package com.medcontrol.api_productos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcontrol.api_productos.entity.Categoria;
import com.medcontrol.api_productos.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(
            @RequestBody Categoria categoria) {

        Categoria categoriaGuardada =
                categoriaRepository.save(categoria);

        return ResponseEntity.status(201).body(categoriaGuardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(
            @PathVariable Long id) {

        return categoriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}