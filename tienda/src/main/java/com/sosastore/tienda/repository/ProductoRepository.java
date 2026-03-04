package com.sosastore.tienda.repository;

import com.sosastore.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByPrecioBetween(Double min, Double max);

    List<Producto> findByStockGreaterThan(Integer stock);
}