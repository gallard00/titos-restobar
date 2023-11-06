package Modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PedidoDTO {
    
    private int id;
    private Date fechaApertura;
    private Date fechaCierre;
    private float descuento;
    private float costoTotal;
    private List<ItemsDTO> producto;

    public PedidoDTO() {
    }

    public PedidoDTO(int id) {
        this.id = id;
    }

    public PedidoDTO(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.producto = producto;
    }

    public PedidoDTO(int id, Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.producto = producto;
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

    public List<ItemsDTO> getProducto() {
        return producto;
    }

    public void setProducto(List<ItemsDTO> producto) {
        this.producto = producto;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.fechaApertura);
        hash = 41 * hash + Objects.hashCode(this.fechaCierre);
        hash = 41 * hash + Float.floatToIntBits(this.descuento);
        hash = 41 * hash + Float.floatToIntBits(this.costoTotal);
        hash = 41 * hash + Objects.hashCode(this.producto);
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
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", descuento=" + descuento + ", costoTotal=" + costoTotal + ", producto=" + producto + '}';
    }
    
    
}
