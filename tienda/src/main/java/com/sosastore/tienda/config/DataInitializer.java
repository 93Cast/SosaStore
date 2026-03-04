package com.sosastore.tienda.config;

import com.sosastore.tienda.model.Rol;
import com.sosastore.tienda.model.Usuario;
import com.sosastore.tienda.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (usuarioRepository.findByEmail("admin@sosa.com").isEmpty()) {

            Usuario admin = new Usuario();
            admin.setEmail("admin@sosa.com");
            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRol(Rol.ROLE_ADMIN);

            usuarioRepository.save(admin);
        }
    }
}