package titosrestobar;

import View.FormMesa;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;


public class TitosRestoBar {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormMesa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormMesa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
