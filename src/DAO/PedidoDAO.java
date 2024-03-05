package DAO;

import ControladoraConnector.ControladoraConnector;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.PedidoDTO.EstadoPedido;
import Modelo.ProductoCompletoDTO;
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
        } finally {
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
        } finally {
            ConnectorController.CloseConnection();
        }
    }

    @Override
    public Object porId(int id) {
        PedidoDTO ped = new PedidoDTO();
        String sql = "SELECT it.id_items, it.cantidad, it.costo_total, it.id_pedidos, it.id_productos, ped.id_pedidos, ped.fecha_apertura, ped.fecha_cierre, ped.descuento, ped.costo_total, ped.id_mesas, ped.estado_pedido from pedidos AS ped INNER JOIN items AS it ON ped.id_pedido = it.id_pedidos WHERE id_pedidos = ?";
        try {
            PreparedStatement st = ConnectorController.getConnection().prepareStatement(sql);
            st.setString(1, Integer.toString(id));
            ResultSet result = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"En Execute Query");
            if (result.next()) {
                
                ItemsDTO it = new ItemsDTO(result.getInt(1), result.getInt(2), result.getFloat(3), (ProductoCompletoDTO) result.getObject(4));
                PedidoDTO clone = new PedidoDTO(result.getInt(5), result.getDate(6), result.getDate(7), result.getFloat(8), result.getFloat(9), (List<ItemsDTO>) result.getObject(10));
                ped = clone;
                it = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en seleccion de ID");
        } finally {
            ConnectorController.CloseConnection();
        }
        return ped;
    }

}
