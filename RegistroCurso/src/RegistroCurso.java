/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
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
    	//hay que pedirle al usuario la dirección
		File file = new File("D:\\Programación Avanzada (2241-1)\\PogramacionAvanzada-Proyecto1\\RegistroCurso\\src\\curso1.txt");
		BufferedReader lectorTxt = new BufferedReader(new FileReader(file));
		String lineText = null;
		
        int opcion = -1;
        String inputUsuario;
        
        int espacioLinea, plibre, capacidadCursos, cantHabilidades;
        capacidadCursos = 5;
        plibre = 0;
        Curso[] cursos = new Curso[capacidadCursos];
        
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
                	/*igual podríamos hacer la mitad de esto dentro del mismo objeto curso... yo solo digo... podría ser posible*/
                	if(plibre < capacidadCursos)
                	{
                		/*se crea el curso y se le pone el nombre*/
                		lineText = lectorTxt.readLine();
                		String[] lineaLeida = lineText.split(",");
                		
                		cursos[plibre] = new Curso();
                		cursos[plibre].setNombre(lineaLeida[0]);
                		System.out.println("\nel nombre del curso es: " + cursos[plibre].getNombreCurso());
                		
                		/*se importan las habilidades desde la línea de texto empezando desde la posición 1*/
                		/*igual ese 1 debería ser una constante*/
                		espacioLinea = 1;
                		cursos[plibre].importarHabilidades(lineaLeida, espacioLinea);
                		
                		/*Se obtienen los estudiantes y se colocan en el arreglo que les corresponde*/
                		while((lineText = lectorTxt.readLine()) != null)
                		{
                    		lineaLeida = lineText.split(",");
                    		espacioLinea = 2;
                    		cursos[plibre].importarEstudiante(lineaLeida, espacioLinea);
                		}
                		
                		plibre++;
                		System.out.println("\nListo!");
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
        
        lectorTxt.close();
    }
}