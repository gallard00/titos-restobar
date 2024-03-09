package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.PedidoDTO.EstadoPedido;
import Modelo.ProductoCompletoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String sql = "INSERT INTO pedidos(fecha_apertura, fecha_cierre, descuento, costo_total, id_mesas, estado_pedido) value (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Formatear la fehca antes de guardarla
            SimpleDateFormat fechaModificada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaNuevaApertura = fechaModificada.format(ped.getFechaApertura());
            st.setString(1, fechaNuevaApertura);
            if (ped.getFechaCierre() != null) {
                String fechaNuevaCierre = fechaModificada.format(ped.getFechaCierre());
                st.setString(2, fechaNuevaCierre);
            } else {
                st.setNull(2, java.sql.Types.TIMESTAMP);
            }
            st.setString(3, String.valueOf(ped.getDescuento()));
            st.setString(4, String.valueOf(ped.getCostoTotal()));
            st.setString(5, String.valueOf(ped.getIdMesa()));
            st.setString(6, String.valueOf(ped.getEstadoPedido()));
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                ped.setId(rs.getInt(1));
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public List<PedidoDTO> mostrar() {
        List<PedidoDTO> listaPedido = new ArrayList<>();
        String sql = "SELECT id_pedidos, fecha_apertura, fecha_cierre, descuento, costo_total, id_mesas, estado_pedido FROM pedidos ";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt(1);
                Date fechaApertura = result.getDate(2);
                Date fechaCierre = result.getDate(3);
                float descuento = result.getFloat(4);
                float costoTotal = result.getFloat(5);
                int idMesa = result.getInt(6);
                String estadoPedidoStr = result.getString(7); // Obtener el estado del pedido como String
                EstadoPedido estadoPedido = EstadoPedido.valueOf(estadoPedidoStr); // Convertir el String al enum EstadoPedido

                PedidoDTO ped = new PedidoDTO(id, fechaApertura, fechaCierre, descuento, costoTotal, idMesa, estadoPedido);
                listaPedido.add(ped);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return listaPedido;
    }

    @Override
    public Boolean actualizar(Object e) {
        PedidoDTO pedido = (PedidoDTO) e;
        String sql = "UPDATE pedidos SET fecha_cierre = ?, descuento = ?, costo_total = ?, estado_pedido = ? WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            // Establecer los parámetros del PreparedStatement adecuadamente
            SimpleDateFormat fechaModificada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaNuevaCierre = fechaModificada.format(pedido.getFechaCierre());
            st.setString(1, fechaNuevaCierre);
            st.setFloat(2, pedido.getDescuento());
            st.setFloat(3, pedido.getCostoTotal());
            st.setString(4, pedido.getEstadoPedido().toString()); // Convertir el enum EstadoPedido a String
            st.setInt(5, pedido.getId()); // Establecer el id del pedido

            // Ejecutar la actualización
            int filasActualizadas = st.executeUpdate();

            // Verificar si se actualizó correctamente al menos una fila
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return false;
    }

    @Override
    public void borrar(Object e) {
        PedidoDTO ped = (PedidoDTO) e;
        String sql = "DELETE FROM pedidos WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setInt(1, ped.getId());
            JOptionPane.showMessageDialog(null, "ID : " + ped.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, la base de datos no guardo los cambios");
        } finally {
            ConnectorController.CloseConnection();
        }
    }

    /*
    @Override
    public Object porId(int id) {
        PedidoDTO ped = null;
        String sql = "SELECT ped.descuento, ped.costo_total, "
               + "it.id_items, it.cantidad, it.costo_total AS costo_item, "
               + "prod.id_productos, prod.nombre, prod.descripcion "
               + "FROM pedidos AS ped "
               + "INNER JOIN items AS it ON ped.id_pedidos = it.id_pedidos "
               + "INNER JOIN productos AS prod ON it.id_productos = prod.id_productos "
               + "WHERE ped.id_pedidos = ?";
        try(PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql)) {
            
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            ped = new PedidoDTO();
            if (result.next()) {
                // Crear un nuevo objeto PedidoDTO y asignarle los valores de la fila actual del ResultSet
               
                ped.setDescuento(result.getFloat("descuento"));
                ped.setCostoTotal(result.getFloat("costo_total"));
            }
            List<ItemsDTO> items = new ArrayList<>();
            while(result.next()){
                
                ProductoCompletoDTO producto = new ProductoCompletoDTO();
                producto.setNombre(result.getString("nombre"));
                producto.setDescripcion(result.getString("descripcion"));
                
                // Crear un nuevo objeto ItemsDTO y asignarle los valores de la fila actual del ResultSet
                
                ItemsDTO item = new ItemsDTO();
                item.setCantidad(result.getInt("cantidad"));
                item.setCostoTotal(result.getFloat("costo_total"));
                item.setProducto(producto);

               items.add(item);
               
            }
         ped.setItems(items);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        } finally {
            ConnectorController.CloseConnection();
        }
        return ped;
    }
     */
    @Override
