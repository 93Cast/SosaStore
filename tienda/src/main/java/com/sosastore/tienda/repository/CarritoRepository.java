package com.sosastore.tienda.repository;

import com.sosastore.tienda.model.Carrito;
import com.sosastore.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    Optional<Carrito> findByUsuario(Usuario usuario);
}
