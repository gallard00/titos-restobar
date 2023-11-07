package Controlador;

import DAO.ProductoDAO;
import Modelo.PrecioDTO;
import Modelo.ProductoDTO;
import Modelo.ProductoNoElaboradoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private final  List<ProductoDTO> ListaProducto = new ArrayList<>();
    private static ProductoController Instance;
    private final ProductoDAO ProductoDAO;
    
       private ProductoController() throws SQLException {
        ProductoDAO = new ProductoDAO();
    }
       
     public static ProductoController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new ProductoController();
        }
        return Instance;
    }
     
     //<editor-fold defaultstate="collapsed" desc=" CRUD ">
    
    public void CreateProducto(String nombre, String descripcion, float costo, PrecioDTO precio) {
        ProductoDTO prod = new ProductoDTO(nombre, descripcion, costo, precio);
        ProductoDAO.crear(prod);
    }
    
    public void CreateProducto(String nombre, String descripcion, float costo, PrecioDTO precio, int stock) {
        ProductoNoElaboradoDTO prod = new ProductoNoElaboradoDTO(nombre, descripcion, costo, precio, stock);
        ProductoDAO.crear(prod);
    }
    
    public List ReadProductoHistorial() {
        return ProductoDAO.mostrar();
    }
    
    public void UpdateProducto(String nombre, String descripcion, float costo, PrecioDTO precio) {
        ProductoDTO prodModif = new ProductoDTO(nombre, descripcion, costo,  precio);
        ProductoDAO.actualizar(prodModif);
    }

    public void DeleteProducto(int id) {
        ProductoDTO p = new ProductoDTO(id);
        ProductoDAO.borrar(p);
        ListaProducto.remove(p);
    }
    
//</editor-fold>
    
     public void ActualizarProducto(String nombre, String descripcion, float costo, PrecioDTO precio) {
        ProductoDTO prodModif = new ProductoDTO(nombre, descripcion, costo,  precio);
        ProductoDAO.actualizar(prodModif);
    }
     
    public void BorrarProducto (int id) {
        ProductoDTO borrarProd = new ProductoDTO(id);
        ProductoDAO.borrar(borrarProd);
        ListaProducto.remove(borrarProd);
    }
}
