package Modelo;


public class ItemsDTO {
    private int cantidad;
    private ProductoDTO Poducto;
    private PedidoDTO Pedido;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO getPoducto() {
        return Poducto;
    }

    public void setPoducto(ProductoDTO Poducto) {
        this.Poducto = Poducto;
    }

    public PedidoDTO getPedido() {
        return Pedido;
    }

    public void setPedido(PedidoDTO Pedido) {
        this.Pedido = Pedido;
    }
    
    
}
