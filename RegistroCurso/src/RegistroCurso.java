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
    	int opcion = 177013;
        String inputUsuario;
        Boolean encontrado = false;

        ArrayList<Curso> cursos = new ArrayList<>();
    	
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
    				//System.out.println("se comparan: "+lineaDividida[0]+" y "+cursos.get(cont).getNombreCurso());
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
    		
    		Curso cursoAImportar = new Curso();
    		cursoAImportar.setNombre(lineaDividida[0]);
    		System.out.println("\nEl nombre del curso es: " + cursoAImportar.getNombreCurso());
    		
    		//Se importan las habilidades desde la línea de texto empezando desde la posición 1
    		ArrayList<String> nombreHabilidadesTemp1 = new ArrayList<>();
    		int posInicial = 1;
    		while (posInicial < lineaDividida.length)
    		{
    			//System.out.println("se ha ingresado la habilidad: " + lineaDividida[posInicial]);
    			nombreHabilidadesTemp1.add(lineaDividida[posInicial]);
    			posInicial += 1;
    		}
    		
    		//Se obtienen los alumnos y se colocan en el arreglo que les corresponde
    		linea = lectorInstituto.readLine();
    		while(linea.equals(endOfCurso) != true)
    		{
    			//System.out.println("Importando alumnos");
    			lineaDividida = linea.split(",");
    			cursoAImportar.importarAlumno(lineaDividida, 2, nombreHabilidadesTemp1);
        		linea = lectorInstituto.readLine();
    		}
    		
    		cursos.add(cursoAImportar);
    		System.out.println("\n"+cursoAImportar.getNombreCurso()+" ha sido añadido con éxito");
    		
    		linea = lectorInstituto.readLine();
    		lineaDividida = linea.split(",");
    	}
    	
    	System.out.println("Se ha terminado de importar el instituto");
    	lectorInstituto.close();
        
        //MENU
        while (opcion != 0)
        {
        	
        	System.out.println("Seleccione lo que quiere hacer:");
            System.out.println("1. Agregar un Alumno a un Curso");
            System.out.println("2. Crear un nuevo Curso");
            System.out.println("3. Cambiar estado de la habilidad de un alumno");
            System.out.println("4. Buscar un Alumno por RUT");
            System.out.println("5. Mostrar todos los Alumnos de un Curso");
            System.out.println("6. Mostrar a todos los alumnos que cumplan ciertas características del instituto");
            System.out.println("0. Salir");

            inputUsuario = lector.readLine();
            //igual deberíamos dejarlo como strings porque así podríamos tener más control de lo que estamos haciendo
            opcion = Integer.parseInt(inputUsuario);

            switch (opcion)
            {
                //agregar alumno a un curso
                case 1:
                {
                	//podríamos cambiar esto para que sea una wea de objeto y tal
                	//hay que evitar que se pongan de nombres el fin de curso y el fin de archivo
                    System.out.println("Agregar Alumno a un Curso");
                    System.out.println("Ingrese el nombre del Curso al que quiere agregar este Alumno: ");
                    inputUsuario = lector.readLine();
                    encontrado = false;
                    for (int cont = 0; cont < cursos.size() ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(cont).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");

                    		System.out.println("Ingrese los datos en el siguiente formato: nombre,rut,estadoHabilidad1,...,estadoHabilidadN");
                            System.out.println("(en caso de que se incluyan más habilidades de las que admite el curso, se ignorarán las que sobren. Si se agregan menos, el resto serán iniciadas en reprobado)");
                            inputUsuario = lector.readLine();
                            String[] lineaLeida = inputUsuario.split(",");
                            cursos.get(cont).importarAlumno(2, lineaLeida, cursos.get(cont).getNombreHabilidades());
                            
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
                }
                //crear curso
                //hay que evitar que se pongan de nombres el fin de curso y el fin de archivo
                case 2:
                {
                    System.out.println("Crear un nuevo Curso");
                    System.out.println("Ingrese el nombre del nuevo Curso: ");
                    inputUsuario = lector.readLine();
                    encontrado = false;
                    
                    while (Objects.equals(inputUsuario, endOfCurso) || Objects.equals(inputUsuario, endOfFile))
                	{
                		System.out.println("Nombre inválido, inténtelo de nuevo");
                	}
                    
                    for (int cont = 0; cont < cursos.size() ; cont++)
                    {
                    	//podríamos cambiar esto para que se repita hasta que se indique un nombre válido o se quiera salir???
                    	if (Objects.equals(inputUsuario,cursos.get(cont).getNombreCurso()))
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
                    	break;
                    }
                    encontrado = false;
                	break;
                }
                //cambiar estado de la habilidad de un alumno
                case 3:
                {
                	System.out.println("Cambiar estado de la habilidad de un alumno");
                	System.out.println("Ingrese el curso: ");
                	inputUsuario = lector.readLine();
                	
                	encontrado = false;
                    for (int cont = 0; cont < cursos.size() ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(cont).getNombreCurso()))
                    	{
                    		encontrado = true;
                    		System.out.println("Se ha encontrado el curso, ahora ingrese el RUT del alumno: ");
                    		inputUsuario = lector.readLine();
                    		cursos.get(cont).cambiarEstadoHabilidadesAlumno(Integer.parseInt(inputUsuario), inputUsuario, lector);
                    		break;
                    	}
                    }
                    
                    if (encontrado == false)
                    {
                    	System.out.println("No se ha encontrado el curso, inténtelo de nuevo");
                    }
                    encontrado = false;
                	break;
                }
                //buscar alumno por RUT
                case 4:
                {
                	//se busca que exista el curso, luego revisa si el rut recibido existe en el hashtable
                    System.out.println("Buscar alumno en un curso");
                    System.out.println("Ingrese el nombre del curso en el que quiere hacer la búsqueda: ");
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < cursos.size() ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(cont).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		System.out.println("Ingrese el RUN del alumno: ");
                    		
                            inputUsuario = lector.readLine();
                            Alumno alumnoBuscado = cursos.get(cont).buscarAlumno(Integer.parseInt(inputUsuario));
                            if (alumnoBuscado == null)
                            {
                            	System.out.println("No se ha encontrado el alumno");
                            }
                            else
                            {
                            	System.out.println("Se ha encontrado el alumno");
                            	int runtesteo = alumnoBuscado.getRUN();
                            	cursos.get(cont).mostrarDatosAlumno(runtesteo);
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
                }
                //Mostrar todos los alumnos de un curso
                case 5:
                {
                    System.out.println("Se ha escogido Mostrar todos los Alumnos de un Curso");
                    //se busca que exista el curso, luego revisa si el run recibido existe en el hashtable
                    System.out.println("Ingrese el nombre del curso que quiere mostrar: ");
                    encontrado = false;
                    inputUsuario = lector.readLine();
                    for (int cont = 0; cont < cursos.size() ; cont++)
                    {
                    	if (Objects.equals(inputUsuario,cursos.get(cont).getNombreCurso()))
                    	{
                    		System.out.println("Se ha encontrado el curso");
                    		if (cursos.get(cont).getAlumnos().size() < 1)
                    		{
                    			System.out.println("Pero este se encuentra vacío, inténtelo con otro");
                    		}
                            Enumeration<Integer> enu = cursos.get(cont).getAlumnos().keys();
                            while (enu.hasMoreElements())
                            {
                            	cursos.get(cont).mostrarDatosAlumno(enu.nextElement());
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
                }
                case 6:
                {
                	int opcion2 = 177013;
                	while (opcion2 != 0)
                	{
                		System.out.println("1. Todos los que cumplan las condiciones de aprobación");
                        System.out.println("2. Todos los que reprueben");
                        System.out.println("3. no tengo ni idea de que poner acá");
                        System.out.println("0. Volver al menú principal");
                	
		            	inputUsuario = lector.readLine();
		            	//posible excepción
		                opcion2 = Integer.parseInt(inputUsuario);
		            	switch(opcion2)
		            	{
			            	case 1:
			            	{
			            		//me da lata editar los cursos ahora, así que tienen que tener todo aprobado para pasar
			            		ArrayList<Alumno> aprobados = new ArrayList<>();
			            		for (int cont = 0; cont < cursos.size(); cont += 1)
			            		{
			            			ArrayList<Alumno> aprobadosCursoActual = cursos.get(cont).alumnosAprobados();
			            			for (int contAprobados = 0; contAprobados < aprobadosCursoActual.size(); contAprobados += 1)
			            			{
			            				aprobados.add(aprobadosCursoActual.get(contAprobados));
			            			}
			            		}
			            		
			            		if (aprobados.size() < 1)
			            		{
			            			System.out.println("No hay ningún alumno que apruebe su curso por el momento");
			            			break;
			            		}
			            		
			            		System.out.println("Los alumnos que aprueban son: ");
			            		for (int cont = 0; cont < aprobados.size(); cont += 1)
			            		{
			            			aprobados.get(cont).mostrarDatos();
			            		}
			            		
			            		break;
			            	}
		            	}
                	}
                	
                	break;
                }
                case 0:
                {
                    System.out.println("Saliendo y guardando los cambios...");
                	File testFile = new File("TestGuardadoInstitutoCompleto.txt");
                	FileWriter testFileWriter = new FileWriter(testFile);
                	PrintWriter printWriterTestFile = new PrintWriter(testFileWriter);
                	
                	for (int cont = 0; cont < cursos.size(); cont += 1)
                	{
                		Curso cursoTemp1 = cursos.get(cont);
                    	Enumeration<Integer> enu1 = cursos.get(cont).getAlumnos().keys();
                    	cursoTemp1.updateFile(testFile,testFileWriter,printWriterTestFile,enu1);
                    	printWriterTestFile.write("\n*****\n");
                	}
                	
                	printWriterTestFile.write("—————");
                	printWriterTestFile.close();
                	System.out.println("Guardado realizado con éxito");
                	break;
                }
                default:
                {
                    System.out.println("input inválido");
                    break;
                }
            }
        }
    }
}