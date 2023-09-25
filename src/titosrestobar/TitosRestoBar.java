package titosrestobar;

import DAO.MesaDAO;

public class TitosRestoBar {

    public static void main(String[] args) {
        MesaDAO franco = new MesaDAO();
        franco.CrearMesas();
        franco.listaMesas();
    }
    
}
