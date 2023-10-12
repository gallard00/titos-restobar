package Modelo;

import DAO.Entidad;
import java.util.List;

public class MesaDTO extends Entidad {
    
    private int id;
    private String nombre;
    private List<PedidoDTO> pedido;

    public MesaDTO() {
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
    
    

  
    
    
}
