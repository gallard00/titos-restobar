package Modelo;

import java.util.Objects;

public class ProductoCompletoDTO {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private float costo;
    private float precio;
    private int stock;

    public ProductoCompletoDTO(int idProducto, String nombre, String descripcion, float costo, float precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoCompletoDTO(String nombre, String descripcion, float costo, float precio, int stock) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoCompletoDTO(String nombre, String descripcion, float precio, int stock) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoCompletoDTO(int idProducto, String nombre, String descripcion, float precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public ProductoCompletoDTO(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public ProductoCompletoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ProductoCompletoDTO() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idProducto;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.descripcion);
        hash = 31 * hash + Float.floatToIntBits(this.costo);
        hash = 31 * hash + Float.floatToIntBits(this.precio);
        hash = 31 * hash + this.stock;
        return hash;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductoCompletoDTO other = (ProductoCompletoDTO) obj;
        return this.idProducto == other.idProducto
                && Float.compare(this.costo, other.costo) == 0
                && Float.compare(this.precio, other.precio) == 0
                && this.stock == other.stock
                && Objects.equals(this.nombre, other.nombre)
                && Objects.equals(this.descripcion, other.descripcion);
    }

    // toString()
    @Override
    public String toString() {
        return "ProductoCompletoDTO{"
                + "idProducto=" + idProducto
                + ", nombre='" + nombre + '\''
                + ", descripcion='" + descripcion + '\''
                + ", costo=" + costo
                + ", precio=" + precio
                + ", stock=" + stock
                + '}';
    }
}
