package Modelo;

import java.util.Date;

public class PrecioDTO {
    private float valor;
    private Date fecha;

    public PrecioDTO(float valor, Date fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
