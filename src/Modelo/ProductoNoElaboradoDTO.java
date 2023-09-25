package Modelo;


public class ProductoNoElaboradoDTO extends ProductoDTO {
    private int stock;

    public ProductoNoElaboradoDTO(int stock, String nombre, String descripcion, PrecioDTO precio) {
        super(nombre, descripcion, precio);
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
