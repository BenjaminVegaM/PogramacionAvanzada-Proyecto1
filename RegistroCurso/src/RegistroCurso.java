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
        ArrayList<Curso> cursos = new ArrayList<>();
        
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
                		
                		Curso cursoTemp = new Curso();
                		cursoTemp.setNombre(lineaLeida[0]);
                		System.out.println("\nEl nombre del curso es: " + cursoTemp.getNombreCurso());
                		
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
                    		cursoTemp.importarAlumno(lineaLeida, 2, nombreHabilidadesTemp);
                		}
                		
                		plibre++;
                		cursos.add(cursoTemp);
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
                    	if (Objects.equals(inputUsuario,cursos.get(capacidadCursos).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");

                    		System.out.println("Ingrese los datos en el siguiente formato: nombre,rut,estadoHabilidad1,...,estadoHabilidadN");
                            System.out.println("(en caso de que se incluyan más habilidades de las que admite el curso, se ignorarán las que sobren. Si se agregan menos, el resto serán iniciadas en reprobado)");
                            inputUsuario = lector.readLine();
                            String[] lineaLeida = inputUsuario.split(",");
                            cursos.get(capacidadCursos).importarAlumno(2, lineaLeida, cursos.get(capacidadCursos).getNombreHabilidades());
                            
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
                    if(plibre >= cursos.size())
                    {
                    	System.out.println("Se ha llegado a la cantidad máxima de Cursos.");
                    	break;
                    }
                    System.out.println("Ingrese el nombre del nuevo Curso: ");
                    inputUsuario = lector.readLine();
                    encontrado = false;
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(capacidadCursos).getNombreCurso()))
                    	{
                    		System.out.println("Un curso con ese nombre ya existe."); 
                    		encontrado = true;
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	Curso cursoTemp = new Curso();
                    	cursoTemp.setNombre(inputUsuario);
                    	cursos.add(cursoTemp);
                    	System.out.println("Nuevo curso "+cursoTemp.getNombreCurso()+" creado correctamente.");
                    	plibre++;
                    	break;
                    }
                    encontrado = false;
                	break;
                /*añadir habilidad a un alumno*/
                case 4:
                	System.out.println("Cambiar estado de la habilidad de un alumno");
                	System.out.println("Ingrese el curso: ");
                	inputUsuario = lector.readLine();
                	
                	encontrado = false;
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(capacidadCursos).getNombreCurso()))
                    	{
                    		encontrado = true;
                    		System.out.println("Se ha encontrado el curso, ahora ingrese el RUT del alumno: ");
                    		inputUsuario = lector.readLine();
                    		cursos.get(capacidadCursos).cambiarEstadoHabilidadesAlumno(Integer.parseInt(inputUsuario), inputUsuario, lector);
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    }
                    encontrado = false;
                	break;
                /*buscar alumno por RUT*/
                case 5:
                	//se busca que exista el curso, luego revisa si el rut recibido existe en el hashtable
                    System.out.println("Buscar alumno en un curso");
                    System.out.println("Ingrese el nombre del curso en el que quiere hacer la búsqueda: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < plibre ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(capacidadCursos).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		System.out.println("Ingrese el RUN del alumno: ");
                    		
                            inputUsuario = lector.readLine();
                            Alumno alumnoBuscado = cursos.get(capacidadCursos).buscarAlumno(Integer.parseInt(inputUsuario));
                            if (alumnoBuscado == null)
                            {
                            	System.out.println("No se ha encontrado el alumno");
                            }
                            else
                            {
                            	System.out.println("Se ha encontrado el alumno");
                            	int runtesteo = alumnoBuscado.getRUN();
                            	cursos.get(capacidadCursos).mostrarDatosAlumno(runtesteo);
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
                    	if (Objects.equals(inputUsuario,cursos.get(capacidadCursos).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                            Enumeration<Integer> enu = cursos.get(capacidadCursos).getAlumnos().keys();
                            while (enu.hasMoreElements())
                            {
                            	cursos.get(capacidadCursos).mostrarDatosAlumno(enu.nextElement());
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
                    System.out.println("Saliendo y guardando los cambios...");
                	File testFile = new File("dick.txt");
                	FileWriter testFileWriter = new FileWriter(testFile);
                	PrintWriter printWriterTestFile = new PrintWriter(testFileWriter);
                	
                	/*Hay que hacer esto con la lista completa*/
                	Curso cursoTemp = cursos.get(0);
                	Enumeration<Integer> enu = cursos.get(0).getAlumnos().keys();
                	
                	cursoTemp.updateFile(testFile,testFileWriter,printWriterTestFile,enu);
                	System.out.println("Guardado exitoso");
                	
                	printWriterTestFile.close();
                	break;
                case 177013: /*Guardar varios cursos a la vez*/
                	System.out.println("Guardando cambios:");
                	File testFile1 = new File("TestGuardadoInstitutoCompleto.txt");
                	FileWriter testFileWriter1 = new FileWriter(testFile1);
                	PrintWriter printWriterTestFile1 = new PrintWriter(testFileWriter1);
                	
                	for (int cont = 0; cont < cursos.size(); cont += 1)
                	{
                		Curso cursoTemp1 = cursos.get(cont);
                    	Enumeration<Integer> enu1 = cursos.get(cont).getAlumnos().keys();
                    	cursoTemp1.updateFile(testFile1,testFileWriter1,printWriterTestFile1,enu1);
                    	printWriterTestFile1.write("\n*****\n");
                	}
                	
                	printWriterTestFile1.write("—————");
                	printWriterTestFile1.close();
                	break;
                	
                case 182290: /*Importar Varios cursos a la vez*/
                	/*Requiere mas testeo probablemente... no toma en cuenta alumnos de distinto curso pero mismo rut*/
                	System.out.println("Importando archivo del instituto");
                	File instituto = new File("EjemploInstituto.txt");
                	BufferedReader lectorInstituto = new BufferedReader(new FileReader(instituto));
                	
                	String linea = lectorInstituto.readLine();
            		String[] lineaDividida = linea.split(",");
            		String endOfFile = "—————";
            		String endOfCurso = "*****";
            		boolean repetido = false;
                	
                	while (linea.equals(endOfFile) != true)
                	{
                		//Se revisa si ya existe un curso con el mismo nombre
                		if (cursos.size() >= 1)
                		{
                			for (int cont = 0; cont < cursos.size(); cont += 1)
                			{
                				System.out.println("se comparan: "+lineaDividida[0]+" y "+cursos.get(cont).getNombreCurso());
                				if (lineaDividida[0].equals(cursos.get(cont).getNombreCurso()) == true)
                				{
                					System.out.println("Se ha descubierto que uno de los nombres está repetido, pasando al siguiente curso");
                					repetido = true;
                					
                					linea = lectorInstituto.readLine();
                					while (linea.equals(endOfCurso) != true)
                					{
                						linea = lectorInstituto.readLine();
                					}
                					linea = lectorInstituto.readLine();
                					lineaDividida = linea.split(",");
                					break;
                				}
                			}
                		}
                		
                		if (repetido == true)
            			{
            				repetido = false;
            				continue;
            			}
                		
                		Curso cursoTemp2 = new Curso();
                		cursoTemp2.setNombre(lineaDividida[0]);
                		System.out.println("\nEl nombre del curso es: " + cursoTemp2.getNombreCurso());
                		
                		/*Se importan las habilidades desde la línea de texto empezando desde la posición 1*/
                		ArrayList<String> nombreHabilidadesTemp1 = new ArrayList<>();
                		int posInicial = 1;
                		while (posInicial < lineaDividida.length)
                		{
                			System.out.println("se ha ingresado la habilidad: " + lineaDividida[posInicial]);
                			nombreHabilidadesTemp1.add(lineaDividida[posInicial]);
                			posInicial += 1;
                		}
                		
                		/*Se obtienen los alumnos y se colocan en el arreglo que les corresponde*/
                		linea = lectorInstituto.readLine();
                		while(linea.equals(endOfCurso) != true)
                		{
                			System.out.println("Importando alumnos");
                			lineaDividida = linea.split(",");
                    		cursoTemp2.importarAlumno(lineaDividida, 2, nombreHabilidadesTemp1);
                    		linea = lectorInstituto.readLine();
                		}
                		
                		cursos.add(cursoTemp2);
                		System.out.println("\nCurso ha sido añadido con éxito");
                		
                		linea = lectorInstituto.readLine();
                		lineaDividida = linea.split(",");
                	}
                	
                	System.out.println("Se ha terminado de importar el curso");
                	break;
                	
                default:
                    System.out.println("input inválido");
                    break;
                   
            }
        }
        
        lectorTxt.close();
    }
}