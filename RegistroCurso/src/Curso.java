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
   private Hashtable<Integer,Alumno> alumnos;
   private int cantAlumnos;
   /*hay que ver si lo usamos o que, porque si no hay algo que no funciona aquí*/
   //private ArrayList<String> nombreHabilidades;
   //private int cantHabilidades

    /*constructores: igual lo cambiamos luego*/
    public Curso() 
    {
        this.nombre = "Nombre";
        this.alumnos = new Hashtable<>();
        this.cantAlumnos = 0;
        //this.nombreHabilidades = new ArrayList<>();
    }

    /*getters*/
    public Hashtable<Integer,Alumno> getAlumnos()
    {
        return alumnos;
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
    
    //Setters
    public void setNombre (String nombre)
    {
    	this.nombre = nombre;
    }
    public void setCantAlumnos (int cantidad)
    {
    	this.cantAlumnos = cantidad;
    }
    
    // Métodos (funciones)
    /*para agrergar un alumno con los datos separados, puede que no queramos esto*/
    public void agregarAlumno (String nombre, int run, ArrayList<Habilidades> habilidades)
    {
    	Alumno nuevo = new Alumno();
    	nuevo.setNombre(nombre);
    	nuevo.setRUN(run);
    	nuevo.setHabilidades(habilidades);
    	this.alumnos.put(run, nuevo);
    }
    
    /*para cuando se quiera agregar un objeto alumno al hashtable*/
    public void agregarAlumno (Alumno alumno)
    {
    	System.out.println("Nombre: " + alumno.getNombre() + "\nRun: "+alumno.getRUN()+"\nEstado Habilidades: ");
    	alumno.mostrarHabilidades();
    	System.out.println("\n");
    	this.alumnos.put(alumno.getRUN(), alumno);
    }
    
    /*para retornar un alumno del hashtable cuando se le da un run*/
    /*lo podríamos usar para alterar datos de un alumno específico, requiere experimentación*/
    public Alumno buscarAlumno(int run)
    {
    	return this.alumnos.get(run);
    }
    
    /*cuando se quiera mostrar los datos de un alumno buscándolo por run*/
    public void mostrarDatosAlumno (int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	System.out.println("Nombre: " + alumno.getNombre() + "\nRun: "+alumno.getRUN()+"\nEstado Habilidades: ");
    	alumno.mostrarHabilidades();//cambiar para Habilidades.java
    }
    
    //funciones de importacion
    
    /*importa un alumno de una línea de texto previamente separada, también la podríamos separar ahí mismo tambien te digo*/
    public void importarAlumno (String[] textoSeparado, int posInicial, ArrayList<String> nombreHabilidades)
    {
    	Alumno alumnoTemp = new Alumno();
    	ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
    	int cont = 0;
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
            	System.out.println("entra en la excepcion");
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
		if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
		{
			System.out.println("RUT inválido o repetido, cancelando la importación del alumno");
			return;
		}
		
		alumnoTemp.mostrarDatos();
		alumnoTemp.mostrarHabilidades();
		
		this.alumnos.put(alumnoTemp.getRUN(),alumnoTemp);
		System.out.println("Importación realizada con éxito\n");
    }
    //parametros de entrada invertido
    public void importarAlumno (int posInicial, String[] textoSeparado, ArrayList<String> nombreHabilidades)
    {
        Alumno alumnoTemp = new Alumno();
        ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
        int cont = 0;
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
        if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
        {
            System.out.println("RUN inválido o repetido, cancelando la importación del alumno");
            return;
        }
        
        alumnoTemp.mostrarDatos();
        alumnoTemp.mostrarHabilidades();
        
        this.alumnos.put(alumnoTemp.getRUN(),alumnoTemp);
        System.out.println("Importación realizada con éxito\n");
    }
    
    /**/
    public void updateFile (File file, FileWriter fileWriter, PrintWriter printWriter,
    						Enumeration<Integer> enu)
    {
    	Alumno alumnoTemp = this.buscarAlumno(enu.nextElement());
    	ArrayList<Habilidades> habilidadesTemp = alumnoTemp.getHabilidades();
    	
    	/*asumiendo que las habilidades en todos son iguales se usan los nombres que tenga el primero para la primera linea*/
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
    
    public void cambiarEstadoHabilidadesAlumno (int rut, String inputUsuario, BufferedReader lector) throws IOException
    {
    	Alumno alumnoTemp = this.alumnos.get(rut);
    	alumnoTemp.mostrarHabilidades();
    	System.out.println("¿Cuál de estas habilidades desea cambiar? (ingrese un número asumiendo que la primera es 0)");
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
}