package Controlador;
import DAO.MesaDAO;
import Modelo.ItemsDTO;
import Modelo.MesaDTO;
import Modelo.PedidoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MesaController {
    private List<MesaDTO> ListaMesa = new ArrayList<>();
    private static MesaController Instance;
    private final MesaDAO MesaDAO;
    
    private MesaController() throws SQLException {
        MesaDAO = new MesaDAO();
    }
    
    public static MesaController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new MesaController();
        }
        return Instance;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" CRUD de Mesa "> 
     
    public Boolean CrearMesa (String nombre) {
        MesaDTO crearMesa = new MesaDTO(nombre);
        return MesaDAO.crear(crearMesa);
    }
    
    public List LeerMesa(){
        return MesaDAO.mostrar();
    }
    
    public Boolean ActualizarMesa (int id, String nombre) {
        MesaDTO actMesa = new MesaDTO(id , nombre);
        return MesaDAO.actualizar(actMesa);
    }
    
    public void BorrarMesa (int id) {
        MesaDTO borrarMesa = new MesaDTO(id);
        MesaDAO.borrar(borrarMesa);
        ListaMesa.remove(borrarMesa);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Metodos de la Clase ">
    public List<MesaDTO> PedirListaMesas() {
        ListaMesa = LeerMesa();
        return ListaMesa;
    }
    
    public MesaDTO getMesaFromList(int id){
        for (MesaDTO mesa : PedirListaMesas())
        {
            if(mesa.getId() == id)
            {
                return mesa;
            }
        }
        return null;
    }
    
    public Boolean SiMesaExiste(String nombre)
    {
        MesaDTO mesa = (MesaDTO)MesaDAO.porNombre(nombre);
        if(mesa != null)
        {
            return true;
        }
        return false;
    }
  //</editor-fold>  
    
    //<editor-fold defaultstate="collapsed" desc=" CRUD de Pedido "> 
    public void CrearPedido (Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        PedidoDTO crearPedido = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, producto);
        /*PedidoDAO.crear(crearPedido);*/
    }
    
    public void ActualizarPedido (Date fechaApertura, Date fechaCierre, float descuento, float costoTotal, List<ItemsDTO> producto) {
        PedidoDTO actPedido = new PedidoDTO(fechaApertura, fechaCierre, descuento, costoTotal, producto);
        /*PedidoDAO.actualizar(actPedido);*/
    }
    
    public void BorrarPedido (int id) {
        PedidoDTO borrarPedido = new PedidoDTO(id);
       /* PedidoDAO.borrar(borrarPedido);*/
        ListaMesa.remove(borrarPedido);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Datos de la tabla de Mesa">
    
    public Object[] RequestTableRow(int i)
    {
        Object rowdata[] = new Object[2];
        MesaDTO mesa = PedirListaMesas().get(i);
        if(mesa != null)
        {
            rowdata[0] = PedirListaMesas().get(i).getId();
            rowdata[1] = PedirListaMesas().get(i).getNombre();
            return rowdata;
        }
        return null;
    }
    
    public Object[] RequestObjectIndex(int id)
    {
        Object rowdata[] = new Object[2];
        MesaDTO mesa = getMesaFromList(id);
        if(mesa != null)
        {
            rowdata[0] =  mesa.getId();
            rowdata[1] =  mesa.getNombre();
        }
        return rowdata;
    }
//</editor-fold>
     
}
