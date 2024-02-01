package titorestobar;
import View.FormIndex;
import View.FormPedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

-- Alumnos: ZUBIRI Nahuel, SANCHEZ Nicolas, GALLARDO Nahuel. -- 
-- Profesor: SANTINI Estaban. --
-- Programación Orientada a Objetos --

//Comentario: Cuando agregas un "Producto" elaborado no tiene un stock/cantidad, pero un "ProductoNoElaborado"
//            si lo tiene, nosotros todavia no implementamos el poder guardar "ProductoNoElaborado", solo el Producto.

*/
public class TitosRestoBar {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIndex().setVisible(true);
            }
        });
    }
    
}
