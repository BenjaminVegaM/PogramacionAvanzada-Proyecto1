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
        /* revisar que las cosas estén bien
        * que todo sea en un menú para que se escoja lo que se quiere hacer
        */
    	//System.out.println("┬┴┬┴┤ ͜ʖ ͡°) ├┬┴┬┴");
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    	//hay que pedirle al usuario la dirección
    	/*CUANDO SE APRIETA 1 DOS VECES SEGUIDAS LA APLICACION SE CAE*/
		File file = new File(".\\src\\curso1.txt");
		BufferedReader lectorTxt = new BufferedReader(new FileReader(file));
		String lineText = null;
		
        int opcion = -1;
        String inputUsuario;
        Boolean encontrado = false;
        
        int plibre, capacidadCursos; // cantHabilidades  aun no esta en uso espacioLinea sin uso
        capacidadCursos = 5;
        //el nombre plibre me parece una horrible
        plibre = 0;
        //igual esto debería ser una lista
        Curso[] cursos = new Curso[capacidadCursos];
        
        // MENU
        while (opcion != 0)
        {
        	
        	System.out.println("Seleccione lo que quiere hacer:");
            System.out.println("1. Importar Curso a través de un .txt");
            System.out.println("2. Agregar un Alumno a un Curso");
            System.out.println("3. Buscar un Alumno por RUN");
            System.out.println("4. Mostrar todos los Alumnos de un Curso");
            System.out.println("0. Salir");
            
            /*ingresar cosas*/
            inputUsuario = lector.readLine();
            /*igual deberíamos dejarlo como strings porque así podríamos tener más control de lo que estamos haciendo*/
            opcion = Integer.parseInt(inputUsuario);
            
            
            
            switch (opcion)
            {
            	//importar un curso desde un .txt
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
                		//espacioLinea = 1;
                		cursos[plibre].importarHabilidades(lineaLeida, 1);
                		
                		/*Se obtienen los estudiantes y se colocan en el arreglo que les corresponde*/
                		while((lineText = lectorTxt.readLine()) != null)
                		{
                    		lineaLeida = lineText.split(",");
                    		cursos[plibre].importarEstudiante(lineaLeida, 2);
                		}
                		
                		plibre++;
                		System.out.println("\nListo!");
                		break;
                	}
                }
                //agregar estudiante a un curso
                /*le pide el nombre del curso y luego busca para ver si esta, si se encuentra, intenta importar el estudiante*/
                /*si fuera una lista sería más rápido ┬┴┬┴┤ ͜ʖ ͡°) ├┬┴┬┴*/
                case 2:
                	/*podríamos cambiar esto para que sea una wea de objeto y tal*/
                    System.out.println("Agregar estudiante a un curso");
                    System.out.println("Ingrese el nombre del curso al que quiere agregar este estudiante: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	System.out.println("se compara "+ inputUsuario + " con "+cursos[cont].getNombreCurso());
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		System.out.println("Ingrese los datos del estudiante separados por comas:");
                    		
                            inputUsuario = lector.readLine();
                            String[] lineaLeida = inputUsuario.split(",");
                            cursos[cont].importarEstudiante(lineaLeida, 2);
                            
                    		encontrado = true;
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	//igual podría crear otra variable para pedirle al usuario si quiere ir al menú o lo quiere intentar de nuevo
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    	break;
                    }
                    encontrado = false;
                    break;
                case 3:
                	//se busca que exista el curso, luego revisa si el rut recibido existe en el hashtable
                    System.out.println("Buscar estudiante en un curso");
                    System.out.println("Ingrese el nombre del curso en el que quiere hacer la búsqueda: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		System.out.println("Ingrese el RUN del estudiante: ");
                    		
                            inputUsuario = lector.readLine();
                            Alumno alumnoBuscado = cursos[cont].buscarEstudiante(Integer.parseInt(inputUsuario));
                            if (alumnoBuscado == null)
                            {
                            	System.out.println("No se ha encontrado el alumno");
                            }
                            else
                            {
                            	System.out.println("Se ha encontrado el alumno");
                            	int runtesteo = alumnoBuscado.getRUN();
                            	cursos[cont].mostrarDatosEstudiante(runtesteo);
                            }
                            
                    		encontrado = true;
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	//igual podría crear otra variable para pedirle al usuario si quiere ir al menú o lo quiere intentar de nuevo
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    	break;
                    }
                    encontrado = false;
                    break;
                case 4:
                    System.out.println("se ha escogido Mostrar todos los Alumnos de un Curso");
                    //se busca que exista el curso, luego revisa si el rut recibido existe en el hashtable
                    System.out.println("Ingrese el nombre del curso que quiere mostrar: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                            Enumeration<Integer> enu = cursos[cont].getAlumnos().keys();
                            while (enu.hasMoreElements()) {
                                cursos[cont].mostrarDatosEstudiante(enu.nextElement());
                            }
                    		encontrado = true;
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	//igual podría crear otra variable para pedirle al usuario si quiere ir al menú o lo quiere intentar de nuevo
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    	break;
                    }
                    encontrado = false;
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