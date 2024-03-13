package DAO;

import java.util.List;

public interface IDAO {
    
    abstract Boolean crear(Object e);

    abstract List mostrar();

    abstract Boolean actualizar(Object e);

    public abstract void borrar(Object e);

    public abstract Object porId(int id);
}
