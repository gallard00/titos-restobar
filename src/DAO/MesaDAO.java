package DAO;

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


public class MesaDAO implements IDAO {
    
    ControladoraConnector ConnectorController;

    public MesaDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public int crear(Entidad e) {
        MesaDTO mesa = (MesaDTO) e;
        int id = 0;
        String sql = "insert into MesaDTO(id_mesas, nombre, id_pedidos) value (?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(mesa.getID()));
            st.setString(2, mesa.getNombre());
            st.setString(5, String.valueOf(mesa.getPedido()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            id = rs.getInt(1);
            e.setID(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return id;
    }

    @Override
    public List<MesaDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_mesas, nombre, id_pedidos;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                MesaDTO mesa = new MesaDTO(result.getInt(1), result.getString(2), (List<PedidoDTO>) result.getObject(3));      
                Salida.add(mesa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public void actualizar(Entidad e) {
        MesaDTO mesa = (MesaDTO) e;
        String sql = "update Mesas set nombre = ?, id_pedidos = ? where id_mesas = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, mesa.getNombre());
            st.setString(4, String.valueOf(mesa.getPedido()));
            st.setString(5, String.valueOf(mesa.getID()));
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public void borrar(Entidad e) {
        MesaDTO mesa = (MesaDTO) e;
        String sql = "DELETE FROM Mesas WHERE id_mesas = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, mesa.getID());
            JOptionPane.showMessageDialog(null, "ID : " + mesa.getID());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Entidad porId(int id) {
        MesaDTO mesa = new MesaDTO();
        String sql = "select id_mesas, nombre, id_pedidos from Mesas WHERE id_mesas = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                MesaDTO clone = new MesaDTO(result.getInt(1), result.getString(2), (List<PedidoDTO>) result.getObject(3));
                mesa = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return mesa;
    }

}
