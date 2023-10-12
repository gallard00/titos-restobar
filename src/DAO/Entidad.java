package DAO;

public abstract class Entidad {

    protected int id;

    public int getID() {
        return this.id;
    }

    protected void setID(int i) {
        this.id = i;
    }
}
