package com.sosastore.tienda.controller;

import com.sosastore.tienda.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final ProductoService productoService;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("productos", productoService.listar());
        return "index";
    }
}