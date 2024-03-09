package Modelo;

import java.util.Objects;

public class ItemsDTO {

    private int id;
    private int cantidad;
    private float costoTotal;
    private ProductoCompletoDTO producto;
    private int idProducto;
    private int idPedido;

    public ItemsDTO() {
    }

    public ItemsDTO(int id) {
        this.id = id;
    }

    public ItemsDTO(ProductoCompletoDTO producto) {

        this.producto = producto;
    }

    public ItemsDTO(int cantidad, float costoTotal) {
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;

    }

    public ItemsDTO(int id, int cantidad, float costoTotal, ProductoCompletoDTO producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
    }

    public ItemsDTO(int cantidad, float costoTotal, ProductoCompletoDTO producto) {
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
    }

    public ItemsDTO(int id, int cantidad, float costoTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
    }

    public ItemsDTO(int cantidad, ProductoCompletoDTO producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public ItemsDTO(int cantidad, float costoTotal, int idProducto, int idPedido) {
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
    }

    public ItemsDTO(int id, int cantidad, float costoTotal, ProductoCompletoDTO producto, int idPedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.producto = producto;
        this.idPedido = idPedido;
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

    /*public void setCostoTotal(int cantidad, ProductoCompletoDTO producto) {

        if (producto != null) {
            this.costoTotal = producto.getPrecio() * cantidad;
        }
    }*/

    public ProductoCompletoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoCompletoDTO producto) {
        this.producto = producto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + this.cantidad;
        hash = 83 * hash + Float.floatToIntBits(this.costoTotal);
        hash = 83 * hash + Objects.hashCode(this.producto);
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
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "ItemsDTO{" + "id=" + id + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", producto=" + producto + '}';
    }

}
