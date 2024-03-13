package Controlador;

import DAO.MesaDAO;
import Modelo.MesaDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase MesaController es responsable de controlar las operaciones
 * relacionadas con las mesas en el sistema.
 */
public class MesaController {

    private List<MesaDTO> ListaMesa = new ArrayList<>();
    private static MesaController Instance;
    private final MesaDAO MesaDAO;

    /**
     * Constructor privado que inicializa el objeto MesaDAO.
     *
     * @throws SQLException si ocurre un error de base de datos.
     */
    private MesaController() throws SQLException {
        MesaDAO = new MesaDAO();
    }

    /**
     * Método estático para obtener una instancia única de MesaController.
     *
     * @return la instancia única de MesaController.
     * @throws SQLException si ocurre un error de base de datos.
     */
    public static MesaController GetInstance() throws SQLException {
        if (Instance == null) {
            Instance = new MesaController();
        }
        return Instance;
    }

    /**
     * Crea una nueva mesa con el nombre especificado.
     *
     * @param nombre el nombre de la mesa.
     * @return true si la mesa se creó con éxito, false de lo contrario.
     */
    public Boolean CrearMesa(String nombre) {
        MesaDTO crearMesa = new MesaDTO(nombre);
        return MesaDAO.crear(crearMesa);
    }

    /**
     * Retorna una lista de todas las mesas en el sistema.
     *
     * @return una lista de objetos MesaDTO.
     */
    public List LeerMesa() {
        return MesaDAO.mostrar();
    }

    /**
     * Actualiza el nombre de la mesa con el ID especificado.
     *
     * @param id el ID de la mesa a actualizar.
     * @param nombre el nuevo nombre de la mesa.
     * @return true si la actualización se realizó con éxito, false de lo
     * contrario.
     */
    public Boolean ActualizarMesa(int id, String nombre) {
        MesaDTO actMesa = new MesaDTO(id, nombre);
        return MesaDAO.actualizar(actMesa);
    }

    /**
     * Borra la mesa con el ID especificado.
     *
     * @param id el ID de la mesa a borrar.
     */
    public void BorrarMesa(int id) {
        MesaDTO borrarMesa = new MesaDTO(id);
        MesaDAO.borrar(borrarMesa);
        ListaMesa.remove(borrarMesa);
    }

    /**
     * Retorna una lista de todas las mesas en el sistema.
     *
     * @return una lista de objetos MesaDTO.
     */
    public List<MesaDTO> PedirListaMesas() {
        ListaMesa = LeerMesa();
        return ListaMesa;
    }

    /**
     * Obtiene la mesa con el ID especificado de la lista de mesas.
     *
     * @param id el ID de la mesa a buscar.
     * @return el objeto MesaDTO correspondiente al ID especificado, o null si
     * no se encuentra.
     */
    public MesaDTO getMesaFromList(int id) {
        for (MesaDTO mesa : PedirListaMesas()) {
            if (mesa.getId() == id) {
                return mesa;
            }
        }
        return null;
    }

    /**
     * Verifica si existe una mesa con el nombre especificado en el sistema.
     *
     * @param nombre el nombre de la mesa a verificar.
     * @return true si la mesa existe, false de lo contrario.
     */
    public Boolean SiMesaExiste(String nombre) {
        MesaDTO mesa = (MesaDTO) MesaDAO.porNombre(nombre);
        if (mesa != null) {
            return true;
        }
        return false;
    }

    public String obtenerNombreMesaPorId(int idMesa) throws SQLException {
        return MesaDAO.porId(idMesa);
    }

    /**
     * Retorna los datos de una fila de la tabla de mesas en la posición
     * especificada.
     *
     * @param i la posición de la fila en la tabla de mesas.
     * @return un array de objetos con los datos de la fila, o null si la
     * posición es inválida.
     */
    public Object[] RequestTableRow(int i) {
        Object rowdata[] = new Object[2];
        MesaDTO mesa = PedirListaMesas().get(i);
        if (mesa != null) {
            rowdata[0] = PedirListaMesas().get(i).getId();
            rowdata[1] = PedirListaMesas().get(i).getNombre();
            return rowdata;
        }
        return null;
    }

    /**
     * Retorna los datos de una mesa en base a su ID.
     *
     * @param id el ID de la mesa.
     * @return un array de objetos con los datos de la mesa, o null si no se
     * encuentra la mesa.
     */
    public Object[] RequestObjectIndex(int id) {
        Object rowdata[] = new Object[2];
        MesaDTO mesa = getMesaFromList(id);
        if (mesa != null) {
            rowdata[0] = mesa.getId();
            rowdata[1] = mesa.getNombre();
        }
        return rowdata;
    }
}
