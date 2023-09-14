package Modelo;

import java.util.List;

public class MesaDTO {
    private String nombre;
    private List<PedidoDTO> pedido;

    public MesaDTO(String nombre, List<PedidoDTO> pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    public MesaDTO() {
        
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
