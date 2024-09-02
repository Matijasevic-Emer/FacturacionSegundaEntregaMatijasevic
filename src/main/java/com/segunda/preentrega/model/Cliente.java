package com.segunda.preentrega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private long dni;

    @Column(name = "ISACTIVO")
    private Boolean isactivo;

    @Column(name = "REPUTACION")
    private int reputacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Domicilio> domicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Venta> venta;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni, Boolean isactivo, int reputacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.isactivo = isactivo;
        this.reputacion = reputacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Boolean getIsactivo() {
        return isactivo;
    }

    public void setIsactivo(Boolean isactivo) {
        this.isactivo = isactivo;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public List<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(List<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId() == cliente.getId() &&
                getDni() == cliente.getDni() &&
                getReputacion() == cliente.getReputacion() &&
                getNombre().equals(cliente.getNombre()) &&
                getApellido().equals(cliente.getApellido()) &&
                Objects.equals(getIsactivo(), cliente.getIsactivo()) &&
                Objects.equals(getDomicilio(), cliente.getDomicilio()) &&
                Objects.equals(getVenta(), cliente.getVenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApellido(), getDni(), getIsactivo(), getReputacion(), getDomicilio(), getVenta());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", isactivo=" + isactivo +
                ", reputacion=" + reputacion +
                '}';
    }
}
