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
		File file = new File("C:\\Users\\Kai\\eclipse-workspace\\Projecto 1\\PogramacionAvanzada-Proyecto1\\RegistroCurso\\src\\curso1.txt");
		BufferedReader lectorTxt = new BufferedReader(new FileReader(file));
		String lineText = null;
		
        int opcion = -1;
        String inputUsuario;
        
        int i, plibre, cantidad, cantHabilidades;
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
                	
                	if(plibre < cantidad)
                	{
                		//Se lee la primera linea, corresponde a los datos del curso
                		lineText = lectorTxt.readLine();
                		//Divide la linea en secciones
                		String[] lineaLeida = lineText.split(",");
                		
                		cursos[plibre] = new Curso();
                		cursos[plibre].setNombre(lineaLeida[0]);
                		
                		cantHabilidades = 0;
                		i = 1;
                		ArrayList<String> nombreHabilidades = new ArrayList<>();
                		while(i < lineaLeida[i].length())
                		{
                			System.out.println(lineaLeida[i]);
                			nombreHabilidades.add(lineaLeida[i]);
                			cantHabilidades++;
                			i++;
                		}
                		//Settea el arreglo con los nombres de las habilidades
                		cursos[plibre].setNombreHabilidades(nombreHabilidades);
                		
                		// Leer estudiantes (segunda linea en adelante)
                		
                		//Mientras la linea leída tenga info del estudiante
                		while((lineText = lectorTxt.readLine()) != null)
                		{
                			//Divide la linea en secciones
                    		lineaLeida = lineText.split(",");
                    		
                    		i = 3;
                    		//Lee los True y False de las habilidades
                    		while(i < lineaLeida[i].length())
                    		{
                    			ArrayList<Boolean> habilidades = new ArrayList<>();
                    			habilidades.add(Boolean.parseBoolean(lineaLeida[i]));
                    			i++;
                    		}
                    		cursos[plibre].agregarEstudiante(lineaLeida[0], cantHabilidades, null);
                		}

                		/*while((lineText = lectorTxt.readLine()) != null && plibre < cantidad)
						{
							String[] lineaLeida = lineText.split(",");
							plibre+=1;
						}*/
                		plibre++;
                		System.out.println("Listo!");
                		break;
                	}
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