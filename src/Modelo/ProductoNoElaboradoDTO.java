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
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.stock;
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
        final ProductoNoElaboradoDTO other = (ProductoNoElaboradoDTO) obj;
        return this.stock == other.stock;
    }

    @Override
    public String toString() {
        return "ProductoNoElaboradoDTO{" + "stock=" + stock + '}';
    }
    
}
