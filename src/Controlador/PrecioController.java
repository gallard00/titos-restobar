package Controlador;

import DAO.PrecioDAO;
import Modelo.PrecioDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.Date;

public class PrecioController {

    private List<PrecioDTO> listaPrecio = new ArrayList<>();
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

    public void BorrarPrecio(int idProducto) {
        PrecioDTO borrarPrecio = new PrecioDTO(idProducto);
        PrecioDAO.borrar(borrarPrecio);
        listaPrecio.remove(borrarPrecio);
    }

    //</editor-fold>
    public List<PrecioDTO> pedirListaPrecio() {
        listaPrecio = LeerPrecio();
        return listaPrecio;
    }

    public PrecioDTO obtenerPrecioLista(int id) {
        for (PrecioDTO precio : pedirListaPrecio()) {
            if (precio.getId() == id) {
                return precio;
            }
        }
        return null;
    }
    public void crearActualizarPrecio(int idProducto, float costo, float porcentajeAumento) {
        // Siempre crea un nuevo precio
        float nuevoPrecio = calcularPrecio(costo, porcentajeAumento);
        Date fechaActual = new Date(); // Puedes ajustar la fecha según tus necesidades
        PrecioDAO.crear(new PrecioDTO(nuevoPrecio, fechaActual, idProducto));
    }

    private float calcularPrecio(float costo, float porcentajeAumento) {
        return costo + (costo * (porcentajeAumento / 100));
    }
//<editor-fold defaultstate="collapsed" desc=" Datos de la Tabla de Precios">
    
    public Object[] filaTablaPrecio(int i)
    {
        Object datoFila[] = new Object[1];
        PrecioDTO precio = pedirListaPrecio().get(i);
        if(precio != null)
        {
            datoFila[0] = pedirListaPrecio().get(i).getValor();
            return datoFila;
        }
        return null;
    }
    
    public Object[] indicePrecio(int id)
    {
        Object datoFila[] = new Object[1];
        PrecioDTO precio = obtenerPrecioLista(id);
        if(precio != null)
        {
            datoFila[0] =  precio.getValor();
        }
        return datoFila;
    }
//</editor-fold>
}
