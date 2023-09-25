/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.List;

public class ItemsController 
{
   static ItemsController Instance;
   private ArrayList<Person> ListPersons = new ArrayList<>();  
   public void ItemsController(){}
   
   public static ItemsController getInstance() 
   {
       if(Instance == null)
       {
           Instance = new ItemsController();
           return Instance;
       }
       return null;
   }
   
   public void crearPerson(String nombre, int dni, String apellido)
   {
       Person p = new Person();
       p.SetNombre(nombre);
       p.SetDNI(dni);
       p.SetApellido(apellido);
       ListPersons.add(p)
   }
   
   public float getItemTotal(Object e)
   {
       
   }
   
}
