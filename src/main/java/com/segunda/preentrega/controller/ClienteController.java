package com.segunda.preentrega.controller;

import com.segunda.preentrega.model.Cliente;
import com.segunda.preentrega.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping("/agregar")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }
}
