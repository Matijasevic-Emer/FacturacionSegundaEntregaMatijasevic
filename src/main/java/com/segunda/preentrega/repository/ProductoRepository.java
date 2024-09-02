package com.segunda.preentrega.repository;

import com.segunda.preentrega.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> { }
