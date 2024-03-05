package Controlador;

import DAO.ItemsDAO;
import Modelo.ItemsDTO;
import Modelo.ProductoCompletoDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nahue
 */
public class ItemController {

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

    public void CrearItems(int cantidad, float costoTotal, Object productos) {
        ProductoCompletoDTO producto = (ProductoCompletoDTO) productos;
        ItemsDTO crearItem = new ItemsDTO(cantidad, costoTotal, producto);
        if (ItemsDAO.crear(crearItem)) {

        }

    }

    public List LeerItems() {
        return ItemsDAO.mostrar();
    }

    public void ActualizarItems(int id, int cantidad, float costoTotal) {
        ItemsDTO actItems = new ItemsDTO(id, cantidad, costoTotal);
        ItemsDAO.actualizar(actItems);
    }

    public void BorrarItems(int id) {
        ItemsDTO borrarItems = new ItemsDTO(id);
        ItemsDAO.borrar(borrarItems);
    }
    public List leerItem() throws SQLException {
        return ItemsDAO.obtenerItem();
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