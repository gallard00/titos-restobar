package Controlador;

import DAO.ItemsDAO;
import Modelo.ItemsDTO;
import java.util.ArrayList;
import java.util.List;


public class ItemsController 
{
   private List<ItemsDTO> ListaItems = new ArrayList<>();
   static ItemsController Instance; 
   
   public static ItemsController getInstance() 
   {
       if(Instance == null)
       {
           Instance = new ItemsController();
           return Instance;
       }
       return null;
   }
  
}
