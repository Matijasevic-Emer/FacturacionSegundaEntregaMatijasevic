package com.segunda.preentrega.service;


import com.segunda.preentrega.model.Cliente;
import com.segunda.preentrega.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}
