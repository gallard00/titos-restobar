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
    public Boolean CrearPrecio(float valor, Date fecha, int idProducto) {
        PrecioDTO precio = new PrecioDTO(valor, fecha, idProducto);
        return PrecioDAO.crear(precio);
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
    
    public void crearActualizarPrecio(int idProducto, float costo, float porcentajeAumento) {
        // Siempre crea un nuevo precio
        float nuevoPrecio = calcularPrecio(costo, porcentajeAumento);
        Date fechaActual = new Date(); // Puedes ajustar la fecha según tus necesidades
        PrecioDAO.crear(new PrecioDTO(nuevoPrecio, fechaActual, idProducto));
    }

    private float calcularPrecio(float costo, float porcentajeAumento) {
        return costo + (costo * (porcentajeAumento / 100));
    }

}
