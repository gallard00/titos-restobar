package Modelo;

import java.util.Objects;

public class ProductoDTO {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private float costo;

    public ProductoDTO() {
    }

    public ProductoDTO(int idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoDTO(String nombre, String descripcion, float costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public ProductoDTO(int idProducto, String nombre, String descripcion, float costo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idProducto;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.descripcion);
        hash = 17 * hash + Float.floatToIntBits(this.costo);
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
        final ProductoDTO other = (ProductoDTO) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (Float.floatToIntBits(this.costo) != Float.floatToIntBits(other.costo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProductoDTO{"
                + "id=" + idProducto
                + ", nombre='" + nombre + '\''
                + ", descripcion='" + descripcion + '\''
                + ", costo=" + costo
                + '}';
    }

}
