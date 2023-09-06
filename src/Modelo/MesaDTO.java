package Modelo;

import java.util.List;

public class MesaDTO {
    private String nombre;
    private List<PedidoDTO> Pedido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PedidoDTO> getPedido() {
        return Pedido;
    }

    public void setPedido(List<PedidoDTO> Pedido) {
        this.Pedido = Pedido;
    }
    
    

  
    
    
}