public Object porId(int id) {
    PedidoDTO ped = null;
    String sql = "SELECT ped.descuento, ped.costo_total, "
           + "it.id_items, it.cantidad, it.costo_total AS costo_item, "
           + "prod.id_productos, prod.nombre, prod.descripcion "
           + "FROM pedidos AS ped "
           + "INNER JOIN items AS it ON ped.id_pedidos = it.id_pedidos "
           + "INNER JOIN productos AS prod ON it.id_productos = prod.id_productos "
           + "WHERE ped.id_pedidos = ?";
    try {
        try(Connection conn = ConnectorController.getConnection(); 
            PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            ped = new PedidoDTO();
            if (result.next()) {
                // Crear un nuevo objeto PedidoDTO y asignarle los valores de la fila actual del ResultSet
               
                ped.setDescuento(result.getFloat("descuento"));
                ped.setCostoTotal(result.getFloat("costo_total"));
            }
            List<ItemsDTO> items = new ArrayList<>();
            while(result.next()){
                
                ProductoCompletoDTO producto = new ProductoCompletoDTO();
                producto.setNombre(result.getString("nombre"));
                producto.setDescripcion(result.getString("descripcion"));
                
                // Crear un nuevo objeto ItemsDTO y asignarle los valores de la fila actual del ResultSet
                
                ItemsDTO item = new ItemsDTO();
                item.setCantidad(result.getInt("cantidad"));
                item.setCostoTotal(result.getFloat("costo_total"));
                item.setProducto(producto);

               items.add(item);
               
            }
         ped.setItems(items);
        }
    } catch (SQLException ex) {
        Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
    } finally {
        ConnectorController.CloseConnection();
    }
    return ped;
}

    public List<PedidoDTO> mostrarPedidosCerrados(int idMesa) {
        List<PedidoDTO> listaPedido = new ArrayList<>();
        String sql = "SELECT id_pedidos, fecha_apertura, fecha_cierre, costo_total FROM pedidos WHERE id_mesas = ? AND estado_pedido = 'CERRADO'";
        try {
            PreparedStatement state = ConnectorController.getConnection().prepareStatement(sql);
            state.setInt(1, idMesa);
            ResultSet result = state.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                Date fechaApertura = result.getDate(2);
                Date fechaCierre = result.getDate(3);
                float costoTotal = result.getFloat(4);
                //String estadoPedidoStr = result.getString(7); // Obtener el estado del pedido como String
                //EstadoPedido estadoPedido = EstadoPedido.valueOf(estadoPedidoStr); // Convertir el String al enum EstadoPedido

                PedidoDTO ped = new PedidoDTO(id, fechaApertura, fechaCierre, costoTotal);
                listaPedido.add(ped);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectorController.CloseConnection();
        }
        return listaPedido;
    }

}
