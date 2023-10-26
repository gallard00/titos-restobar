package Modelo;

import DAO.Entidad;
import java.util.List;
import java.util.Objects;

public class MesaDTO extends Entidad {
    
    private int id;
    private String nombre;
    private List<PedidoDTO> pedido;

    public MesaDTO() {
    }

    public MesaDTO(int id) {
        this.id = id;
    }

    public MesaDTO(String nombre) {
        this.nombre = nombre;
    }

    public MesaDTO(String nombre, List<PedidoDTO> pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    public MesaDTO(int id, String nombre, List<PedidoDTO> pedido) {
        this.id = id;
        this.nombre = nombre;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PedidoDTO> getPedido() {
        return pedido;
    }

    public void setPedido(List<PedidoDTO> pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.pedido);
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
        final MesaDTO other = (MesaDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }

    @Override
    public String toString() {
        return "MesaDTO{" + "id=" + id + ", nombre=" + nombre + ", pedido=" + pedido + '}';
    }
    
    

  
    
    
}
