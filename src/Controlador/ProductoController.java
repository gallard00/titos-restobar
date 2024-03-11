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

/**
 * La clase ProductoController se encarga de controlar las operaciones
 * relacionadas con los productos en el sistema.
 */
public class ProductoController {

    private List<ProductoDTO> ListaProducto = new ArrayList<>();
    private List<ProductoNoElaboradoDTO> listaProductoNoElaborado = new ArrayList<>();
    private List<ProductoCompletoDTO> listaProductoCompleto = new ArrayList<>();
    private static ProductoController Instance;
    private final ProductoDAO ProductoDAO;
    private final ProductoNoElaboradoDAO productoNoElaboradoDAO;

    /**
     * Constructor privado que inicializa los objetos ProductoDAO y
     * ProductoNoElaboradoDAO.
     *
     * @throws SQLException si ocurre un error de base de datos.
     */
    private ProductoController() throws SQLException {
        ProductoDAO = new ProductoDAO();
        productoNoElaboradoDAO = new ProductoNoElaboradoDAO();
    }

    /**
     * Método estático para obtener una instancia única de ProductoController.
     *
     * @return la instancia única de ProductoController.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public static ProductoController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new ProductoController();
        }
        return Instance;
    }

    /**
     * Crea un nuevo producto elaborado con los datos especificados.
     *
     * @param nombre el nombre del producto.
     * @param descripcion la descripción del producto.
     * @param costo el costo del producto.
     * @return true si se creó el producto con éxito, false de lo contrario.
     */
    public Boolean CrearProducto(String nombre, String descripcion, float costo) {
        ProductoDTO prod = new ProductoDTO(nombre, descripcion, costo);
        return ProductoDAO.crear(prod);
    }

    /**
     * Retorna una lista de todos los productos elaborados en el sistema.
     *
     * @return una lista de objetos ProductoDTO.
     */
    public List LeerProducto() {
        return ProductoDAO.mostrar();
    }

    /**
     * Actualiza los datos de un producto elaborado existente.
     *
     * @param idProducto el ID del producto a actualizar.
     * @param nombre el nuevo nombre del producto.
     * @param descripcion la nueva descripción del producto.
     * @param costo el nuevo costo del producto.
     * @return true si se actualizó el producto con éxito, false de lo
     * contrario.
     */
    public Boolean ActualizarProducto(int idProducto, String nombre, String descripcion, float costo) {
        ProductoDTO actualizarProducto = new ProductoDTO(idProducto, nombre, descripcion, costo);
        return ProductoDAO.actualizar(actualizarProducto);
    }

    /**
     * Borra un producto elaborado del sistema.
     *
     * @param idProducto el ID del producto a borrar.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public void BorrarProducto(int idProducto) throws SQLException {

        ProductoCompletoDTO productoCompleto = obtenerProductoCompletoLista(idProducto);

        if (productoCompleto != null) {
            // Borrar el producto
            ProductoDTO producto = new ProductoDTO(productoCompleto.getIdProducto(), productoCompleto.getNombre(), productoCompleto.getDescripcion(), productoCompleto.getCosto());
            ProductoDAO.borrar(producto);

            listaProductoCompleto.remove(productoCompleto);

            PrecioController.GetInstance().BorrarPrecio(idProducto);
        } else {

            System.out.println("El producto con ID " + idProducto + " no se encontró.");
        }

    }

    /**
     * Crea un nuevo producto no elaborado con los datos especificados.
     *
     * @param idProducto el ID del producto no elaborado.
     * @param stock la cantidad en stock del producto no elaborado.
     * @return true si se creó el producto no elaborado con éxito, false de lo
     * contrario.
     */

    public Boolean crearProductoNoElaborado(int idProducto, int stock) {
        return productoNoElaboradoDAO.crear(new ProductoNoElaboradoDTO(idProducto, stock));
    }

    /**
     * Retorna una lista de todos los productos no elaborados en el sistema.
     *
     * @return una lista de objetos ProductoNoElaboradoDTO.
     */
    public List<ProductoNoElaboradoDTO> leerProductoNoElaborado() {
        return productoNoElaboradoDAO.mostrarProductosNoElaborados();
    }

    /**
     * Actualiza los datos de un producto no elaborado existente.
     *
     * @param idProducto el ID del producto no elaborado a actualizar.
     * @param stock la nueva cantidad en stock del producto no elaborado.
     * @return true si se actualizó el producto no elaborado con éxito, false de
     * lo contrario.
     */
    public Boolean actualizarProductoNoElaborado(int idProducto, int stock) {
        ProductoNoElaboradoDTO actualizarProducto = new ProductoNoElaboradoDTO(idProducto, stock);
        return productoNoElaboradoDAO.actualizarProductoNoElaborado(actualizarProducto);
    }

