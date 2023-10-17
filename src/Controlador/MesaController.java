package Controlador;

import DAO.MesaDAO;
import DAO.PedidoDAO;
import Modelo.MesaDTO;
import Modelo.PedidoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaController {
    private List<MesaDTO> ListaMesa = new ArrayList<>();
    private static MesaController Instance;
    private final MesaDAO MesaDAO;
    private final PedidoDAO PedidoDAO;
    
    private MesaController() throws SQLException {
        MesaDAO = new MesaDAO();
        PedidoDAO = new PedidoDAO();
    }
    
    public static MesaController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new MesaController();
        }
        return Instance;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" CRUD "> 
     
    public void CrearMesa (String nombre, List<PedidoDTO> pedido) {
        MesaDTO crearMesa = new MesaDTO(nombre, pedido);
        MesaDAO.crear(crearMesa);
    }
    
    public List ReadMesa(){
        return MesaDAO.mostrar();
    }
    
    public void UpdateMesa (String nombre, List<PedidoDTO> pedido) {
        MesaDTO actMesa = new MesaDTO(nombre, pedido);
        MesaDAO.actualizar(actMesa);
    }
    
    public void DeleteMesa (int id) {
        MesaDTO borrarMesa = new MesaDTO(id);
        MesaDAO.borrar(borrarMesa);
        ListaMesa.remove(borrarMesa);
    }
    
    //</editor-fold>
}
