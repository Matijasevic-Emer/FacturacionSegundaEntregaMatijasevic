package em.preentrega.preentrega;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "STOCK")
    private int stock;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VentaProducto> ventas;

    //- -----------------------------------------------------------------------------
    // Getters, setters, constructor vacío, sobreescribo hash equlas y tostring, etc.
    //- -----------------------------------------------------------------------------

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return getId() == producto.getId() && Double.compare(producto.getPrecio(), getPrecio()) == 0 && getStock() == producto.getStock() && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(ventas, producto.ventas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPrecio(), getStock(), ventas);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
