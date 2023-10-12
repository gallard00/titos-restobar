package DAO;

import java.sql.SQLException;

public class ProductoNoElaboradoDAO extends ProductoDAO {
    ControladoraConnector ConnectorController;
    
    public ProductoNoElaboradoDAO() throws SQLException {
        ConnectorController = ControladoraConnector.GetInstanceConnector();
    }
}
