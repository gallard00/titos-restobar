package Modelo;

import DAO.Entidad;
import java.util.Date;
import java.util.Objects;

public class PrecioDTO extends Entidad {
    
    private int id;
    private float valor;
    private Date fecha;

    public PrecioDTO() {
    }

    public PrecioDTO(int id) {
        this.id = id;
    }

    public PrecioDTO(float valor, Date fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Float.floatToIntBits(this.valor);
        hash = 29 * hash + Objects.hashCode(this.fecha);
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
        final PrecioDTO other = (PrecioDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return "PrecioDTO{" + "id=" + id + ", valor=" + valor + ", fecha=" + fecha + '}';
    }
    
    
}
