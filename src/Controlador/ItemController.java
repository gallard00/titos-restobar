package Controlador;

import DAO.ItemsDAO;
import Modelo.ItemsDTO;
import Modelo.ProductoCompletoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nahue
 */
public class ItemController {

    private List<ItemsDTO> ListaItems = new ArrayList<>();
    private final ItemsDAO ItemsDAO;
    private static ItemController Instance;

    ItemController() throws SQLException {

        ItemsDAO = new ItemsDAO();
    }

    public static ItemController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new ItemController();
        }
        return Instance;
    }

    public Boolean CrearItems(int cantidad, float costoTotal, int idProducto, int idPedidoActivo) {
        ItemsDTO crearItem = new ItemsDTO(cantidad, costoTotal, idProducto, idPedidoActivo);
        return ItemsDAO.crear(crearItem);

    }

    public List<ItemsDTO> PedirListaItems() {
        ListaItems = LeerItems();
        return ListaItems;
    }

    public List LeerItems() {
        return ItemsDAO.mostrar();
    }

    public void ActualizarItems(int id, int cantidad, float costoTotal) {
        ItemsDTO actItems = new ItemsDTO(id, cantidad, costoTotal);
        ItemsDAO.actualizar(actItems);
    }

    public void BorrarItems(int idItems) {
        ItemsDTO borrarItems = new ItemsDTO(idItems);
        ItemsDAO.borrar(borrarItems);

    }

    public List obtenerItemsPedidoActivo(int pedidoActivo) {

        return ItemsDAO.obtenerItemsPedidoActivo(pedidoActivo);
    }

    public void BorrarItemsPorPedido(int idPedido) {
        ItemsDAO.borrarItemsPorPedido(idPedido);
    }
    
    public float calcularTotalPedidoActivo(int idPedido){
        return ItemsDAO.calcularTotalPedidoActivo(idPedido);
    }
    /*public List<ItemsDTO> pedirListaItem() {
        try {
            listaItem = leerItem();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaItem;
    }
    public Object[] RequestTableRow(int i)//solocitar fila de la tabla
    {
        Object datosfila[] = new Object[6];//datos de fila
        ItemsDTO item = pedirListaItem().get(i);
        if (item != null) {
            datosfila[0] = pedirListaItem().get(i).getIdProducto();
            datosfila[1] = pedirListaItem().get(i).getNombre();
            datosfila[2] = pedirListaItem().get(i).getDescripcion();
            datosfila[3] = pedirListaItem().get(i).getPrecio();
            return datosfila;

        }
        return null;
    }

    public Object[] RequestObjectIndex(int id) {
        Object datosfila[] = new Object[6];
        ItemsDTO item = obtenerItemLista(id);
        if (item != null) {
            datosfila[0] = item.getIdProducto();
            datosfila[1] = item.getNombre();
            datosfila[2] = item.getDescripcion();
            datosfila[3] = item.getPrecio();

        }
        return datosfila;
    }*/
}
