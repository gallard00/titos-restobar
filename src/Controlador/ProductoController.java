package Controlador;

import DAO.ProductoDAO;
import DAO.ProductoNoElaboradoDAO;
import Modelo.ProductoDTO;
import Modelo.ProductoNoElaboradoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {

    private List<ProductoDTO> ListaProducto = new ArrayList<>();
    private List<ProductoNoElaboradoDTO> listaProductoNoElaborado = new ArrayList<>();
    private static ProductoController Instance;
    private final ProductoDAO ProductoDAO;
    private final ProductoNoElaboradoDAO productoNoElaboradoDAO;

    private ProductoController() throws SQLException {
        ProductoDAO = new ProductoDAO();
        productoNoElaboradoDAO = new ProductoNoElaboradoDAO();
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
  public Boolean crearProductoNoElaborado(int idProducto, int stock) {
        return productoNoElaboradoDAO.crear(new ProductoNoElaboradoDTO(idProducto, stock));
    }

    public List<ProductoNoElaboradoDTO> leerProductoNoElaborado() {
        return productoNoElaboradoDAO.mostrarProductosNoElaborados();
    }

    /*
    public Boolean actualizarProductoNoElaborado(int idProducto, int stock) {
        ProductoNoElaboradoDTO actualizarProducto = new ProductoNoElaboradoDTO(idProducto, stock);
        return productoNoElaboradoDAO.actualizarProductoNoElaborado(actualizarProducto);
    }
     */
    public Boolean actualizarProductoNoElaborado(int idProducto, int stock) {
        // Aquí obtienes el ProductoDTO que deseas convertir
        ProductoDTO productoDTO = obtenerProductoLista(idProducto);

        // Verifica que el ProductoDTO obtenido no sea nulo
        if (productoDTO != null) {
            // Creas un ProductoNoElaboradoDTO a partir del ProductoDTO y el stock proporcionado
            ProductoNoElaboradoDTO productoNoElaboradoDTO = new ProductoNoElaboradoDTO(productoDTO.getIdProducto(), productoDTO.getNombre(), productoDTO.getDescripcion(), productoDTO.getCosto(), stock);

            // Luego puedes realizar las operaciones necesarias con productoNoElaboradoDTO
            return productoNoElaboradoDAO.actualizarProductoNoElaborado(productoNoElaboradoDTO);
        } else {
            // Manejo de caso en el que no se encuentra el ProductoDTO con el ID proporcionado
            return false;
        }
    }

    public void borrarProductoNoElaborado(int idProducto) {
        ProductoNoElaboradoDTO productoNoElaborado = obtenerProductoNoElaboradoLista(idProducto);
        productoNoElaboradoDAO.borrarProductoNoElaborado(idProducto);
        listaProductoNoElaborado.remove(productoNoElaborado);
    }
//</editor-fold>   
//<editor-fold defaultstate="collapsed" desc=" Metodos de la clase ProductoNoElaborado ">

    public List<ProductoNoElaboradoDTO> pedirListaProductoNoElaborado() {
        listaProductoNoElaborado = leerProductoNoElaborado();
        return listaProductoNoElaborado;
    }

    public ProductoNoElaboradoDTO obtenerProductoNoElaboradoLista(int idProducto) {
        for (ProductoNoElaboradoDTO productoNoElaborado : pedirListaProductoNoElaborado()) {
            if (productoNoElaborado.getIdProducto() == idProducto) {
                return productoNoElaborado;
            }
        }
        return null;
    }



//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Metodos de la clase Producto ">
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
    public Object[] filaTablaProductoNoElaborado(int i) {
        Object datosFila[] = new Object[1];
        ProductoNoElaboradoDTO productoNoElaborado = pedirListaProductoNoElaborado().get(i);
        if (productoNoElaborado != null) {
            datosFila[0] = pedirListaProductoNoElaborado().get(i).getStock();
            return datosFila;
        }
        return null;
    }

    public Object[] indiceProductoNoElaborado(int id) {
        Object datosFila[] = new Object[1];
        ProductoNoElaboradoDTO productoNoElaborado = obtenerProductoNoElaboradoLista(id);
        if (productoNoElaborado != null) {
            datosFila[0] = productoNoElaborado.getStock();
        }
        return datosFila;
    }
//</editor-fold>
}
