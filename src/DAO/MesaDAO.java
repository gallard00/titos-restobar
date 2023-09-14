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
        System.out.println("Nombre de la mesa:");
        
        System.out.println("Nombre:");
        mesa.setNombre(scanner.nextLine());
        
        mesas.add(mesa);
        
        System.out.println("Mesa agregada exitosamente.");
    }
    
}
