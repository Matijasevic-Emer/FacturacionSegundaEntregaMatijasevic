package em.preentrega.preentrega;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VENTA")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "TOTAL")
    private double total;

    // Relación con la clase Cliente, indicando que una venta pertenece a un cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE")
    private Cliente cliente;

    // Relación con la tabla intermedia VentaProducto
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VentaProducto> productos;

    //- -----------------------------------------------------------------------------
    // Constructor vacío, getters, setters, equals, hashCode, toString
    //- -----------------------------------------------------------------------------


    public Venta() {
    }

    public Venta(int id, Date fecha, double total, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<VentaProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<VentaProducto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta venta)) return false;
        return getId() == venta.getId() && Double.compare(venta.getTotal(), getTotal()) == 0 && Objects.equals(getFecha(), venta.getFecha()) && Objects.equals(getCliente(), venta.getCliente()) && Objects.equals(getProductos(), venta.getProductos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha(), getTotal(), getCliente(), getProductos());
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}