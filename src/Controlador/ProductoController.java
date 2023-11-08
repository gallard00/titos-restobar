package Controlador;

import DAO.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.ProductoNoElaboradoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<ProductoDTO> ListaProducto = new ArrayList<>();
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
    
    public Boolean CrearProducto(String nombre, String descripcion, float costo) {
        ProductoDTO prod = new ProductoDTO(nombre, descripcion, costo);
        return ProductoDAO.crear(prod);
    }
    
    public Boolean CrearProducto(String nombre, String descripcion, float costo, int stock) {
        ProductoNoElaboradoDTO prod = new ProductoNoElaboradoDTO(nombre, descripcion, costo, stock);
        return ProductoDAO.crear(prod);
    }
    
    public List LeerProducto() {
        return ProductoDAO.mostrar();
    }
    
    public Boolean ActualizarProducto(int id, String nombre, String descripcion, float costo) {
        ProductoDTO actualizarProducto = new ProductoDTO(id, nombre, descripcion, costo);
        return ProductoDAO.actualizar(actualizarProducto);
    }

    public void BorrarProducto(int id) {
        ProductoDTO borrarProducto = new ProductoDTO(id);
        ProductoDAO.borrar(borrarProducto);
        ListaProducto.remove(borrarProducto);
    }
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc=" Metodos de las Clases ">
    public List<ProductoDTO> PedirListaProducto() {
        ListaProducto = LeerProducto();
        return ListaProducto;
    }
    
    public ProductoDTO getProductoFromList(int id){
        for (ProductoDTO producto : PedirListaProducto())
        {
            if(producto.getId() == id)
            {
                return producto;
            }
        }
        return null;
    }
  //</editor-fold> 
    
    
    
    public Boolean SiProductoExiste(String nombre, String descripcion)
    {
        ProductoDTO producto = (ProductoDTO)ProductoDAO.porNombre(nombre, descripcion);
        if(producto != null)
        {
            return true;
        }
        return false;
    }
//<editor-fold defaultstate="collapsed" desc=" Datos de la Tabla Rows&Index">
    
    public Object[] RequestTableRow(int i)//solocitar fila de la tabla
    {
        Object datosfila[] = new Object[4];//datos de fila
        ProductoDTO producto = PedirListaProducto().get(i);
        if(producto != null)
        {
            datosfila[0] = PedirListaProducto().get(i).getId();
            datosfila[1] = PedirListaProducto().get(i).getNombre();
            datosfila[2] = PedirListaProducto().get(i).getDescripcion();
            datosfila[3] = PedirListaProducto().get(i).getCosto();
            return datosfila;
        }
        return null;
    }
    
    public Object[] RequestObjectIndex(int id)
    {
        Object datosfila[] = new Object[4];
        ProductoDTO producto = getProductoFromList(id);
        if(producto != null)
        {
            datosfila[0] =  producto.getId();
            datosfila[1] =  producto.getNombre();
            datosfila[2] =  producto.getDescripcion();
            datosfila[3] =  producto.getCosto();
        }
        return datosfila;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Datos de la Tabla Rows&Index">
    /*
    public Object[] RequestTableRow(int i)
    {
        Object rowdata[] = new Object[5];
        ProductoNoElaboradoDTO mesa = PedirListaProducto().get(i);
        if(mesa != null)
        {
            rowdata[0] = PedirListaProducto().get(i).getId();
            rowdata[1] = PedirListaProducto().get(i).getNombre();
            rowdata[2] = PedirListaProducto().get(i).getDescripcion();
            rowdata[3] = PedirListaProducto().get(i).getCosto();
            rowdata[4] = PedirListaProducto().get(i).getStock();
            return rowdata;
        }
        return null;
    }
    
    public Object[] RequestObjectIndex(int id)
    {
        Object rowdata[] = new Object[5];
        ProductoDTO producto = getMesaFromList(id);
        if(producto != null)
        {
            rowdata[0] =  producto.getId();
            rowdata[1] =  producto.getNombre();
            rowdata[2] =  producto.getDescripcion();
            rowdata[3] =  producto.getCosto();
            rowdata[4] =  producto.getStock();
        }
        return rowdata;
    }*/
//</editor-fold>

}
