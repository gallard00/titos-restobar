package Controlador;


public class ItemsController 
{
   static ItemsController Instance; 
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
  
   
}
