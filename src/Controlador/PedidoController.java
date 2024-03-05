package Controlador;

import DAO.ItemsDAO;
import DAO.PedidoDAO;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.PedidoDTO.EstadoPedido;
import Modelo.ProductoCompletoDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PedidoController {

    private final List<PedidoDTO> ListaPedido = new ArrayList<>();
    private static PedidoController Instance;
    private final PedidoDAO PedidoDAO;
    private final ItemsDAO ItemsDAO;

    PedidoController() throws SQLException {
        PedidoDAO = new PedidoDAO();
        ItemsDAO = new ItemsDAO();
    }

    public static PedidoController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new PedidoController();
        }
        return Instance;
    }

    //<editor-fold defaultstate="collapsed" desc=" CRUD PEDIDO "> 
    public void crearPedido(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, EstadoPedido estadoPedido, int idMesa) {
        PedidoDTO pedido = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, estadoPedido, idMesa);
        PedidoDAO.crear(pedido);
    }

    public List ListaPedido() {
        return PedidoDAO.mostrar();
    }

    public void UpdatePedido(Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
       // PedidoDTO actped = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, producto);
        //PedidoDAO.actualizar(actped);
    }

    public void DeletePedido(int id) {
        PedidoDTO borrped = new PedidoDTO(id);
        PedidoDAO.borrar(borrped);
        ListaPedido.remove(borrped);
    }

    //</editor-fold>
    public boolean existePedidoActivo(int idMesa) {
        List<PedidoDTO> pedidos = PedidoDAO.mostrar(); // Obtener la lista de todos los pedidos
        for (PedidoDTO pedido : pedidos) {
            if (pedido.getIdMesa() == idMesa && pedido.getEstadoPedido() == EstadoPedido.ACTIVO) {
                return true; // Si encuentra un pedido activo para la mesa, retorna true
            }
        }
        return false;

    }
    public int obtenerIdPedidoActivo(int idMesa){
        
        List<PedidoDTO> pedidos = PedidoDAO.mostrar(); // Obtener la lista de todos los pedidos
    for (PedidoDTO pedido : pedidos) {
        if (pedido.getIdMesa() == idMesa && pedido.getEstadoPedido() == EstadoPedido.ACTIVO) {
            return  pedido.getId();
        }
    }
        return -1;
    }
    
}
