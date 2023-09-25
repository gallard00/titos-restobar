package DAO;

import Modelo.MesaDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MesaDAO {
    private List<MesaDTO> mesas;
    private Scanner scanner;
    
    public MesaDAO (){
        scanner = new Scanner(System.in);
        mesas = new ArrayList<>();
    }
    
    public void CrearMesas(){
        MesaDTO mesa = new MesaDTO();
        System.out.println("Escriba el nombre de la mesa:");
        
        System.out.println("Nombre:");
        mesa.setNombre(scanner.nextLine());
        
        mesas.add(mesa);
        
        System.out.println("Mesa agregada exitosamente.");
    }
    
    public void listaMesas() { //Muestra la lista de Mesas guardadas en la agenda, si es que hay
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas en la agenda.");
        } else {
            System.out.println("Lista de Mesas:");
            for (MesaDTO mesa : mesas) {
                System.out.println(mesa);
            }
        }
    }
    
}
