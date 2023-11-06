package DAO;

import java.util.List;

public interface IDAO {
    
    abstract int crear(Object e); //Devuelo la ID del objecto ingresado en la BD para la vista 

    abstract List mostrar();

    abstract void actualizar(Object e);

    public abstract void borrar(Object e);

    public abstract Object porId(int id);
}
