package com.sosastore.tienda.service;

import com.sosastore.tienda.model.*;

public interface CarritoService {

    Carrito obtenerCarrito(Usuario usuario);

    void agregarProducto(Usuario usuario, Long productoId);

    void eliminarItem(Long itemId);

    Double calcularTotal(Carrito carrito);

    void vaciarCarrito(Carrito carrito);

    Pedido realizarPedido(Usuario usuario);
}