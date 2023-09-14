package Modelo;


public class ItemsDTO {
    private int cantidad;
    private float costoTotal;
    private ProductoDTO producto;
    private PedidoDTO pedido;

    public ItemsDTO(int cantidad, float costoTotal, ProductoDTO producto, PedidoDTO pedido) {
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    
    
    
}
