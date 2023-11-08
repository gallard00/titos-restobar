package DAO;

import Modelo.ItemsDTO;
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
        String sql = "insert into items(id_items, cantidad, costo_total) value (?, ?, ?, );";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(items.getId()));
            st.setString(2, String.valueOf(items.getCantidad()));
            st.setString(3, String.valueOf(items.getCostoTotal()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<ItemsDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_items, cantidad, costo_total from items;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                ItemsDTO items = new ItemsDTO(result.getInt(1), result.getInt(2), result.getFloat(3));      
                Salida.add(items);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public Boolean actualizar(Object e) {
        ItemsDTO items = (ItemsDTO) e;
        String sql = "update items set cantidad = ?, costo_total = ?, id_productos = ? where id_items = ?;";
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
        }finally {
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
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        ItemsDTO items = new ItemsDTO();
        String sql = "select id_items, cantidad, costo_total, id_productos from items WHERE id_items = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                ItemsDTO clone = new ItemsDTO(result.getInt(1), result.getInt(2), result.getFloat(3));
                items = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return null;
    }

}
