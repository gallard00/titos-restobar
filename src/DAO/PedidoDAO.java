
package DAO;

import Modelo.ItemsDTO;
import Modelo.MesaDTO;
import Modelo.PedidoDTO;
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
    public int crear(Object e) {
        PedidoDTO ped = (PedidoDTO) e;
        int id = 0;
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
            id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return id;
    }

    @Override
    public List<PedidoDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_pedidos, fecha_apertura, fecha_cierre, descuento, costo_total, id_items;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                PedidoDTO ped = new PedidoDTO(result.getInt(1), result.getDate(2), result.getDate(3), result.getFloat(4), result.getFloat(5), (List<ItemsDTO>) result.getObject(6));      
                Salida.add(ped);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public void actualizar(Object e) {
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
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
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
        String sql = "select id_pedidos, fecha_apertura, fecha_cierre, descuento, costo_total, id_items from Pedidos WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                PedidoDTO clone = new PedidoDTO(result.getInt(1), result.getDate(2), result.getDate(3), result.getFloat(4), result.getFloat(5), (List<ItemsDTO>) result.getObject(6));
                ped = clone;
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
