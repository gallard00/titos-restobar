package DAO;

import ControladoraConnector.ControladoraConnector;
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

public class ProductoDAO implements IDAO {

    ControladoraConnector ConnectorController;

    public ProductoDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public Boolean crear(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        String sql = "insert into productos(id_productos, nombre, descripcion, costo) value (?, ?, ?, ?,?);";
        /*
        Se utiliza un try-with-resources (try) 
        para asegurar que los recursos como las conexiones y
        los resultados se cierren automáticamente después de su uso
         */
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, String.valueOf(prod.getIdProducto()));
            st.setString(2, prod.getNombre());
            st.setString(3, prod.getDescripcion());
            st.setString(4, String.valueOf(prod.getCosto()));

            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<ProductoDTO> mostrar() {
        List Salida = new ArrayList();
        String sql = "select id_productos, nombre, descripcion, costo from productos;";
        try (PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql); ResultSet result = state.executeQuery()) {
            while (result.next()) {
                ProductoDTO producto = new ProductoDTO(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4));
                Salida.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return Salida;
    }

    @Override
    public Boolean actualizar(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        String sql = "update productos set nombre = ?, descripcion = ?, costo = ? where id_productos = ?;";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setString(1, prod.getNombre());
            st.setString(2, prod.getDescripcion());
            st.setString(3, String.valueOf(prod.getCosto()));
            st.setString(4, String.valueOf(prod.getIdProducto()));
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        ProductoDTO prod = (ProductoDTO) e;
        String sql = "DELETE FROM productos WHERE id_productos = ?";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setInt(1, prod.getIdProducto());
            JOptionPane.showMessageDialog(null, "Producto con ID : " + prod.getIdProducto());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        } finally {
            ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        ProductoDTO producto = new ProductoDTO();
        String sql = "select id_productos, nombre, descripcion, costo from productos WHERE id_productos = ?";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                ProductoDTO clone = new ProductoDTO(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4));
                producto = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        } finally {
            ConnectorController.CloseConnection();
        }
        return producto;
    }

    public Object porNombre(String nombre, String descripcion, Float costo) {
        ProductoDTO producto = new ProductoDTO();
        String sql = "select id_productos, nombre, descripcion, costo from productos WHERE nombre = ? AND descripcion = ? AND costo = ?";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setString(1, nombre);
            st.setString(2, descripcion);
            st.setFloat(3, costo);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                producto.setIdProducto(result.getInt(1));
                producto.setNombre(result.getString(2));
                producto.setDescripcion(result.getString(3));
                producto.setCosto(result.getFloat(4));
                return producto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al seleccionar");
        } finally {
            ConnectorController.CloseConnection();
        }
        return null;
    }

    public int obtenerUltimoIDProducto() {
        int ultimoID = 0;
        String sql = "SELECT MAX(id_producto) FROM productos";

        try {
            PreparedStatement statement = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                ultimoID = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }

        return ultimoID;
    }
}
