package com.medcontrol.api_productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medcontrol.api_productos.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaId(Long categoriaId);

}