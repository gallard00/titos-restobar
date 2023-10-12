package DAO;

import java.util.List;

public interface IDAO {
    
    abstract int crear(Entidad e); //Devuelo la ID del objecto ingresado en la BD para la vista 

    abstract List mostrar();

    abstract void actualizar(Entidad e);

    public abstract void borrar(Entidad e);

    public abstract Entidad porId(int id);
}
