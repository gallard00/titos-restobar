package titorestobar;
import View.FormIndex;

/*

-- Alumnos: ZUBIRI Nahuel, SANCHEZ Nicolas, GALLARDO Nahuel. -- 
-- Profesor: SANTINI Estaban. --
-- Programación Orientada a Objetos --

//Comentario: Cuando agregas un "Producto" elaborado no tiene un stock/cantidad, pero un "ProductoNoElaborado"


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
