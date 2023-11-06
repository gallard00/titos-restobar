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
    
    //<editor-fold defaultstate="collapsed" desc=" CRUD "> 
     
    public int CrearMesa (String nombre) {
        MesaDTO crearMesa = new MesaDTO(nombre);
        int id = MesaDAO.crear(crearMesa);
        return id;
    }
    
    public List ReadMesa(){
        return MesaDAO.mostrar();
    }
    
    public void UpdateMesa (int id, String nombre) {
        MesaDTO actMesa = new MesaDTO(id , nombre);
        MesaDAO.actualizar(actMesa);
    }
    
    public void DeleteMesa (int id) {
        MesaDTO borrarMesa = new MesaDTO(id);
        MesaDAO.borrar(borrarMesa);
        ListaMesa.remove(borrarMesa);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Class Methods & External Requests ">
    public List<MesaDTO> PedirListaMesas() {
        ListaMesa = ReadMesa();
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
  //</editor-fold>  
    
    
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
    
    public Boolean SiMesaExiste(String name)
    {
        if(MesaDAO.porNombre(name) != null)
        {
            return true;
        }
        return false;
    }
   
    
    //<editor-fold defaultstate="collapsed" desc=" DataTable Rows&Index">
    
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
