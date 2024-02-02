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
<<<<<<< HEAD
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIndex().setVisible(true);
            }
=======
        java.awt.EventQueue.invokeLater(() -> {
            new FormIndex().setVisible(true);
>>>>>>> 67f610a27f6c01136b5ef53c0bbc25baaa48e537
        });
    }
    
}
