package Controlador;

import DAO.PrecioDAO;
import Modelo.PrecioDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.Date;

/**
 * La clase PrecioController se encarga de controlar las operaciones
 * relacionadas con los precios de los productos en el sistema.
 */
public class PrecioController {

    private List<PrecioDTO> listaPrecio = new ArrayList<>();
    private static PrecioController Instance;
    private final PrecioDAO PrecioDAO;

    /**
     * Constructor privado que inicializa el objeto PrecioDAO.
     *
     * @throws SQLException si ocurre un error de base de datos.
     */
    private PrecioController() throws SQLException {
        PrecioDAO = new PrecioDAO();

    }

    /**
     * Método estático para obtener una instancia única de PrecioController.
     *
     * @return la instancia única de PrecioController.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public static PrecioController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new PrecioController();
        }
        return Instance;
    }

    /**
     * Crea un nuevo precio para un producto con los datos especificados.
     *
     * @param valor el valor del precio.
     * @param fecha la fecha del precio.
     * @param idProducto el ID del producto asociado al precio.
     * @return true si se creó el precio con éxito, false de lo contrario.
     */
    public Boolean CrearPrecio(float valor, Date fecha, int idProducto) {
        PrecioDTO precio = new PrecioDTO(valor, fecha, idProducto);
        return PrecioDAO.crear(precio);
    }

    /**
     * Retorna una lista de todos los precios en el sistema.
     *
     * @return una lista de objetos PrecioDTO.
     */
    public List LeerPrecio() {
        return PrecioDAO.mostrar();
    }

    /**
     * Actualiza el precio con el ID especificado.
     *
     * @param id el ID del precio a actualizar.
     * @param valor el nuevo valor del precio.
     * @param fecha la nueva fecha del precio.
     * @return true si se actualizó el precio con éxito, false de lo contrario.
     */
    public Boolean ActualizarPrecio(int id, float valor, Date fecha) {
        PrecioDTO actualizarPrecio = new PrecioDTO(id, valor, fecha);
        return PrecioDAO.actualizar(actualizarPrecio);
    }

    /**
     * Borra el precio asociado al producto con el ID especificado.
     *
     * @param idProducto el ID del producto asociado al precio a borrar.
     */
    public void BorrarPrecio(int idProducto) {
        PrecioDTO borrarPrecio = new PrecioDTO(idProducto);
        PrecioDAO.borrar(borrarPrecio);
        listaPrecio.remove(borrarPrecio);
    }

    /**
     * Retorna una lista de todos los precios en el sistema.
     *
     * @return una lista de objetos PrecioDTO.
     */
    public List<PrecioDTO> pedirListaPrecio() {
        listaPrecio = LeerPrecio();
        return listaPrecio;
    }

    /**
     * Obtiene el precio con el ID especificado de la lista de precios.
     *
     * @param id el ID del precio a buscar.
     * @return el objeto PrecioDTO correspondiente al ID especificado, o null si
     * no se encuentra.
     */
    public PrecioDTO obtenerPrecioLista(int id) {
        for (PrecioDTO precio : pedirListaPrecio()) {
            if (precio.getId() == id) {
                return precio;
            }
        }
        return null;
    }

    /**
     * Crea o actualiza el precio de un producto.
     *
     * @param idProducto el ID del producto.
     * @param costo el costo base del producto.
     * @param porcentajeAumento el porcentaje de aumento para calcular el nuevo
     * precio.
     */
    public void crearActualizarPrecio(int idProducto, float costo, float porcentajeAumento) {

        float nuevoPrecio = calcularPrecio(costo, porcentajeAumento);
        Date fechaActual = new Date();
        PrecioDAO.crear(new PrecioDTO(nuevoPrecio, fechaActual, idProducto));
    }

    /**
     * Calcula el nuevo precio aplicando un porcentaje de aumento al costo base
     * del producto.
     *
     * @param costo el costo base del producto.
     * @param porcentajeAumento el porcentaje de aumento.
     * @return el nuevo precio calculado.
     */
    private float calcularPrecio(float costo, float porcentajeAumento) {
        return costo + (costo * (porcentajeAumento / 100));
    }

    /**
     * Retorna los datos de una fila de la tabla de precios en la posición
     * especificada.
     *
     * @param i la posición de la fila en la tabla de precios.
     * @return un array de objetos con los datos de la fila, o null si la
     * posición es inválida.
     */
    public Object[] filaTablaPrecio(int i) {
        Object datoFila[] = new Object[1];
        PrecioDTO precio = pedirListaPrecio().get(i);
        if (precio != null) {
            datoFila[0] = pedirListaPrecio().get(i).getValor();
            return datoFila;
        }
        return null;
    }

    /**
     * Retorna los datos de un precio en base a su ID.
     *
     * @param id el ID del precio.
     * @return un array de objetos con los datos del precio, o null si no se
     * encuentra el precio.
     */
    public Object[] indicePrecio(int id) {
        Object datoFila[] = new Object[1];
        PrecioDTO precio = obtenerPrecioLista(id);
        if (precio != null) {
            datoFila[0] = precio.getValor();
        }
        return datoFila;
    }

}
