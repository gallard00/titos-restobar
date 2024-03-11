package Controlador;

import DAO.ItemsDAO;
import Modelo.ItemsDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la gestión de Items. Permite crear, leer, actualizar y
 * borrar items, así como obtener información relacionada con los pedidos
 * activos. Esta clase sigue un patrón Singleton para garantizar una única
 * instancia en la aplicación.
 */
public class ItemController {

    private List<ItemsDTO> ListaItems = new ArrayList<>();
    private final ItemsDAO ItemsDAO;
    private static ItemController Instance;

    /**
     * Constructor privado para evitar instanciación directa.
     *
     * @throws SQLException Si hay un error al conectarse a la base de datos.
     */
    private ItemController() throws SQLException {

        ItemsDAO = new ItemsDAO();
    }

    /**
     * Método estático para obtener la única instancia de ItemController.
     *
     * @return La instancia única de ItemController.
     * @throws SQLException Si hay un error al conectarse a la base de datos.
     */
    public static ItemController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new ItemController();
        }
        return Instance;
    }

    /**
     * Coordinar la creación de un nuevo ítem con los datos proporcionados.
     *
     * @param cantidad La cantidad del producto que tiene ítems.
     * @param costoTotal El costo total del ítem.
     * @param idProducto El ID del producto asociado al ítem.
     * @param idPedidoActivo El ID del pedido activo al que se asociará el ítem.
     * @return true si se pudo crear el ítem correctamente, false en caso
     * contrario.
     */
    public Boolean CrearItems(int cantidad, float costoTotal, int idProducto, int idPedidoActivo) {
        ItemsDTO crearItem = new ItemsDTO(cantidad, costoTotal, idProducto, idPedidoActivo);
        return ItemsDAO.crear(crearItem);

    }

    /**
     * Obtiene la lista de ítems consultando la información en la base de datos.
     *
     * @return La lista de ítems.
     */
    public List<ItemsDTO> PedirListaItems() {
        ListaItems = LeerItems();
        return ListaItems;
    }

    /**
     * Lee los ítems desde la base de datos y los almacena en la lista interna.
     *
     * @return La lista de ítems leída desde la base de datos.
     */
    public List LeerItems() {
        return ItemsDAO.mostrar();
    }

    /**
     * Coordina la actualización de un ítem con los nuevos datos proporcionados.
     *
     * @param id El ID del ítem donde se actualizará.
     * @param cantidad La nueva cantidad del ítem.
     * @param costoTotal El nuevo costo total del ítem.
     */
    public void ActualizarItems(int id, int cantidad, float costoTotal) {
        ItemsDTO actItems = new ItemsDTO(id, cantidad, costoTotal);
        ItemsDAO.actualizar(actItems);
    }

    /**
     * Conduce la eliminación de un ítem con el ID especificado.
     *
     * @param idItems El ID del ítem a eliminar.
     */
    public void BorrarItems(int idItems) {
        ItemsDTO borrarItems = new ItemsDTO(idItems);
        ItemsDAO.borrar(borrarItems);

    }

    /**
     * Obtiene la lista de ítems asociados a un pedido activo consultando la información en la base de datos.
     *
     * @param pedidoActivo El ID del pedido activo.
     * @return La lista de ítems asociados al pedido activo.
     */
    public List obtenerItemsPedidoActivo(int pedidoActivo) {

        return ItemsDAO.obtenerItemsPedidoActivo(pedidoActivo);
    }

    /**
     * Gestiona la eliminación de todos los ítems asociados a un pedido con el ID especificado consultando la información en la base de datos.
     *
     * @param idPedido El ID del pedido del que se eliminarán los ítems.
     */
    public void BorrarItemsPorPedido(int idPedido) {
        ItemsDAO.borrarItemsPorPedido(idPedido);
    }

    /**
     * Obtiene el total del pedido activo con el ID especificado consultando la información en la base de datos.
     *
     * @param idPedido El ID del pedido activo.
     * @return El total del pedido activo.
     */
    public float calcularTotalPedidoActivo(int idPedido) {
        return ItemsDAO.calcularTotalPedidoActivo(idPedido);
    }

}
