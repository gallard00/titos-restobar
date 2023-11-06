package titosrestobar;

import View.FormMesa;
import View.FormProducto;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;


public class TitosRestoBar {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormProducto().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
