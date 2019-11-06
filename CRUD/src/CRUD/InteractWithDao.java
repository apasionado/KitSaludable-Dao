/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class InteractWithDao {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        DaoCrud daoObject = new DaoCrud();

        System.out.println("Que operación deseas realizar? \r\n"
                + "1 - Agregar un alimento \r\n"
                + "2 - Actualizar un alimento por ID  \r\n"
                + "3 - Obtener información sobre los alimentos existentes  \r\n"
                + "4 - Eliminar un alimento por ID");
        String opcion = in.nextLine();
        Alimento alimento = new Alimento();
        
        String nombre;
        int cantidad;
        switch (opcion) {

            case "1":
                System.out.println("Que alimento deseas agregar?");
        
                nombre = in.nextLine();
                alimento.setNombre(nombre);
                
                System.out.println("Cuantos alimentos deseas agregar de " + nombre + "?");
                cantidad = in.nextInt();
                alimento.setCantidad(cantidad);
                
                daoObject.registrar(alimento);
                break;
                
            case "2":
                System.out.println("Que alimento deseas actualizar?");
                nombre = in.nextLine();
                alimento.setNombre(nombre);
                System.out.println("Cual es la nueva cantidad de "+ nombre + "?");
                cantidad = in.nextInt();
                alimento.setCantidad(cantidad);
                
                daoObject.actualizar(alimento);
                break;
                
                
            case "3":
                System.out.println("Estos son los alimentos que existen");
                ArrayList listaDeAlimentos = new ArrayList<Alimento>();
                listaDeAlimentos = daoObject.obtener();
                
                for(int i = 0;i < listaDeAlimentos.size(); i++){
                    System.out.println(listaDeAlimentos.get(i));
                }
                break;
                
            case "4":
                System.out.println("Ingresa el id del alimento que deseas eliminar");
                int id = in.nextInt();
                alimento.setId(id);
                
                
                daoObject.eliminar(alimento);
                break;
        }
    }

}
