package com.segunda.preentrega.repository;

import com.segunda.preentrega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }