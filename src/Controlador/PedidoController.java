package Controlador;

import DAO.ItemsDAO;
import DAO.PedidoDAO;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PedidoController {
    private  List<PedidoDTO> ListaPedido = new ArrayList<>();
    private static PedidoController Instance;
    private final PedidoDAO PedidoDAO;
    private final ItemsDAO ItemsDAO;
    
       private PedidoController() throws SQLException {
        PedidoDAO = new PedidoDAO();
        ItemsDAO = new ItemsDAO();
    }
       
     public static PedidoController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new PedidoController();
        }
        return Instance;
    }
     
    //<editor-fold defaultstate="collapsed" desc=" CRUD "> 
     
    public void CrearPedido (Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        PedidoDTO creped = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, producto);
        PedidoDAO.crear(creped);
    }
    
    public List ReadPedido(){
        return PedidoDAO.mostrar();
    }
    
    public void UpdatePedido (Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        PedidoDTO actped = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, producto);
        PedidoDAO.actualizar(actped);
    }
    
    public void DeletePedido (int id) {
        PedidoDTO borrped = new PedidoDTO(id);
        PedidoDAO.borrar(borrped);
        ListaPedido.remove(borrped);
    }
    
    //</editor-fold>
}
