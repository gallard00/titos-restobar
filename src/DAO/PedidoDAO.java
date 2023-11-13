
package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.ProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PedidoDAO implements IDAO {
    
    ControladoraConnector ConnectorController;
    
    public PedidoDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public Boolean crear(Object e) {
        PedidoDTO ped = (PedidoDTO) e;
        String sql = "insert into Pedidos(id_pedidos, fecha_apertura, fecha_cierre, descuento, costo_total, id_items) value (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(ped.getId()));
            st.setString(2, String.valueOf(ped.getFechaApertura()));
            st.setString(3, String.valueOf(ped.getFechaCierre()));
            st.setString(2, String.valueOf(ped.getDescuento()));
            st.setString(2, String.valueOf(ped.getCostoTotal()));
            st.setString(4, String.valueOf(ped.getProducto()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<PedidoDTO> mostrar() {
        List listaPedido = new ArrayList();
        String sql = "select it.id_items, it.cantidad, it.costo_total, it.id_productos, ped.id_pedidos, ped.fecha_apertura, ped.fecha_cierre, ped.descuento, ped.costo_total, ped.id_items FROM pedidos as ped INNER JOIN items as it on it.id_items = ped.id_items;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                ItemsDTO it = new ItemsDTO(result.getInt(1), result.getInt(2), result.getFloat(3), (ProductoDTO) result.getObject(4));
                PedidoDTO ped = new PedidoDTO(result.getInt(5), result.getDate(6), result.getDate(7), result.getFloat(8), result.getFloat(9), (List<ItemsDTO>) result.getObject(10));      
                listaPedido.add(ped);
                it = null;
                ped = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return listaPedido;
    }

    @Override
    public Boolean actualizar(Object e) {
        PedidoDTO ped = (PedidoDTO) e;
        String sql = "update Pedidos set fecha_apertura = ?, fecha_cierre = ?, descuento = ?, costo_total = ?, id_items = ? where id_pedidos = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, String.valueOf(ped.getFechaApertura()));
            st.setString(2, String.valueOf(ped.getFechaCierre()));
            st.setString(3, String.valueOf(ped.getDescuento()));
            st.setString(4, String.valueOf(ped.getCostoTotal()));
            st.setString(5, String.valueOf(ped.getProducto()));
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        PedidoDTO ped = (PedidoDTO) e;
        String sql = "DELETE FROM Pedidos WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, ped.getId());
            JOptionPane.showMessageDialog(null, "ID : " + ped.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        PedidoDTO ped = new PedidoDTO();
        String sql = "select it.id_items, it.cantidad, it.costo_total, it.id_pedidos, ped.id_pedidos, ped.fecha_apertura, ped.fecha_cierre, ped.descuento, ped.costo_total, ped.id_items from pedidos as ped INNER JOIN items as it ON ped.id_items = it.id_items WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                ItemsDTO it = new ItemsDTO(result.getInt(1), result.getInt(2), result.getFloat(3), (ProductoDTO) result.getObject(4));
                PedidoDTO clone = new PedidoDTO(result.getInt(5), result.getDate(6), result.getDate(7), result.getFloat(8), result.getFloat(9), (List<ItemsDTO>) result.getObject(10));
                ped = clone;
                it = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return ped;
    }

}
