package com.sosastore.tienda.controller;

import com.sosastore.tienda.model.Usuario;
import com.sosastore.tienda.service.CarritoService;
import com.sosastore.tienda.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;
    private final UsuarioService usuarioService;

    @GetMapping
    public String verCarrito(Authentication auth, Model model) {

        Usuario usuario = usuarioService
                .buscarPorEmail(auth.getName());

        var carrito = carritoService.obtenerCarrito(usuario);

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", carritoService.calcularTotal(carrito));

        return "cliente/carrito";
    }

    @PostMapping("/agregar/{id}")
    public String agregarProducto(@PathVariable Long id,
                                  Authentication auth) {

        Usuario usuario = usuarioService
                .buscarPorEmail(auth.getName());

        carritoService.agregarProducto(usuario, id);

        return "redirect:/cliente/carrito";
    }

    @PostMapping("/eliminar/{itemId}")
    public String eliminarItem(@PathVariable Long itemId) {

        carritoService.eliminarItem(itemId);
        return "redirect:/cliente/carrito";
    }
}