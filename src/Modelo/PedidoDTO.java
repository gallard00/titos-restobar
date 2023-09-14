package Modelo;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Date fechaApertura;
    private Date fechaCierre;
    private float descuento;
    private float costoTotal;
    private List<ItemsDTO> producto;

    public PedidoDTO(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
        this.costoTotal = costoTotal;
        this.producto = producto;
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
    
    
}
