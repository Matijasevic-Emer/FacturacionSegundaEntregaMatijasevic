package em.preentrega.preentrega;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

//Uso el decorador @Table para redefinir el nombre de la tbla por defecto se llamaria Cliente, lo cambio a CLIENTE
//Misma accion par las columnas con @Column
@Entity
@Table(name="CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private  String apellido;

    @Column(name = "DNI")
    private  long dni;

    @Column(name = "ISACTIVO")
    private Boolean isactivo;

    @Column(name = "REPUTACION")
    private int reputacion;

    //Un att lista que tiene obj Domicilio
    //Un cliente puede tener muchos domicilios => uso OneToMany para hacer una relacion de una sola direccion
    //Cliente es el responsable de los domicilios (Si se elimina el cliente no me interesan los domicilios)
    //Para que al crear un cliente se obligue a cagar un domicilio le digo que Cliente sea el "trabajador" FetchType.EAGER y  Domicilio le "peresozo" FetchType.LAZY
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Domicilio> domicilio;

    //Un cliente puede estar involucrado en muchas ventas, pero una venta solo involucra un cliente
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Venta> venta;


    /* -------------------------------------------------------------------------------
    Desde aca autogenrado ; geter - seter - consutructor vacio para sprint
                            - constructor - sobreescribo equal hash y tostring
    ----------------------------------------------------------------------------------*/
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni, Boolean isactivo, int reputacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.isactivo = isactivo;
        this.reputacion = reputacion;
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

    public List<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(List<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId() == cliente.getId() && getDni() == cliente.getDni() && getNombre().equals(cliente.getNombre()) && getApellido().equals(cliente.getApellido()) && getDomicilio().equals(cliente.getDomicilio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApellido(), getDni(), getDomicilio());
    }

    @java.lang.Override
    public java.lang.String toString() {
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
