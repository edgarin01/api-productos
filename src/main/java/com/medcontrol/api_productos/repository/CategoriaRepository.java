package com.medcontrol.api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medcontrol.api_productos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}