package com.sosastore.tienda.controller;

import com.sosastore.tienda.model.Rol;
import com.sosastore.tienda.model.Usuario;
import com.sosastore.tienda.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Mostrar página de registro
    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    // Procesar registro
    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password) {

        Usuario usuario = new Usuario();
        usuario.setEmail(username);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setRol(Rol.ROLE_USER);

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }

    // Mostrar login
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}