    /**
     * Borra un producto no elaborado del sistema.
     *
     * @param idProducto el ID del producto no elaborado a borrar.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public void borrarProductoNoElaborado(int idProducto) throws SQLException {
        ProductoCompletoDTO productoCompleto = obtenerProductoCompletoLista(idProducto);

        if (productoCompleto != null) {

            ProductoNoElaboradoDTO producto = new ProductoNoElaboradoDTO(productoCompleto.getIdProducto(), productoCompleto.getStock());

            productoNoElaboradoDAO.borrarProductoNoElaborado(producto);

            listaProductoCompleto.remove(productoCompleto);

            BorrarProducto(idProducto);
        } else {

            System.out.println("El producto con ID " + idProducto + " no se encontró.");
        }

    }

    /**
     * Retorna una lista de todos los productos no elaborados en el sistema.
     *
     * @return una lista de objetos ProductoNoElaboradoDTO.
     */
    public List<ProductoNoElaboradoDTO> pedirListaProductoNoElaborado() {
        listaProductoNoElaborado = leerProductoNoElaborado();
        return listaProductoNoElaborado;
    }

    /**
     * Obtiene el producto no elaborado con el ID especificado de la lista de
     * productos no elaborados.
     *
     * @param idProducto el ID del producto no elaborado a buscar.
     * @return el objeto ProductoNoElaboradoDTO correspondiente al ID
     * especificado, o null si no se encuentra.
     */
    public ProductoNoElaboradoDTO obtenerProductoNoElaboradoLista(int idProducto) {
        for (ProductoNoElaboradoDTO productoNoElaborado : pedirListaProductoNoElaborado()) {
            if (productoNoElaborado.getIdProducto() == idProducto) {
                return productoNoElaborado;
            }
        }
        return null;
    }

    /**
     * Retorna una lista de todos los productos completos en el sistema.
     *
     * @return una lista de objetos ProductoCompletoDTO.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public List leerProducto() throws SQLException {
        return ProductoDAO.obtenerProductosCompletos();
    }

    /**
     * Retorna una lista de todos los productos completos en el sistema.
     *
     * @return una lista de objetos ProductoCompletoDTO.
     */
    public List<ProductoCompletoDTO> pedirListaProductoCompleto() {
        try {
            listaProductoCompleto = leerProducto();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductoCompleto;
    }

    /**
     * Obtiene el producto completo con el ID especificado de la lista de
     * productos completos.
     *
     * @param idProducto el ID del producto completo a buscar.
     * @return el objeto ProductoCompletoDTO correspondiente al ID especificado,
     * o null si no se encuentra.
     */
    public ProductoCompletoDTO obtenerProductoCompletoLista(int idProducto) {
        for (ProductoCompletoDTO productos : pedirListaProductoCompleto()) {
            if (productos.getIdProducto() == idProducto) {
                return productos;
            }
        }
        return null;
    }

    /**
     * Busca un producto por su nombre y descripción en la base de datos.
     *
     * @param nombreProducto el nombre del producto a buscar.
     * @param descripcionProducto la descripción del producto a buscar.
     * @return el objeto ProductoCompletoDTO correspondiente a la búsqueda, o
     * null si no se encuentra.
     */
    public ProductoCompletoDTO buscarProductoPorNombre(String nombreProducto, String descripcionProducto) {
        ProductoCompletoDTO producto = (ProductoCompletoDTO) ProductoDAO.porNombreDescripcion(nombreProducto, descripcionProducto);
        return producto;
    }

    /**
     * Retorna una lista de productos asociados a un pedido activo.
     *
     * @param pedidoActivo el ID del pedido activo.
     * @return una lista de objetos ProductoDTO asociados al pedido activo.
     */
    public List obtenerProductosPedidoActivo(int pedidoActivo) {

        return ProductoDAO.obtenerProductosPedidoActivo(pedidoActivo);
    }

    /**
     * Retorna una lista de todos los productos en el sistema.
     *
     * @return una lista de objetos ProductoDTO.
     */
    public List<ProductoDTO> PedirListaProducto() {
        ListaProducto = LeerProducto();
        return ListaProducto;
    }

    /**
     * Obtiene el producto con el ID especificado de la lista de productos.
     *
     * @param idProducto el ID del producto a buscar.
     * @return el objeto ProductoDTO correspondiente al ID especificado, o null
     * si no se encuentra.
     */
    public ProductoDTO obtenerProductoLista(int idProducto) {
        for (ProductoDTO producto : PedirListaProducto()) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Verifica si un producto con el nombre, descripción y costo especificados
     * ya existe en el sistema.
     *
     * @param nombre el nombre del producto.
     * @param descripcion la descripción del producto.
     * @param costo el costo del producto.
     * @return true si el producto existe, false de lo contrario.
     */
    public Boolean SiProductoExiste(String nombre, String descripcion, Float costo) {
        ProductoDTO producto = (ProductoDTO) ProductoDAO.porNombre(nombre, descripcion, costo);
        if (producto != null) {
            return true;
        }
        return false;
    }

    /**
     * Obtiene el último ID de producto utilizado en el sistema.
     *
     * @return el último ID de producto utilizado.
     */
    public int obtenerUltimoIDProducto() {
        return ProductoDAO.obtenerUltimoIDProducto();
    }

    /**
     * Retorna los datos de una fila de la tabla de productos en la posición
     * especificada.
     *
     * @param i la posición de la fila en la tabla de productos.
     * @return un array de objetos con los datos de la fila, o null si la
     * posición es inválida.
     */
    public Object[] RequestTableRow(int i) {
        Object datosfila[] = new Object[6];
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

    /**
     * Retorna los datos de un producto en base a su ID.
     *
     * @param id el ID del producto.
     * @return un array de objetos con los datos del producto, o null si no se
     * encuentra el producto.
     */
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

}
