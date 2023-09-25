/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Nahu
 */
public interface IDAO {
    public void Crear(Object e);
    public List<Object> Lear();
    public Object LeerPorId(Object e);
    public Object Modificar(Object e);
    public Object Borrar(Object e);
}
