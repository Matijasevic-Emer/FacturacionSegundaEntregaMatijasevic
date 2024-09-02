package com.segunda.preentrega.service;

import com.segunda.preentrega.model.Venta;
import com.segunda.preentrega.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVenta(Long id) {
        return ventaRepository.findById(id);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
