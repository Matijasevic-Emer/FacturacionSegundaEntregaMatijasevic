package com.segunda.preentrega.controller;

import com.segunda.preentrega.model.VentaProducto;
import com.segunda.preentrega.service.VentaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta-productos")
public class VentaProductoController {

    @Autowired
    private VentaProductoService ventaProductoService;

    @PostMapping("/agregar")
    public ResponseEntity<VentaProducto> agregarVentaProducto(@RequestBody VentaProducto ventaProducto) {
        try {
            VentaProducto nuevoVentaProducto = ventaProductoService.agregarVentaProducto(ventaProducto);
            return new ResponseEntity<>(nuevoVentaProducto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Manejo de error si el producto o la venta no se encuentran
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<VentaProducto> buscarVentaProducto(@PathVariable Long id) {
        Optional<VentaProducto> ventaProducto = ventaProductoService.buscarVentaProducto(id);
        return ventaProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public List<VentaProducto> listarVentaProductos() {
        return ventaProductoService.listarVentaProductos();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVentaProducto(@PathVariable Long id) {
        try {
            ventaProductoService.eliminarVentaProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Manejo de error si ocurre un problema al eliminar
            return ResponseEntity.notFound().build();
        }
    }
}
