package Controlador;

import DAO.ItemsDAO;
import DAO.PedidoDAO;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.ProductoCompletoDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PedidoController {
    private final  List<PedidoDTO> ListaPedido = new ArrayList<>();
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
    
    //<editor-fold defaultstate="collapsed" desc=" CRUD ITEMS "> 
    
    public void CrearItems (int cantidad, Object productos) {
        ProductoCompletoDTO producto = (ProductoCompletoDTO) productos;
        ItemsDTO crearItem = new ItemsDTO(cantidad, producto);
        crearItem.setCostoTotal(cantidad, producto);
        if(ItemsDAO.crear(crearItem))
        {
            
        }
        
    }
    
    public List LeerItems()
    {
        return ItemsDAO.mostrar();
    }
    
    public void ActualizarItems (int id, int cantidad, float costoTotal) {
        ItemsDTO actItems = new ItemsDTO(id, cantidad, costoTotal);
        ItemsDAO.actualizar(actItems);
    }
    
    public void BorrarItems (int id){
        ItemsDTO borrarItems = new ItemsDTO(id);
        ItemsDAO.borrar(borrarItems);
        ListaPedido.remove(borrarItems);
    }
    
    //</editor-fold>
}
