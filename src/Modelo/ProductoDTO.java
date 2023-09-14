package Modelo;

import java.util.List;

public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private List<PrecioDTO> precios;

    public ProductoDTO(String nombre, String descripcion, List<PrecioDTO> precios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precios = precios;
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

    public List<PrecioDTO> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioDTO> precios) {
        this.precios = precios;
    }
       
}
