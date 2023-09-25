package Modelo;

import java.util.List;

public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private PrecioDTO precio;

    public ProductoDTO(String nombre, String descripcion, PrecioDTO precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public PrecioDTO getPrecio() {
        return precio;
    }

    public void setPrecio(PrecioDTO precio) {
        this.precio = precio;
    }
       
}
