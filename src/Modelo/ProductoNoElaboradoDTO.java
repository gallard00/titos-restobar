package Modelo;


public class ProductoNoElaboradoDTO extends ProductoDTO {
    
    private int stock;

    public ProductoNoElaboradoDTO(int stock, int id, String nombre, String descripcion, float costo, PrecioDTO precio) {
        super(id, nombre, descripcion, costo, precio);
        this.stock = stock;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
