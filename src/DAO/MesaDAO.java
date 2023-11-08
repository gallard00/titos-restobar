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
    public Boolean crear(Object e) {
        MesaDTO mesa = (MesaDTO) e;
        String sql = "insert into mesas (id_mesas, nombre) value (?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(mesa.getId()));
            st.setString(2, mesa.getNombre());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<MesaDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_mesas, nombre from mesas;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                MesaDTO mesa = new MesaDTO(result.getInt(1), result.getString(2));      
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
    public Boolean actualizar(Object e) {
        MesaDTO mesa = (MesaDTO) e;
        String sql = "update mesas set nombre = ? where id_mesas = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, mesa.getNombre());
            st.setString(2, String.valueOf(mesa.getId()));
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        MesaDTO mesa = (MesaDTO) e;
        String sql = "DELETE FROM mesas WHERE id_mesas = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, mesa.getId());
            JOptionPane.showMessageDialog(null, "Mesa con ID : " + mesa.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        MesaDTO mesa = new MesaDTO();
        String sql = "select id_mesas, nombre from mesas WHERE id_mesas = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                MesaDTO clone = new MesaDTO(result.getInt(1), result.getString(2));
                mesa = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return null;
    }
    
    public Object porNombre(String nombre) {
        MesaDTO mesa = new MesaDTO();
        String sql = "select id_mesas, nombre from mesas WHERE nombre = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, nombre);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                mesa.setId(result.getInt(1));
                mesa.setNombre(result.getString(2));
                return mesa;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return null;
    }

}
