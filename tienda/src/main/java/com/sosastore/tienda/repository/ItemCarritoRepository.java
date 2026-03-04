package com.sosastore.tienda.repository;

import com.sosastore.tienda.model.ItemCarrito;
import com.sosastore.tienda.model.Carrito;
import com.sosastore.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {

    List<ItemCarrito> findByCarrito(Carrito carrito);

    Optional<ItemCarrito> findByCarritoAndProducto(Carrito carrito, Producto producto);
}
