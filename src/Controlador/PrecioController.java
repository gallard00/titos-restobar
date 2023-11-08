package Controlador;

import DAO.PrecioDAO;
import Modelo.PrecioDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.Date;

public class PrecioController {
    private List<PrecioDTO> ListaPrecios = new ArrayList<>();
    private static PrecioController Instance;
    private final PrecioDAO PrecioDAO;
    
    private PrecioController() throws SQLException {
        PrecioDAO = new PrecioDAO();
        
    }
    
    public static PrecioController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new PrecioController();
        }
        return Instance;
    }
    
        //<editor-fold defaultstate="collapsed" desc=" CRUD "> 
    
    public Boolean CrearPrecio(float valor, Date fecha) {
        PrecioDTO crearPrecio = new PrecioDTO(valor, fecha);
        return PrecioDAO.crear(crearPrecio);
    }
    
    public List LeerPrecio() {
        return PrecioDAO.mostrar();
    }
    
    public Boolean ActualizarPrecio(int id, float valor, Date fecha) {
        PrecioDTO actualizarPrecio = new PrecioDTO(id, valor, fecha);
        return PrecioDAO.actualizar(actualizarPrecio);
    }

    public void BorrarPrecio(int id) {
        PrecioDTO borrarPrecio = new PrecioDTO(id);
        PrecioDAO.borrar(borrarPrecio);
        ListaPrecios.remove(borrarPrecio);
    }
    
    //</editor-fold>
    
    
}
