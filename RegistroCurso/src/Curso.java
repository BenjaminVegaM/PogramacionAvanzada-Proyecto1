/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;

/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class Curso 
{
   private String nombre;
   private Profesor profesor;
   private Hashtable<Integer,Alumno> alumnos;
   private int cantAlumnos;
   /*hay que ver si lo usamos o que, porque si no hay algo que no funciona aquí*/
   //private ArrayList<String> nombreHabilidades;
   //private int cantHabilidades

    /*constructores: igual lo cambiamos luego*/
    public Curso() 
    {
        this.nombre = "Nombre";
        this.profesor = new Profesor();
        this.alumnos = new Hashtable<>();
        this.cantAlumnos = 0;
        //this.nombreHabilidades = new ArrayList<>();
    }
    
    /*Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters*/
    public void setNombre (String newNombre)
    {
    	this.nombre = newNombre;
    }
    public void setProfesor (Profesor newProfesor)
    {
    	this.profesor = newProfesor;
    }
    public void setCantAlumnos (int cantidad)
    {
    	this.cantAlumnos = cantidad;
    }

    /*Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters*/
    public Hashtable<Integer,Alumno> getAlumnos()
    {
    	Hashtable<Integer,Alumno> copiaAlumnos = this.alumnos;
        return copiaAlumnos;
    }
    public String getNombre()
    {
    	return nombre;
    }
    public Profesor getProfesor()
    {
    	Profesor copiaProfesor = this.profesor;
    	return copiaProfesor;
    }
    public String getNombreAlumno_RUN(int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	return alumno.getNombre();
    }
    
    public ArrayList<Habilidades> getHabilidadesAlumno_RUN(int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	alumno.getHabilidades();
    	//mira, lo comentado de abajo... no se por qué está ahí, así que lo voy a comentar y de ahí lo veo
    	//alumno.mostrarHabilidades();//cambiar para Habilidades.java
    	return alumno.getHabilidades();
    }
    
    public int getCantAlumnos() 
    {
        return cantAlumnos;
    }
    public String getNombreCurso() 
    {
        return nombre;
    }
    public ArrayList<String> getNombreHabilidades()
    {
    	/*esto asume que todos los alumnos tienen los mismos nombres en las habilidades, por tanto esto se saca del primero que encuentre*/
    	Enumeration<Integer> enu = this.getAlumnos().keys();
    	Alumno alumnoTemp = this.alumnos.get(enu.nextElement());
    	return alumnoTemp.getNombreHabilidades();
    }
    
    // Métodos (funciones)
    /*para agrergar un alumno con los datos separados, puede que no queramos esto*/
    public boolean agregarAlumno (String nombre, int run, ArrayList<Habilidades> habilidades)
    {
    	Alumno nuevo = new Alumno();
    	nuevo.setNombre(nombre);
    	nuevo.setRUN(run);
    	nuevo.setHabilidades(habilidades);
    	this.alumnos.put(run, nuevo);
    	this.cantAlumnos += 1;
    	return true;
    }
    
    /*para cuando se quiera agregar un objeto alumno al hashtable*/
    public boolean agregarAlumno (Alumno alumno)
    {
    	//System.out.println("Nombre: " + alumno.getNombre() + "\nRun: "+alumno.getRUN()+"\nEstado Habilidades: ");
    	//alumno.mostrarHabilidades();
    	//System.out.println("\n");
    	this.alumnos.put(alumno.getRUN(), alumno);
    	this.cantAlumnos += 1;
    	return true;
    }
    
    /*para retornar un alumno del hashtable cuando se le da un run*/
    /*lo podríamos usar para alterar datos de un alumno específico, requiere experimentación*/
    //IGUAL ESTO DEBERÍA LLAMARSE getAlumno SOLO DIGO EH????
    public Alumno buscarAlumno(int run)
    {
    	Alumno copiaAlumno = this.alumnos.get(run);
    	return copiaAlumno;
    }
    
    public Alumno mostrarDatosAlumno (int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	return alumno;
    }
    
    //funciones de importacion
    
    /*importa un alumno de una línea de texto previamente separada, también la podríamos separar ahí mismo tambien te digo*/
    public boolean importarAlumno (ArrayList<String> nombreHabilidades, String[] textoSeparado)
    {
    	Alumno alumnoTemp = new Alumno();
    	ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
    	int cont = 0;
    	int posInicial = 2;
    	while(posInicial < textoSeparado.length || cont < nombreHabilidades.size())
		{
    		Habilidades habTemp = new Habilidades();
    		habTemp.setNombre(nombreHabilidades.get(cont));
    		try
            {
            	habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
            }
            catch (ArrayIndexOutOfBoundsException exception)
            {
            	//System.out.println("entra en la excepcion");
            	habTemp.setEstado(false);
            }
    		habilidadesTemp.add(habTemp);
			posInicial += 1;
			cont += 1;
		}
		alumnoTemp.setHabilidades(habilidadesTemp);
		alumnoTemp.setNombre(textoSeparado[0]);
		if (textoSeparado[0].equals("*****") == true || textoSeparado[0].equals("—————"))
		{
			//esto es por si ocurre que el nombre es igual al fin de línea o algo así
			//igual este no es lugar para ponerlo pero bueno
		}
		alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));

		//se asegura que el run sea válido, el proceso se corta en caso de no ser así
		/*Pasar a Try Catch
		if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
		{
			System.out.println("RUT inválido o repetido, cancelando la importación del alumno");
			return;
		}
		*/
		//alumnoTemp.mostrarDatos();
        //alumnoTemp.mostrarHabilidades();
        
        this.agregarAlumno(alumnoTemp);
        this.cantAlumnos += 1;
		//System.out.println("Importación realizada con éxito\n");
		return true;
    }
    
    //HAY QUE HACER LAS EXCEPCIONES DE ESTO
    public void importarProfesor (String[] textoSeparado)
    {
    	Profesor newProfesor = new Profesor();
    	
    	//EXCEPCIONES
    	newProfesor.setNombre(textoSeparado[0]);
    	newProfesor.setRUN(Integer.parseInt(textoSeparado[1]));
    	newProfesor.setEdad(Integer.parseInt(textoSeparado[2]));
    	newProfesor.setMateriaPrincipal(textoSeparado[3]);
    	newProfesor.setAnyosEnsenyando(Integer.parseInt(textoSeparado[4]));
    	newProfesor.setCalidad(Integer.parseInt(textoSeparado[5]));
    	//ACUERDATE ME CAGO EN DIOS
    	
    	this.setProfesor(newProfesor);
    }
    
    //parametros de entrada invertido
    public boolean importarAlumno (String[] textoSeparado, ArrayList<String> nombreHabilidades)
    {
        Alumno alumnoTemp = new Alumno();
        ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
        int cont = 0;
        int posInicial = 2;
        while(posInicial < textoSeparado.length || cont < nombreHabilidades.size())
        {
            Habilidades habTemp = new Habilidades();
            habTemp.setNombre(nombreHabilidades.get(cont));
            try
            {
            	habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
            }
            catch (ArrayIndexOutOfBoundsException exception)
            {
            	habTemp.setEstado(false);
            }
            
            habilidadesTemp.add(habTemp);
            posInicial += 1;
            cont += 1;
        }
        alumnoTemp.setHabilidades(habilidadesTemp);
        alumnoTemp.setNombre(textoSeparado[0]);
        alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));

        //se asegura que el run sea válido, el proceso se corta en caso de no ser así
        /* pasar a try catch
        if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
        {
            System.out.println("RUN inválido o repetido, cancelando la importación del alumno");
            return;
        }
        */
        //alumnoTemp.mostrarDatos();
        //alumnoTemp.mostrarHabilidades();
        
        this.agregarAlumno(alumnoTemp);
        this.cantAlumnos += 1;
        //System.out.println("Importación realizada con éxito\n");
        return true;
    }
    
    public void updateFile (File file, FileWriter fileWriter, PrintWriter printWriter, Enumeration<Integer> enu)
    {
    	//No sabía como hacer esto para actualizar los cursos cuando no tienen a ningún alumno sin hacer esto
    	//vaya solución más fea tio...
    	int rutPrueba;
    	try
		{
    		rutPrueba = enu.nextElement();
		}
		catch (NoSuchElementException exception)
		{
			printWriter.write(this.getNombreCurso());
			return;
		}
    	
    	Alumno alumnoTemp = this.buscarAlumno(rutPrueba);
    	ArrayList<Habilidades> habilidadesTemp = alumnoTemp.getHabilidades();
    	
    	//asumiendo que las habilidades en todos son iguales se usan los nombres que tenga el primero para la primera linea
    	printWriter.write(this.getNombreCurso());
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		printWriter.write(",");
    		printWriter.write(habilidadesTemp.get(contHab).getNombre());
    	}
    	printWriter.write("\n");
    	
    	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN());
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		printWriter.write(",");
    		printWriter.write(String.valueOf(habilidadesTemp.get(contHab).getEstado()));
    	}
    	
        while (enu.hasMoreElements())
        {
        	alumnoTemp = this.buscarAlumno(enu.nextElement());
        	habilidadesTemp = alumnoTemp.getHabilidades();
        	printWriter.write("\n");
        	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN());
        	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
        	{
        		printWriter.write(",");
        		printWriter.write(String.valueOf(habilidadesTemp.get(contHab).getEstado()));
        	}
        }
    }
    
    // Boolean, True si lo encuentra y false sino
    /* A ver, hay que hacer cosas aquí,
     * Posibilidad posibiladosa: que en el main se busque todo, y que esto solo reciba el rut y la habilidad que se quiera
     * cambiar, para que así esta función no imprima nada y solo cambie el estado, el main mostrará las habilidades y tal
     * */
    public void cambiarEstadoHabilidadesAlumno (int rut, String inputUsuario, BufferedReader lector) throws IOException
    {
    	Alumno alumnoTemp = this.alumnos.get(rut);
    	
    	/* pasar al main
    	if (alumnoTemp == null)
    	{
    		System.out.println("No se ha encontrado un alumno con el RUT especificado");
    		return;
    	}*/
    	//alumnoTemp.mostrarHabilidades();
    	// Pasar al main la pregunta, el método debe recibir el número
    	//System.out.println("¿Cuál de estas habilidades desea cambiar? (ingrese un número asumiendo que la primera es 0)");
    	inputUsuario = lector.readLine();
    	
    	Habilidades habilidadTemp = alumnoTemp.getHabilidades().get(Integer.parseInt(inputUsuario));
    	
    	if (habilidadTemp.getEstado() == true)
    	{
    		habilidadTemp.setEstado(false);
    	}
    	else
    	{
    		habilidadTemp.setEstado(true);
    	}
    }
    
    //podríamos pasarle un número a la mierda esta para indicar si queremos que retorne los aprobados o los reprobados
    //solo habría que hacer otra lista más y guardar los reprobados en ella y retornar la indicada
    public ArrayList<Alumno> alumnosAprobados ()
    {
    	ArrayList<Alumno> aprobados = new ArrayList<>();
    	if (this.alumnos.size() < 1)
    	{
    		return aprobados;
    	}
    	Enumeration<Integer> enu = this.getAlumnos().keys();
    	Alumno alumnoTemp = this.buscarAlumno(enu.nextElement());

    	while (alumnoTemp != null)
    	{
    		//creo que esta línea de acá no importa... pero me da miedo sacarla
    		alumnoTemp.getAprobado();
    		
    		if (alumnoTemp.getAprobado() == true)
    		{
    			aprobados.add(alumnoTemp);
    		}
    		
    		try
    		{
    			alumnoTemp = this.buscarAlumno(enu.nextElement());
    		}
    		catch (NoSuchElementException exception)
    		{
    			break;
    		}
    	}
    	
    	return aprobados;
    }
}