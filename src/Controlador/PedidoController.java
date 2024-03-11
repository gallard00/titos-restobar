package Controlador;

import DAO.PedidoDAO;
import Modelo.PedidoDTO;
import Modelo.PedidoDTO.EstadoPedido;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * La clase PedidoController se encarga de controlar las operaciones
 * relacionadas con los pedidos en el sistema.
 */
public class PedidoController {

    private final List<PedidoDTO> ListaPedido = new ArrayList<>();
    private static PedidoController Instance;
    private final PedidoDAO PedidoDAO;

    /**
     * Constructor privado que inicializa el objeto PedidoDAO.
     *
     * @throws SQLException si ocurre un error de base de datos.
     */
    PedidoController() throws SQLException {
        PedidoDAO = new PedidoDAO();
    }

    /**
     * Método estático para obtener una instancia única de PedidoController.
     *
     * @return la instancia única de PedidoController.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public static PedidoController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new PedidoController();
        }
        return Instance;
    }

    /**
     * Crea un nuevo pedido con los datos especificados.
     *
     * @param fechaApertura la fecha de apertura del pedido.
     * @param fechaCierre la fecha de cierre del pedido.
     * @param descuento el descuento aplicado al pedido.
     * @param costoTotal el costo total del pedido.
     * @param estadoPedido el estado del pedido.
     * @param idMesa el ID de la mesa asociada al pedido.
     */
    public void crearPedido(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, EstadoPedido estadoPedido, int idMesa) {
        PedidoDTO pedido = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, estadoPedido, idMesa);
        PedidoDAO.crear(pedido);
    }

    /**
     * Retorna una lista de todos los pedidos en el sistema.
     *
     * @return una lista de objetos PedidoDTO.
     */
    public List ListaPedido() {
        return PedidoDAO.mostrar();
    }

    /**
     * Actualiza los datos de un pedido existente.
     *
     * @param idPedido el ID del pedido a actualizar.
     * @param fechaCierre la nueva fecha de cierre del pedido.
     * @param descuento el nuevo descuento aplicado al pedido.
     * @param costoTotal el nuevo costo total del pedido.
     * @param estadoPedido el nuevo estado del pedido.
     */
    public void actualizarPedido(int idPedido, Date fechaCierre, float descuento, float costoTotal, EstadoPedido estadoPedido) {
        PedidoDTO pedidoCerrado = new PedidoDTO(idPedido, fechaCierre, descuento, costoTotal, estadoPedido);
        PedidoDAO.actualizar(pedidoCerrado);
    }

    /**
     * Borra un pedido del sistema.
     *
     * @param id el ID del pedido a borrar.
     */
    public void borrarPedido(int id) {
        PedidoDTO pedido = new PedidoDTO(id);
        PedidoDAO.borrar(pedido);
        ListaPedido.remove(pedido);
    }

    /**
     * Verifica si existe un pedido activo para la mesa especificada.
     *
     * @param idMesa el ID de la mesa.
     * @return true si existe un pedido activo para la mesa, false de lo
     * contrario.
     */
    public boolean existePedidoActivo(int idMesa) {
        List<PedidoDTO> pedidos = PedidoDAO.mostrar();
        for (PedidoDTO pedido : pedidos) {
            if (pedido.getIdMesa() == idMesa && pedido.getEstadoPedido() == EstadoPedido.ACTIVO) {
                return true;
            }
        }
        return false;

    }

    /**
     * Obtiene el ID de un pedido activo para la mesa especificada.
     *
     * @param idMesa el ID de la mesa.
     * @return el ID del pedido activo, o -1 si no se encuentra.
     */
    public int obtenerIdPedidoActivo(int idMesa) {

        List<PedidoDTO> pedidos = PedidoDAO.mostrar();
        for (PedidoDTO pedido : pedidos) {
            if (pedido.getIdMesa() == idMesa && pedido.getEstadoPedido() == EstadoPedido.ACTIVO) {
                return pedido.getId();
            }
        }
        return -1;
    }

    /**
     * Obtiene una lista de pedidos cerrados para la mesa especificada.
     *
     * @param idMesa el ID de la mesa.
     * @return una lista de objetos PedidoDTO representando pedidos cerrados.
     */
    public List obtenerPedidosCerrados(int idMesa) {
        return PedidoDAO.mostrarPedidosCerrados(idMesa);
    }

    /**
     * Obtiene un pedido cerrado en base a su ID.
     *
     * @param idPedido el ID del pedido.
     * @return el objeto PedidoDTO correspondiente al ID especificado, o null si
     * no se encuentra.
     */
    public PedidoDTO obtenerUnPedidoCerrado(int idPedido) {

        return (PedidoDTO) PedidoDAO.porId(idPedido);
    }
}
