package Controlador;

import DAO.ItemsDAO;
import Modelo.ItemsDTO;
import Modelo.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class ItemsController 
{
   private List<ItemsDTO> ListaItems = new ArrayList<>();
   static ItemsController Instance;
   private final ItemsDAO ItemsDAO;
   
     ItemsController() throws SQLException {
        ItemsDAO = new ItemsDAO();
    }
   
   public static ItemsController getInstance() throws SQLException 
   {
       if(Instance == null)
       {
           Instance = new ItemsController();
           return Instance;
       }
       return null;
   }
   
    //<editor-fold defaultstate="collapsed" desc=" CRUD "> 
     
    public Boolean CrearItems(int cantidad, float costoTotal, ProductoDTO producto) {
        ItemsDTO items = new ItemsDTO(cantidad, costoTotal, producto);
        return ItemsDAO.crear(items);
    }
    
    public List LeerItems() {
        return ItemsDAO.mostrar();
    }
    
    public Boolean ActualizarItems(int id,int cantidad, float costoTotal, ProductoDTO producto) {
        ItemsDTO actualizarItems = new ItemsDTO(id, cantidad, costoTotal, producto);
        return ItemsDAO.actualizar(actualizarItems);
    }

    public void BorrarItems(int id) {
        ItemsDTO borrarItems = new ItemsDTO(id);
        ItemsDAO.borrar(borrarItems);
        ListaItems.remove(borrarItems);
    }
    
    //</editor-fold>  
    
    //<editor-fold defaultstate="collapsed" desc=" Metodos de las Clases ">
    public List<ItemsDTO> PedirListaItems() {
        ListaItems = LeerItems();
        return ListaItems;
    }
    
    public ItemsDTO obtenerItemsLista(int id){
        for (ItemsDTO items : PedirListaItems())
        {
            if(items.getId() == id)
            {
                return items;
            }
        }
        return null;
    }
    
    public ItemsDTO calcularCostoTotal(float costoTotal){
        
       return null;
        
    }
    
  //</editor-fold> 
  
}
