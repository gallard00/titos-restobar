package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ProductoCompletoDTO;
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
        String sql = "insert into productos(id_productos, nombre, descripcion, costo) value (?, ?, ?, ?);";
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

    // Método para obtener todos los productos con información de precios y stock
    public List<ProductoCompletoDTO> obtenerProductosCompletos() throws SQLException {
        List<ProductoCompletoDTO> productos = new ArrayList<>();
        String query = "SELECT p.id_productos, p.nombre, p.descripcion, p.costo, pn.stock, pr.valor "
                + "FROM productos p "
                + "LEFT JOIN productos_no_elaborados pn ON p.id_productos = pn.id_productos "
                + "LEFT JOIN (SELECT id_productos, MAX(fecha) AS fecha_max FROM precios GROUP BY id_productos)pr_max "
                + "ON p.id_productos = pr_max.id_productos "
                + "LEFT JOIN precios pr ON pr_max.id_productos = pr.id_productos AND pr_max.fecha_max = pr.fecha";
        try (PreparedStatement statement = ConnectorController.getConnection().prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ProductoCompletoDTO productoCompleto;
                productoCompleto = new ProductoCompletoDTO(
                        resultSet.getInt("id_productos"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getFloat("costo"),
                        resultSet.getFloat("valor"),
                        resultSet.getInt("stock"));
                productos.add(productoCompleto);
            }
        }
        return productos;
    }

    @Override
    public List<ProductoCompletoDTO> mostrar() {
        List<ProductoCompletoDTO> salida = new ArrayList<>();
        String sql = "SELECT p.id_productos, p.nombre, p.descripcion, pn.stock, pr.valor "
                + "FROM productos p "
                + "INNER JOIN productos_no_elaborados pn ON p.id_productos = pn.id_productos "
                + "INNER JOIN precios pr ON p.id_productos = pr.id_productos "
                + "WHERE pr.fecha = (SELECT MAX(fecha) FROM precios WHERE id_productos = p.id_productos);";
        try (PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql); ResultSet result = state.executeQuery()) {
            while (result.next()) {
                ProductoCompletoDTO producto = new ProductoCompletoDTO(
                        result.getString("nombre"),
                        result.getString("descripcion"),
                        result.getFloat("valor"),
                        result.getInt("stock"));
                salida.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        for (ProductoCompletoDTO producto : salida) {
        String nombreYDescripcion = producto.getNombre() + " - " + producto.getDescripcion();
        System.out.println(nombreYDescripcion); // O cualquier otra acción que desees realizar
    }
        return salida;
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
        String sql = "SELECT id_productos, nombre, descripcion, costo FROM productos WHERE id_productos = ?";
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
        String sql = "SELECT MAX(id_productos) FROM productos";

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
