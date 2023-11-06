package titorestobar;

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
                    new FormMesa().setVisible(true);
                } catch (SQLException ex) {
                }
            }
        });
    }
    
}
