package ControladoraConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase abstracta ControladoraConnector proporciona una conexión a la base
 * de datos para las clases controladoras.
 */
public abstract class ControladoraConnector {

    public static ControladoraConnector Instance;

    private Connection connector;

    /**
     * Constructor privado que inicializa la conexión a la base de datos.
     *
     * @throws SQLException si ocurre un error al establecer la conexión.
     */
    private ControladoraConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {

                connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/titos_restobar?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControladoraConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladoraConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método estático para obtener una instancia única de
     * ControladoraConnector.
     *
     * @return la instancia única de ControladoraConnector.
     * @throws SQLException si ocurre un error al establecer la conexión.
     */
    public static synchronized ControladoraConnector GetInstanceConnector() throws SQLException {
        if (Instance == null) {
            Instance = new ControladoraConnector() {
            };
        }
        return Instance;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public void CloseConnection() {
        Instance = null;
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return la conexión a la base de datos.
     */
    public Connection getConnection() {
        return connector;
    }
}
