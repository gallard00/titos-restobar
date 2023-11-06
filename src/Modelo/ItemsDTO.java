package Modelo;

import java.util.Objects;


public class ItemsDTO {
    
    private int id;
    private int cantidad;
    private float costoTotal;
    private ProductoDTO producto;
    private PedidoDTO pedido;

    public ItemsDTO(int id) {
        this.id = id;
    }

    public ItemsDTO(int cantidad, float costoTotal, ProductoDTO producto, PedidoDTO pedido) {
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    public ItemsDTO(int id, int cantidad, float costoTotal, ProductoDTO producto, PedidoDTO pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private void calcularCostoTotal()
    {
        this.costoTotal = this.producto.getPrecio().getValor() * this.getCantidad();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Float.floatToIntBits(this.costoTotal);
        hash = 97 * hash + Objects.hashCode(this.producto);
        hash = 97 * hash + Objects.hashCode(this.pedido);
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
        final ItemsDTO other = (ItemsDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Float.floatToIntBits(this.costoTotal) != Float.floatToIntBits(other.costoTotal)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }

    @Override
    public String toString() {
        return "ItemsDTO{" + "id=" + id + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", producto=" + producto + ", pedido=" + pedido + '}';
    }
    
}
