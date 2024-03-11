package Modelo;

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
}
