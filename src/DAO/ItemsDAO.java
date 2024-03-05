package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ItemsDTO;
import Modelo.ProductoCompletoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ItemsDAO implements IDAO {

    ControladoraConnector ConnectorController;

    public ItemsDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public Boolean crear(Object e) {
        ItemsDTO items = (ItemsDTO) e;
        String sql = "INSERT INTO items(id_items, cantidad, costo_total, id_productos, id_pedidos) value (?, ?, ?, ?, ?);"; 
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            st.setString(1, String.valueOf(items.getId()));
            st.setString(2, String.valueOf(items.getCantidad()));
            st.setString(3, String.valueOf(items.getCostoTotal()));
            st.setString(4, String.valueOf(items.getIdProducto()));
            st.setString(5, String.valueOf(items.getIdPedido()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<ItemsDTO> mostrar() {
        List listaItems = new ArrayList();
        String sql = "SELECT  prod.id_productos, prod.nombre, prod.descripcion, prod.costo, pn.stock, pr.valor AS precios, it.id_items, it.cantidad, it.costo_total, it.id_productos "
                + "FROM items AS it "
                + "INNER JOIN productos AS prod ON it.id_productos = prod.id_productos "
                + "LEFT JOIN productos_no_elaborados AS pn ON prod.id_productos = pn.id_productos "
                + "LEFT JOIN precios AS pr ON prod.id_productos = pr.id_productos "
                + "ORDER BY pr.fecha DESC";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                ProductoCompletoDTO productos = new ProductoCompletoDTO(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6));

                ItemsDTO items = new ItemsDTO(
                        result.getInt(7),
                        result.getInt(8),
                        result.getFloat(9),
                        productos);

                listaItems.add(items);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return listaItems;
    }

    @Override
    public Boolean actualizar(Object e) {
        ItemsDTO items = (ItemsDTO) e;
        String sql = "UPDATE items SET cantidad = ?, costo_total = ?, id_productos = ? WHERE id_items = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, String.valueOf(items.getCantidad()));
            st.setString(2, String.valueOf(items.getCostoTotal()));
            st.setString(3, String.valueOf(items.getProducto()));
            st.setString(4, String.valueOf(items.getId()));
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        ItemsDTO items = (ItemsDTO) e;
        String sql = "DELETE FROM items WHERE id_items = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, items.getId());
            JOptionPane.showMessageDialog(null, "Items con ID : " + items.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        } finally {
            ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        ItemsDTO items = new ItemsDTO();
        String sql = "SELECT prod.id_productos, prod.nombre, prod.descripcion, prod.costo, pn.stock, pr.valor, it.id_items, it.cantidad, it.costo_total, it.id_productos "
                + "FROM items AS it "
                + "INNER JOIN productos AS prod ON it.id_productos = prod.id_productos "
                + "LEFT JOIN productos_no_elaborados AS pn ON prod.id_productos = pn.id_productos "
                + "LEFT JOIN precios AS pr ON prod.id_productos = pr.id_productos "
                + "WHERE id_items = ? ";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                ProductoCompletoDTO productos = new ProductoCompletoDTO(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6));

                ItemsDTO clone = new ItemsDTO(
                        result.getInt(7),
                        result.getInt(8),
                        result.getFloat(9),
                        (ProductoCompletoDTO) result.getObject(10));

                items = clone;
                productos = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        } finally {
            ConnectorController.CloseConnection();
        }
        return items;
    }
   /* public List<ItemsDTO> obtenerItem() throws SQLException {
        List<ItemsDTO> item = new ArrayList<>();
        String query = ""
        try (PreparedStatement statement = ConnectorController.getConnection().prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                
            }
        }
        return item;
    }
*/
}
