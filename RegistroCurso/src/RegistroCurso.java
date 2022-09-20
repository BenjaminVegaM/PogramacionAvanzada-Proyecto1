/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
//import java.io.PrintWriter;
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
    	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    	/*CUANDO SE APRIETA 1 DOS VECES SEGUIDAS LA APLICACION SE CAE*/
		File file = new File(".\\src\\curso1.txt");
		BufferedReader lectorTxt = new BufferedReader(new FileReader(file));
		String lineText = null;
		
        int opcion = -1;
        String inputUsuario;
        Boolean encontrado = false;
        
        int plibre, capacidadCursos; // cantidad de cursos
        capacidadCursos = 5;
        plibre = 0;
        Curso[] cursos = new Curso[capacidadCursos];
        
        // MENU
        while (opcion != 0)
        {
        	
        	System.out.println("Seleccione lo que quiere hacer:");
            System.out.println("1. Importar Curso a través de un .txt");
            System.out.println("2. Agregar un Alumno a un Curso");
            System.out.println("3. Crear un nuevo Curso");
            System.out.println("4. Cambiar estado de la habilidad de un alumno");
            System.out.println("5. Buscar un Alumno por RUT");
            System.out.println("6. Mostrar todos los Alumnos de un Curso");
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
                	if(plibre < capacidadCursos)
                	{
                		/*Se crea el curso y se le asigna el nombre*/
                		lineText = lectorTxt.readLine();
                		String[] lineaLeida = lineText.split(",");
                		
                		cursos[plibre] = new Curso();
                		cursos[plibre].setNombre(lineaLeida[0]);
                		System.out.println("\nEl nombre del curso es: " + cursos[plibre].getNombreCurso());
                		
                		/*Se importan las habilidades desde la línea de texto empezando desde la posición 1*/
                		
                		ArrayList<String> nombreHabilidadesTemp = new ArrayList<>();
                		int posInicial = 1;
                		while (posInicial < lineaLeida.length)
                		{
                			System.out.println("se ha ingresado la habilidad: " + lineaLeida[posInicial]);
                			nombreHabilidadesTemp.add(lineaLeida[posInicial]);
                			posInicial += 1;
                		}
                		
                		/*Se obtienen los alumnos y se colocan en el arreglo que les corresponde*/
                		while((lineText = lectorTxt.readLine()) != null)
                		{
                    		lineaLeida = lineText.split(",");
                    		cursos[plibre].importarAlumno(lineaLeida, 2, nombreHabilidadesTemp);
                		}
                		
                		plibre++;
                		System.out.println("\nListo!");
                		break;
                	}
                }
                //agregar alumno a un curso
                case 2:
                	/*podríamos cambiar esto para que sea una wea de objeto y tal*/
                    System.out.println("Agregar Alumno a un Curso");
                    System.out.println("Ingrese el nombre del Curso al que quiere agregar este Alumno: ");
                    inputUsuario = lector.readLine();
                    encontrado = false;
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		Alumno nuevoAlumno = new Alumno();

                    		System.out.println("Ingrese el Nombre del alumno:");
                            nuevoAlumno.setNombre(lector.readLine());

                            System.out.println("Ingrese el RUN del alumno:");
                            nuevoAlumno.setRUN(Integer.parseInt(lector.readLine()));
                            /*DISCLAIMER esto falla en la lista de las habilidades, hay que crear la funcion para el objeto curso*/
                            //String[] lineaLeida = inputUsuario.split(",");
                            cursos[cont].agregarAlumno(nuevoAlumno);
                            
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
                /*crear curso*/
                case 3:
                    System.out.println("Crear un nuevo Curso");
                    if(plibre >= cursos.length)
                    {
                    	System.out.println("Se ha llegado a la cantidad máxima de Cursos.");
                    	break;
                    }
                    System.out.println("Ingrese el nombre del nuevo Curso: ");
                    inputUsuario = lector.readLine();
                    encontrado = false;
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Un curso con ese nombre ya existe."); 
                    		encontrado = true;
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	cursos[plibre] = new Curso();
                		cursos[plibre].setNombre(inputUsuario);
                    	System.out.println("Nuevo curso "+cursos[plibre].getNombreCurso()+" creado correctamente.");
                    	plibre++;
                    	break;
                    }
                	break;
                /*añadir habilidad a un alumno*/
                case 4:
                	System.out.println("Cambiar estado de la habilidad de un alumno");
                	System.out.println("Ingrese el curso: ");
                	inputUsuario = lector.readLine();
                	
                	encontrado = false;
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		encontrado = true;
                    		System.out.println("Se ha encontrado el curso, ahora ingrese el RUT del alumno: ");
                    		inputUsuario = lector.readLine();
                            cursos[cont].cambiarEstadoHabilidadesAlumno(Integer.parseInt(inputUsuario), inputUsuario, lector);
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    }
                	break;
                /*buscar alumno por RUT*/
                case 5:
                	//se busca que exista el curso, luego revisa si el rut recibido existe en el hashtable
                    System.out.println("Buscar alumno en un curso");
                    System.out.println("Ingrese el nombre del curso en el que quiere hacer la búsqueda: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		System.out.println("Ingrese el RUN del alumno: ");
                    		
                            inputUsuario = lector.readLine();
                            Alumno alumnoBuscado = cursos[cont].buscarAlumno(Integer.parseInt(inputUsuario));
                            if (alumnoBuscado == null)
                            {
                            	System.out.println("No se ha encontrado el alumno");
                            }
                            else
                            {
                            	System.out.println("Se ha encontrado el alumno");
                            	int runtesteo = alumnoBuscado.getRUN();
                            	cursos[cont].mostrarDatosAlumno(runtesteo);
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
                /*Mostrar todos los alumnos de un curso*/
                case 6:
                    System.out.println("Se ha escogido Mostrar todos los Alumnos de un Curso");
                    //se busca que exista el curso, luego revisa si el run recibido existe en el hashtable
                    System.out.println("Ingrese el nombre del curso que quiere mostrar: ");
                    encontrado = false;
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos[cont].getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                            Enumeration<Integer> enu = cursos[cont].getAlumnos().keys();
                            while (enu.hasMoreElements())
                            {
                                cursos[cont].mostrarDatosAlumno(enu.nextElement());
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
                case 177013:
                	//System.out.println("Test");
                	/*se crea un archivo de texto de prueba para probar la actualizacion de .txt*/
                	/*eso si, mas que actualizar, crea uno aparte para un curso específico*/
                	System.out.println("Guardando cambios:");
                	File testFile = new File("dick.txt");
                	FileWriter testFileWriter = new FileWriter(testFile);
                	PrintWriter printWriterTestFile = new PrintWriter(testFileWriter);
                	
                	/*Hay que hacer esto con la lista completa*/
                	Curso cursoTemp = cursos[0];
                	Enumeration<Integer> enu = cursos[0].getAlumnos().keys();
                	
                	cursoTemp.updateFile(testFile,testFileWriter,printWriterTestFile,enu);
                	
                	
                	printWriterTestFile.close();
                	break;
                	
                default:
                    System.out.println("input inválido");
                    break;
                   
            }
            
        }
        
        lectorTxt.close();
    }
}