/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        /* revisar que las mierdas estén bien
        * que todo sea en un menú para que se escoja lo que se quiere hacer
        */
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("C:\\Users\\asnfklasfkjlas\\eclipse-workspace\\ActividadPersonaFono\\src\\contactos.txt");
		BufferedReader lectorTxt = new BufferedReader(new FileReader(file));
		String lineText = null;
		
        int opcion = -1;
        String inputUsuario;
        
        int i, plibre, cantidad;
        cantidad = 5;
        plibre = 0;
        Curso[] cursos = new Curso[cantidad];
        
        // MENU
        while (opcion != 0)
        {
            System.out.println("Seleccione lo que quiere hacer:");
            System.out.println("1. Importar Curso a través de un .txt");
            System.out.println("2. b");
            System.out.println("3. c");
            System.out.println("4. Reimu");
            System.out.println("5. ah");
            System.out.println("0. Salir");
            
            /*ingresar cosas*/
            inputUsuario = lector.readLine();
            opcion = Integer.parseInt(inputUsuario);
            
            switch (opcion)
            {
                case 1:
                {
                	System.out.println("Leer txt");
                	String[] lineaLeida = lineText.split(",");
                	
                	if(plibre < cantidad)
                	{
                		cursos[plibre] = new Curso();

                		cursos[plibre].setNombre(lineaLeida[0]);
                		
                		//cursos[plibre].setEdad(Byte.parseByte(lineaLeida[1]));
                		//cursos[plibre].setFono(Long.parseLong(lineaLeida[2]));
                		i = 3;
                		while(lineaLeida[i] != null)
                		{
                			ArrayList<Boolean> habilidades = new ArrayList<>();
                			habilidades.add(Boolean.parseBoolean(lineaLeida[i]));
                		}
                	}

					while((lineText = lectorTxt.readLine()) != null && plibre < cantidad)
					{
						
						
						plibre+=1;
						System.out.println("Listo!");
					}
                    break;
                }
                case 2:
                    System.out.println("se ha escogido 2");
                    break;
                case 3:
                    System.out.println("se ha escogido 3");
                    break;
                case 4:
                    System.out.println("se ha escogido Reimu");
                    break;
                case 5:
                    System.out.println("se ha escogido ah");
                    break;
                case 0:
                    System.out.println("se ha escogido Salir");
                    break;
                default:
                    System.out.println("input inválido");
                    break;
                   
            }
            
        }
        
        
        
        
        
    }
}