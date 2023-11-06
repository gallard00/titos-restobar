package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ControladoraConnector {
    
    public static ControladoraConnector Instance;
    
    private Connection connector;
    
    private ControladoraConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/restobar?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");
            } catch (SQLException ex) {
                Logger.getLogger(ControladoraConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControladoraConnector.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static synchronized ControladoraConnector GetInstanceConnector() throws SQLException{
        if (Instance == null) {
            Instance = new ControladoraConnector() {};
        }
        return Instance;
    }
    
        public void CloseConnection(){
        Instance = null;
    }

    public Connection getConnection() {
        return connector;
    }
}

