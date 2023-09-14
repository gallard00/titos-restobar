package Modelo;

import java.util.List;

public class ProductoNoElaboradoDTO extends ProductoDTO {
    private int stock;

    public ProductoNoElaboradoDTO(int stock, String nombre, String descripcion, List<PrecioDTO> precios) {
        super(nombre, descripcion, precios);
        this.stock = stock;
    }

    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
