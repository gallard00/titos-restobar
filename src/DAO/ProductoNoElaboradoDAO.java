package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ProductoNoElaboradoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductoNoElaboradoDAO extends ProductoDAO {

    ControladoraConnector ConnectorController;

    public ProductoNoElaboradoDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }

    @Override
    public Boolean crear(Object e) {
        ProductoNoElaboradoDTO prod = (ProductoNoElaboradoDTO) e;
        String sql = "INSERT INTO productos_no_elaborados(stock, id_productos) VALUES (?, ?);";
        /*
        Se utiliza un try-with-resources (try) 
        para asegurar que los recursos como las conexiones y
        los resultados se cierren automáticamente después de su uso
         */
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, String.valueOf(prod.getStock()));
            st.setString(2, String.valueOf(prod.getIdProducto()));
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductoNoElaboradoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    public List<ProductoNoElaboradoDTO> mostrarProductosNoElaborados() {
        List<ProductoNoElaboradoDTO> listaProductosNoElaborados = new ArrayList<>();
        String sql = "SELECT id_productos_no_elaborados, stock FROM productos_no_elaborados;";
        try (PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql); ResultSet result = state.executeQuery()) {
            while (result.next()) {
                ProductoNoElaboradoDTO productoNoElaborado = new ProductoNoElaboradoDTO(result.getInt(1), result.getInt(2));
                listaProductosNoElaborados.add(productoNoElaborado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoNoElaboradoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return listaProductosNoElaborados;
    }

    public Boolean actualizarProductoNoElaborado(Object e) {
        ProductoNoElaboradoDTO prod = (ProductoNoElaboradoDTO) e;
        String sql = "UPDATE productos_no_elaborados set stock = ? where id_productos_no_elaborados = ?;";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setString(1, String.valueOf(prod.getStock()));
            st.setString(2, String.valueOf(prod.getIdProducto()));
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoNoElaboradoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    public void borrarProductoNoElaborado(Object e) {
        ProductoNoElaboradoDTO prod = (ProductoNoElaboradoDTO) e;
        String sql = "DELETE FROM productos_no_elaborados WHERE id_productos_no_elaborados = ?";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setInt(1, prod.getIdProducto());
            JOptionPane.showMessageDialog(null, "Se elimino un producto no elaborado con ID : " + prod.getIdProducto());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoNoElaboradoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        } finally {
            ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        ProductoNoElaboradoDTO productoNoElaborado = new ProductoNoElaboradoDTO();
        String sql = "select id_productos_no_elaborados, stock WHERE id_productos_no_elaborados = ?";
        try (PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                ProductoNoElaboradoDTO clone = new ProductoNoElaboradoDTO(result.getInt(1), result.getInt(2));
                productoNoElaborado = clone;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoNoElaboradoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        } finally {
            ConnectorController.CloseConnection();
        }
        return productoNoElaborado;
    }

}
