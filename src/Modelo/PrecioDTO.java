package Modelo;

import DAO.Entidad;
import java.util.Date;

public class PrecioDTO extends Entidad {
    
    private int id;
    private float valor;
    private Date fecha;

    public PrecioDTO(int id, float valor, Date fecha) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
