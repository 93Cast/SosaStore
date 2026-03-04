package com.sosastore.tienda.controller;

import com.sosastore.tienda.model.Pedido;
import com.sosastore.tienda.model.Usuario;
import com.sosastore.tienda.service.CarritoService;
import com.sosastore.tienda.service.PedidoService;
import com.sosastore.tienda.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CarritoService carritoService;

    @PostMapping("/checkout")
    public Pedido checkout(Authentication authentication) {

        Usuario usuario = (Usuario) authentication.getPrincipal();

        return carritoService.realizarPedido(usuario);
    }
}