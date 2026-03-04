package com.sosastore.tienda.service;

import com.sosastore.tienda.model.*;

public interface PedidoService {

    Pedido crearPedido(Carrito carrito);

    Pedido procesarPago(Carrito carrito);
}