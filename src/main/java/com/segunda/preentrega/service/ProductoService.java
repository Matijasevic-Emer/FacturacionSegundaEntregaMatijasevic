package com.segunda.preentrega.service;

import com.segunda.preentrega.model.Producto;
import com.segunda.preentrega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
