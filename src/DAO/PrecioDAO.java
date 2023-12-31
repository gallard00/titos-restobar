package DAO;


import ControladoraConnector.ControladoraConnector;
import Modelo.PrecioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PrecioDAO implements IDAO {
        ControladoraConnector ConnectorController;
    
    public PrecioDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public Boolean crear(Object e) {
        PrecioDTO pre = (PrecioDTO) e;
        String sql = "insert into precios(id_precios, valor,fecha) value (?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(pre.getId()));
            st.setString(2, String.valueOf(pre.getValor()));
            st.setString(3, String.valueOf(pre.getFecha()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<PrecioDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_precios, valor, fecha;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                PrecioDTO pre = new PrecioDTO(result.getInt(1), result.getFloat(2), result.getDate(3));      
                Salida.add(pre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public Boolean actualizar(Object e) {
        PrecioDTO pre = (PrecioDTO) e;
        String sql = "update Precios set valor = ?, fecha = ?,where id_precio = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, String.valueOf(pre.getValor()));
            st.setString(2, String.valueOf(pre.getFecha()));
            st.setString(3, String.valueOf(pre.getId()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        PrecioDTO pre = (PrecioDTO) e;
        String sql = "DELETE FROM Precios WHERE id_precios = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, pre.getId());
            JOptionPane.showMessageDialog(null, "ID : " + pre.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        PrecioDTO pre = new PrecioDTO();
        String sql = "select id_precio, valor, fecha from Precios WHERE id_precio = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                PrecioDTO clone = new PrecioDTO(result.getInt(1), result.getFloat(2), result.getDate(3));
                pre = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return pre;
    }
    
    public Object PrecioActual() {
        PrecioDTO preact = new PrecioDTO();
        String sql = "select id_precios,valor,fecha, costo from Precios WHERE id_precios = ?";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery();
            while (result.next()) {
                PrecioDTO historial = new PrecioDTO(result.getInt(1), 
                        result.getFloat(2), 
                        result.getDate(3));
                      
                preact = historial;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             ConnectorController.CloseConnection();
        }
        return preact;
    }

    public Object VerHistorialPrecio() {
       PrecioDTO ultimo = new PrecioDTO();
        String sql = "select id_precios,valor,fecha, costo from Precios WHERE id_precios = ?";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery();
            while (result.next()) {
                PrecioDTO historial = new PrecioDTO(result.getInt(1), 
                        result.getFloat(2), 
                        result.getDate(3));
                      
                ultimo = historial;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             ConnectorController.CloseConnection();
        }
        return ultimo;
    }
    
    public int crearPrecio(Object e) {
        PrecioDTO prec = (PrecioDTO) e;
        int id = 0;
        String sql = "insert into PrecioDTO(id_precios,valor,fecha, costo) value (?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(prec.getId()));
            st.setString(2, String.valueOf(prec.getValor()));
            st.setString(3, String.valueOf(prec.getFecha()));
        
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return id;
    }
}
