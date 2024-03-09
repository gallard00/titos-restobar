package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PedidoDTO {

    public enum EstadoPedido {
        ACTIVO, CERRADO
    }

    private int id;
    private Date fechaApertura;
    private Date fechaCierre;
    private float descuento;
    private float costoTotal;
    private List<ItemsDTO> items;
    private EstadoPedido estadoPedido;
    private int idMesa;

    public PedidoDTO() {
    }

    public PedidoDTO(int id) {
        this.id = id;
    }

    public PedidoDTO(int id, Date fechaApertura, Date fechaCierre, float costoTotal) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.costoTotal = costoTotal;

    }

    public PedidoDTO(int id, Date fechaCierre, float descuento, float costoTotal, EstadoPedido estadoPedido) {
        this.id = id;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.estadoPedido = estadoPedido;

    }

    public PedidoDTO(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, EstadoPedido estadoPedido, int idMesa) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.estadoPedido = estadoPedido;
        this.idMesa = idMesa;
    }

    public PedidoDTO(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> items, EstadoPedido estadoPedido) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.items = items;
        this.estadoPedido = estadoPedido;
    }

    public PedidoDTO(int id, Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, int idMesa, EstadoPedido estadoPedido) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.idMesa = idMesa;
        this.estadoPedido = estadoPedido;

    }

    public PedidoDTO(int id, Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> items, EstadoPedido estadoPedido, int idMesa) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.items = items;
        this.estadoPedido = estadoPedido;
        this.idMesa = idMesa;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<ItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemsDTO> items) {
        this.items = items;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getIdMesa() {
        return this.idMesa;
    }

    public void setIdMesas(int idMesa) {
        this.idMesa = idMesa;
    }

    public void agregarItem(ItemsDTO item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.fechaApertura);
        hash = 41 * hash + Objects.hashCode(this.fechaCierre);
        hash = 41 * hash + Float.floatToIntBits(this.descuento);
        hash = 41 * hash + Float.floatToIntBits(this.costoTotal);
        hash = 41 * hash + Objects.hashCode(this.items);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoDTO other = (PedidoDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.descuento) != Float.floatToIntBits(other.descuento)) {
            return false;
        }
        if (Float.floatToIntBits(this.costoTotal) != Float.floatToIntBits(other.costoTotal)) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        if (!Objects.equals(this.fechaCierre, other.fechaCierre)) {
            return false;
        }
        return Objects.equals(this.items, other.items);
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", descuento=" + descuento + ", costoTotal=" + costoTotal + ", producto=" + items + '}';
    }

}
