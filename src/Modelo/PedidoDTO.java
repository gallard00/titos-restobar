package Modelo;

import java.util.Date;

public class PedidoDTO {
    private Date fechaApertura;
    private Date fechaCierre;
    private float descuento;

    public PedidoDTO(Date fechaApertura, Date fechaCierre, float descuento) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descuento = descuento;
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
