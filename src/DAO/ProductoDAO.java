package DAO;

import Modelo.ItemsDTO;
import Modelo.PrecioDTO;
import Modelo.ProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ProductoDAO implements IDAO{
    
    ControladoraConnector ConnectorController;
    
    public ProductoDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public int crear(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        int id = 0;
        String sql = "insert into ProductoDTO(id_productos, nombre, descripcion, costo, id_precios) value (?, ?, ?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(prod.getId()));
            st.setString(2, prod.getNombre());
            st.setString(3, prod.getDescripcion());
            st.setString(4, String.valueOf(prod.getCosto()));
            st.setString(5, String.valueOf(prod.getPrecio()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
            id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return id;
    }

    @Override
    public List<ProductoDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_producto, nombre ,descripcion, costo, PrecioDTO;";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                ProductoDTO prod = new ProductoDTO(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), (PrecioDTO) result.getObject(5));      
                Salida.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public void actualizar(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        String sql = "update Productos set nombre = ?, descripcion = ?, costo = ?, id_precios = ? where id_productos = ?;";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, prod.getNombre());
            st.setString(2, prod.getDescripcion());
            st.setString(3, String.valueOf(prod.getCosto()));
            st.setString(4, String.valueOf(prod.getPrecio()));
            st.setString(5, String.valueOf(prod.getId()));
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public void borrar(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        String sql = "DELETE FROM PRoductos WHERE id_productos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, prod.getId());
            JOptionPane.showMessageDialog(null, "ID : " + prod.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        }finally {
             ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        ProductoDTO prod = new ProductoDTO();
        String sql = "select id_productos, nombre, descripcion, costo, id_precios from Productos WHERE id_productos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                ProductoDTO clone = new ProductoDTO(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), (PrecioDTO) result.getObject(5));
                prod = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        }finally {
             ConnectorController.CloseConnection();
        }
        return prod;
    }
    
    
    
    
    
    

}
