/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

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
   //private int cantHabilidades;

    /*constructores: igual lo cambiamos luego*/
    public Curso() 
    {
        this.nombre = "Nombre";
        this.alumnos = new Hashtable<>();
        this.cantAlumnos = 0;
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
    	System.out.println("Nombre: " + alumno.getNombre() + "\nRut: "+alumno.getRUN()+"\nEstado Habilidades: ");
    	alumno.mostrarHabilidades();
    	System.out.println("\n");
    	this.alumnos.put(alumno.getRUN(), alumno);
    }
    
    /*para retornar un alumno del hashtable cuando se le da un rut*/
    /*lo podríamos usar para alterar datos de un alumno específico, requiere experimentación*/
    public Alumno buscarAlumno(int run)
    {
    	return this.alumnos.get(run);
    }
    
    /*cuando se quiera mostrar los datos de un alumno buscándolo por rut*/
    public void mostrarDatosAlumno (int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	System.out.println("Nombre: " + alumno.getNombre() + "\nRut: "+alumno.getRUN()+"\nEstado Habilidades: ");
    	alumno.mostrarHabilidades();//cambiar para Habilidades.java
    }
    
    //funciones de importacion
    
    /*importa un alumno de una línea de texto previamente separada, también la podríamos separar ahí mismo tambien te digo*/
    public void importarAlumno (String[] textoSeparado, int posInicial, ArrayList<String> nombreHabilidades)
    {
    	Alumno alumnoTemp = new Alumno();
    	ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
    	int cont = 0;
    	while(posInicial < textoSeparado.length)
		{
    		Habilidades habTemp = new Habilidades();
    		habTemp.setNombre(nombreHabilidades.get(cont));
    		habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
    		habilidadesTemp.add(habTemp);
			posInicial += 1;
			cont += 1;
		}
		alumnoTemp.setHabilidades(habilidadesTemp);
		alumnoTemp.setNombre(textoSeparado[0]);
		alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));

		//se asegura que el rut sea válido, el proceso se corta en caso de no ser así
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
        while(posInicial < textoSeparado.length)
        {
            Habilidades habTemp = new Habilidades();
            habTemp.setNombre(nombreHabilidades.get(cont));
            habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
            habilidadesTemp.add(habTemp);
            posInicial += 1;
            cont += 1;
        }
        alumnoTemp.setHabilidades(habilidadesTemp);
        alumnoTemp.setNombre(textoSeparado[0]);
        alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));

        //se asegura que el rut sea válido, el proceso se corta en caso de no ser así
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
}