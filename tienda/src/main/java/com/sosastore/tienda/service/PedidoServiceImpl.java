package com.sosastore.tienda.service;

import com.sosastore.tienda.model.*;
import com.sosastore.tienda.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final CarritoService carritoService;

    @Override
    public Pedido crearPedido(Carrito carrito) {

        Pedido pedido = new Pedido();
        pedido.setUsuario(carrito.getUsuario());
        pedido.setTotal(carritoService.calcularTotal(carrito));
        pedido.setEstado("PENDIENTE");

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido procesarPago(Carrito carrito) {

        Pedido pedido = crearPedido(carrito);
        pedido.setEstado("PAGADO");

        carritoService.vaciarCarrito(carrito);

        return pedidoRepository.save(pedido);
    }
}