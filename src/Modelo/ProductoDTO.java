package Modelo;

import DAO.Entidad;

public class ProductoDTO extends Entidad {
    
    private int id;
    private String nombre;
    private String descripcion;
    private float costo;
    private PrecioDTO precio;

    public ProductoDTO() {
    }

    public ProductoDTO(int id, String nombre, String descripcion, float costo, PrecioDTO precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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
