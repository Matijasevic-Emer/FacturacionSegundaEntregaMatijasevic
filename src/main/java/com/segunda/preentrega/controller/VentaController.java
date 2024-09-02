package com.segunda.preentrega.controller;

import com.segunda.preentrega.model.Venta;
import com.segunda.preentrega.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/agregar")
    public Venta agregarVenta(@RequestBody Venta venta) {
        return ventaService.agregarVenta(venta);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Venta> buscarVenta(@PathVariable Long id) {
        return ventaService.buscarVenta(id);
    }

    @GetMapping("/listar")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
    }
}
