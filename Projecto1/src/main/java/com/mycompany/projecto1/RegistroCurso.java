/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecto1;
import java.io.*;
import java.util.*;
/**
 *
 * @author pablo
 */
public class RegistroCurso 
{
    public static void main (String arg[]) throws IOException 
    {
        /*cosas*/
        /*importar texto con sus mierdas
        * revisar que las mierdas estén bien
        * que todo sea en un menú para que se escoja lo que se quiere hacer
        */
        int opcion = -1;
        BufferedReader lector = new BufferedReader(new InputStreamReader( System.in ));
        String inputUsuario;
        while (opcion != 0)
        {
            System.out.println("Seleccione lo que quiere hacer:");
            System.out.println("1. a");
            System.out.println("2. b");
            System.out.println("3. c");
            System.out.println("4. Reimu");
            System.out.println("5. ah");
            System.out.println("0. Salir");
            
            /*ingresar su mierda*/
            inputUsuario = lector.readLine();
            opcion = Integer.parseInt(inputUsuario);
            
            switch (opcion)
            {
                case 1:;
                    System.out.println("se ha escogido 1");
                    break;
                case 2:;
                    System.out.println("se ha escogido 2");
                    break;
                case 3:;
                    System.out.println("se ha escogido 3");
                    break;
                case 4:;
                    System.out.println("se ha escogido Reimu");
                    break;
                case 5:;
                    System.out.println("se ha escogido ah");
                    break;
                case 0:;
                    System.out.println("se ha escogido Salir");
                    break;
                default:;
                    System.out.println("input inválido");
                    break;
                   
            }
            
        }
        
        
        
        
        
    }
}
