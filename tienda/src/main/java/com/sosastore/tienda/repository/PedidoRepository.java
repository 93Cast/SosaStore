package com.sosastore.tienda.repository;

import com.sosastore.tienda.model.Pedido;
import com.sosastore.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuario(Usuario usuario);
}