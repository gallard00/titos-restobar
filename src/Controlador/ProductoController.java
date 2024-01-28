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

//<editor-fold defaultstate="collapsed" desc=" CRUD de Productos ">
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

    public Boolean ActualizarProducto(int idProducto, String nombre, String descripcion, float costo) {
        ProductoDTO actualizarProducto = new ProductoDTO(idProducto, nombre, descripcion, costo);
        return ProductoDAO.actualizar(actualizarProducto);
    }

    public void BorrarProducto(int id) {
        ProductoDTO borrarProducto = new ProductoDTO(id);
        ProductoDAO.borrar(borrarProducto);
        ListaProducto.remove(borrarProducto);
    }

//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc=" CRUD de Productos no Elaborados ">
    public Boolean crearProductoNoElaborado(String nombre, String descripcion, float costo) {
        ProductoDTO prod = new ProductoDTO(nombre, descripcion, costo);
        return ProductoDAO.crear(prod);
    }

    public Boolean crearProductoNoElaborado(String nombre, String descripcion, float costo, int stock) {
        ProductoNoElaboradoDTO prod = new ProductoNoElaboradoDTO(nombre, descripcion, costo, stock);
        return ProductoDAO.crear(prod);
    }

    public List leerProductoNoElaborado() {
        return ProductoDAO.mostrar();
    }

    public Boolean actualizarProductoNoElaborado(int idProducto, String nombre, String descripcion, float costo) {
        ProductoDTO actualizarProducto = new ProductoDTO(idProducto, nombre, descripcion, costo);
        return ProductoDAO.actualizar(actualizarProducto);
    }

    public void borrarProductoNoElaborado(int id) {
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

    public ProductoDTO obtenerProductoLista(int idProducto) {
        for (ProductoDTO producto : PedirListaProducto()) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    public Boolean SiProductoExiste(String nombre, String descripcion, Float costo) {
        ProductoDTO producto = (ProductoDTO) ProductoDAO.porNombre(nombre, descripcion, costo);
        if (producto != null) {
            return true;
        }
        return false;
    }

    public int obtenerUltimoIDProducto() {
        return ProductoDAO.obtenerUltimoIDProducto();
    }

    //</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc=" Datos de la Tabla de Producto">
    public Object[] RequestTableRow(int i)//solocitar fila de la tabla
    {
        Object datosfila[] = new Object[4];//datos de fila
        ProductoDTO producto = PedirListaProducto().get(i);
        if (producto != null) {
            datosfila[0] = PedirListaProducto().get(i).getIdProducto();
            datosfila[1] = PedirListaProducto().get(i).getNombre();
            datosfila[2] = PedirListaProducto().get(i).getDescripcion();
            datosfila[3] = PedirListaProducto().get(i).getCosto();
            return datosfila;
        }
        return null;
    }

    public Object[] RequestObjectIndex(int id) {
        Object datosfila[] = new Object[4];
        ProductoDTO producto = obtenerProductoLista(id);
        if (producto != null) {
            datosfila[0] = producto.getIdProducto();
            datosfila[1] = producto.getNombre();
            datosfila[2] = producto.getDescripcion();
            datosfila[3] = producto.getCosto();
        }
        return datosfila;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" Datos de la Tabla de ProductosNoElaborados">
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
