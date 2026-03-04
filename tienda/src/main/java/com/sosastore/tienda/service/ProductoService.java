package com.sosastore.tienda.service;

import com.sosastore.tienda.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto guardar(Producto producto);
    Producto buscarPorId(Long id);
    void eliminar(Long id);
}