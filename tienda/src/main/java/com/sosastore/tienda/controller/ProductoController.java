package com.sosastore.tienda.controller;

import com.sosastore.tienda.dto.*;
import com.sosastore.tienda.mapper.ProductoMapper;
import com.sosastore.tienda.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ApiResponse<List<ProductoDTO>> listar() {

        var productos = productoService.listar()
                .stream()
                .map(ProductoMapper::toDTO)
                .collect(Collectors.toList());

        return new ApiResponse<>(true, productos, "Lista de productos");
    }

    @PostMapping
    public ApiResponse<ProductoDTO> crear(@RequestBody ProductoDTO dto) {

        var producto = productoService.guardar(
                ProductoMapper.toEntity(dto)
        );

        return new ApiResponse<>(true,
                ProductoMapper.toDTO(producto),
                "Producto creado");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> eliminar(@PathVariable Long id) {

        productoService.eliminar(id);
        return new ApiResponse<>(true, null, "Producto eliminado");
    }
}