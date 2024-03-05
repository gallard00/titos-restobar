package Controlador;

import DAO.ProductoDAO;
import DAO.ProductoNoElaboradoDAO;
import Modelo.ProductoCompletoDTO;
import Modelo.ProductoDTO;
import Modelo.ProductoNoElaboradoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoController {

    private List<ProductoDTO> ListaProducto = new ArrayList<>();
    private List<ProductoNoElaboradoDTO> listaProductoNoElaborado = new ArrayList<>();
    private List<ProductoCompletoDTO> listaProductoCompleto = new ArrayList<>();
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

    public void BorrarProducto(int idProducto) throws SQLException {
        // Obtener el producto completo
        ProductoCompletoDTO productoCompleto = obtenerProductoCompletoLista(idProducto);

        // Verificar si se encontró el producto completo
        if (productoCompleto != null) {
            // Borrar el producto
            ProductoDTO producto = new ProductoDTO(productoCompleto.getIdProducto(), productoCompleto.getNombre(), productoCompleto.getDescripcion(), productoCompleto.getCosto());
            ProductoDAO.borrar(producto);

            // Remover el producto completo de la lista
            listaProductoCompleto.remove(productoCompleto);

            // Borrar el precio relacionado con el producto
            PrecioController.GetInstance().BorrarPrecio(idProducto);
        } else {
            // Manejar el caso en el que no se encuentra el producto
            System.out.println("El producto con ID " + idProducto + " no se encontró.");
        }

    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" CRUD de Productos no Elaborados ">
    public Boolean crearProductoNoElaborado(int idProducto, int stock) {
        return productoNoElaboradoDAO.crear(new ProductoNoElaboradoDTO(idProducto, stock));
    }

    public List<ProductoNoElaboradoDTO> leerProductoNoElaborado() {
        return productoNoElaboradoDAO.mostrarProductosNoElaborados();
    }

    
    public Boolean actualizarProductoNoElaborado(int idProducto, int stock) {
        ProductoNoElaboradoDTO actualizarProducto = new ProductoNoElaboradoDTO(idProducto, stock);
        return productoNoElaboradoDAO.actualizarProductoNoElaborado(actualizarProducto);
    }
    public void borrarProductoNoElaborado(int idProducto) throws SQLException {
        ProductoCompletoDTO productoCompleto = obtenerProductoCompletoLista(idProducto);

        // Verificar si se encontró el producto completo
        if (productoCompleto != null) {
            // Borrar el producto
            ProductoNoElaboradoDTO producto = new ProductoNoElaboradoDTO(productoCompleto.getIdProducto(), productoCompleto.getStock());

            productoNoElaboradoDAO.borrarProductoNoElaborado(producto);

            // Remover el producto completo de la lista
            listaProductoCompleto.remove(productoCompleto);

            // Borrar el precio relacionado con el producto
            BorrarProducto(idProducto);
        } else {
            // Manejar el caso en el que no se encuentra el producto
            System.out.println("El producto con ID " + idProducto + " no se encontró.");
        }

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
    //<editor-fold defaultstate="collapsed" desc=" Metodos de la clase Producto Completo ">  
    public List leerProducto() throws SQLException {
        return ProductoDAO.obtenerProductosCompletos();
    }

    public List<ProductoCompletoDTO> pedirListaProductoCompleto() {
        try {
            listaProductoCompleto = leerProducto();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductoCompleto;
    }

    public ProductoCompletoDTO obtenerProductoCompletoLista(int idProducto) {
        for (ProductoCompletoDTO productos : pedirListaProductoCompleto()) {
            if (productos.getIdProducto() == idProducto) {
                return productos;
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
        Object datosfila[] = new Object[6];//datos de fila
        ProductoCompletoDTO producto = pedirListaProductoCompleto().get(i);
        if (producto != null) {
            datosfila[0] = pedirListaProductoCompleto().get(i).getIdProducto();
            datosfila[1] = pedirListaProductoCompleto().get(i).getNombre();
            datosfila[2] = pedirListaProductoCompleto().get(i).getDescripcion();
            datosfila[3] = pedirListaProductoCompleto().get(i).getCosto();
            datosfila[4] = pedirListaProductoCompleto().get(i).getPrecio();
            datosfila[5] = pedirListaProductoCompleto().get(i).getStock();

            return datosfila;

        }
        return null;
    }

    public Object[] RequestObjectIndex(int id) {
        Object datosfila[] = new Object[6];
        ProductoCompletoDTO producto = obtenerProductoCompletoLista(id);
        if (producto != null) {
            datosfila[0] = producto.getIdProducto();
            datosfila[1] = producto.getNombre();
            datosfila[2] = producto.getDescripcion();
            datosfila[3] = producto.getCosto();
            datosfila[4] = producto.getPrecio();
            datosfila[5] = producto.getStock();

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
        } else {
            datosFila[0] = "N/A"; // Cantidad no disponible
        }
        return datosFila;
    }
//</editor-fold>

    public ProductoCompletoDTO buscarProductoPorNombre(String nombreProducto, String descripcionProducto) {
        ProductoCompletoDTO producto = (ProductoCompletoDTO) ProductoDAO.porNombreDescripcion(nombreProducto, descripcionProducto);
        return producto;
    }
}
