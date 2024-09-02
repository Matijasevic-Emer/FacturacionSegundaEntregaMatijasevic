package em.preentrega.preentrega;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "VENTAPRODUCTO")
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "VENTA")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "PRODUCTO")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private int cantidad;

    // Getters, setters, constructor vacío, etc.


    public VentaProducto() {
    }

    public VentaProducto(int id, Venta venta, Producto producto, int cantidad) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VentaProducto that)) return false;
        return getId() == that.getId() && getCantidad() == that.getCantidad() && Objects.equals(getVenta(), that.getVenta()) && Objects.equals(getProducto(), that.getProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVenta(), getProducto(), getCantidad());
    }

    @Override
    public String toString() {
        return "VentaProducto{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }
}
