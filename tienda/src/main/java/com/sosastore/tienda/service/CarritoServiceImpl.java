package com.sosastore.tienda.service;

import com.sosastore.tienda.model.*;
import com.sosastore.tienda.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    private final ItemCarritoRepository itemCarritoRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    public Carrito obtenerCarrito(Usuario usuario) {
        return carritoRepository.findByUsuario(usuario)
                .orElseGet(() -> {
                    Carrito nuevoCarrito = Carrito.builder()
                            .usuario(usuario)
                            .items(new ArrayList<>())
                            .build();
                    return carritoRepository.save(nuevoCarrito);
                });
    }

    @Override
    public void agregarProducto(Usuario usuario, Long productoId) {

        Carrito carrito = obtenerCarrito(usuario);
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Optional<ItemCarrito> itemExistente =
                itemCarritoRepository.findByCarritoAndProducto(carrito, producto);

        if (itemExistente.isPresent()) {
            ItemCarrito item = itemExistente.get();
            item.setCantidad(item.getCantidad() + 1);
            itemCarritoRepository.save(item);
        } else {
            ItemCarrito nuevo = ItemCarrito.builder()
                    .carrito(carrito)
                    .producto(producto)
                    .cantidad(1)
                    .build();
            itemCarritoRepository.save(nuevo);
        }
    }

    @Override
    public void eliminarItem(Long itemId) {
        itemCarritoRepository.deleteById(itemId);
    }

    @Override
    public Double calcularTotal(Carrito carrito) {
        return carrito.getItems().stream()
                .mapToDouble(i -> i.getProducto().getPrecio() * i.getCantidad())
                .sum();
    }

    @Override
    public void vaciarCarrito(Carrito carrito) {
        carrito.getItems().clear();
        carritoRepository.save(carrito);
    }

    @Override
    public Pedido realizarPedido(Usuario usuario) {

        Carrito carrito = obtenerCarrito(usuario);

        if (carrito.getItems().isEmpty()) {
            throw new RuntimeException("El carrito está vacío");
        }

        Pedido pedido = Pedido.builder()
                .usuario(usuario)
                .fecha(LocalDateTime.now())
                .estado("PAGADO")
                .total(calcularTotal(carrito))
                .build();

        List<DetallePedido> detalles = carrito.getItems().stream()
                .map(item -> DetallePedido.builder()
                        .pedido(pedido)
                        .nombreProducto(item.getProducto().getNombre())
                        .precioUnitario(item.getProducto().getPrecio())
                        .cantidad(item.getCantidad())
                        .build())
                .toList();

        pedido.setDetalles(detalles);

        Pedido guardado = pedidoRepository.save(pedido);

        vaciarCarrito(carrito);

        return guardado;
    }
}