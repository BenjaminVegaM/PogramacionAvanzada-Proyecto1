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
public class Alumno 
{
    private String nombre;
    private int run;           						 /*asegurarse que el run sea válido, pero que no rompa con el proceso de agregar alumnos*/
    private ArrayList<Habilidades> habilidades;
    private boolean aprobado;
    
    /*constructores: igual lo cambiamos luego*/
    public Alumno() 
    {
        this.nombre = "José Antonio";
        this.run = 0;
        this.habilidades = new ArrayList<>();
        this.aprobado = false;
    }
   
    /*getters*/
    public String getNombre() 
    {
        return nombre;
    }
    public int getRUN() 
    {
        return run;
    }
    public ArrayList<Habilidades> getHabilidades() 
    {
    	ArrayList<Habilidades> copia = new ArrayList();
    	while(this.habilidades.)
        return habilidades;
    }
    public ArrayList<String> getNombreHabilidades()
    {
    	ArrayList<String> nombreHabilidades = new ArrayList<String>();
    	for (int cont = 0; cont < this.habilidades.size(); cont += 1)
    	{
    		nombreHabilidades.add(this.habilidades.get(cont).getNombre());
    	}
    	return nombreHabilidades;
    }
    public boolean getAprobado()
    {
    	boolean reprobado = false;
    	for (int cont = 0; cont < this.getHabilidades().size(); cont += 1)
		{
			if (this.getHabilidades().get(cont).getEstado() == false)
			{
				reprobado = true;
				break;
			}
		}
    	
    	if (reprobado == true)
    	{
    		this.aprobado = false;
    	}
    	else
    	{
    		this.aprobado = true;
    	}
    	
    	return this.aprobado;
    }
    
    // Setters
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setRUN(int run)
    {
        this.run = run;
    }
    public void setHabilidades(ArrayList<Habilidades> habilidades)
    {
        this.habilidades = habilidades;
    }
    public void setAprobado (boolean aprobado)
    {
    	this.aprobado = aprobado;
    }
    //toggleHabilidad -> cambie una habilidad i entre True y False
    
    //funciones
    /*para mostrar el estado de las habilidades de un alumno*/
    
    // solo MAIN debe tener System IO----------------------------------------------------------
    /*public void mostrarHabilidades()
    {
    	String estadoHab = "a";
    	for (int index = 0 ; index < this.habilidades.size() ; index += 1)
    	{
    		if  (this.habilidades.get(index).getEstado() == true)
			{
				estadoHab = "Conseguido";
    		}
    		else 
    		{
    			estadoHab = "Pendiente";
    		}
 
    		System.out.println(this.habilidades.get(index).getNombre()+": "+ estadoHab);
    	}
    	
    	System.out.println("\n");
    }*/
    
    /*muestra el nombre y el run de un alumno*/
    /*
    public void mostrarDatos()
    {
    	System.out.println("\nNombre: "+ this.nombre);
    	System.out.println("RUN: "+ this.run);
    }*/
    public Alumno crearAlumno(String nombre, int run)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.nombre = nombre;
    	this.run = run;
    	return nuevoAlumno;
    }
    public Alumno crearAlumno(int run, String nombre)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.nombre = nombre;
    	this.run = run;
    	return nuevoAlumno;
    }
    public Alumno crearAlumno(String nombre, int run, ArrayList<Habilidades> habilidades)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.nombre = nombre;
    	this.run = run;
    	this.habilidades = habilidades;
    	return nuevoAlumno;
    }
    public void agregarHabilidad(String nombre, boolean estado)
    {
    	Habilidades nuevaHabilidad = new Habilidades();
    	nuevaHabilidad.setNombre(nombre);
    	nuevaHabilidad.setEstado(estado);
    	this.habilidades.add(nuevaHabilidad);
    }
    public void agregarHabilidad(boolean estado, String nombre)
    {
    	Habilidades nuevaHabilidad = new Habilidades();
    	nuevaHabilidad.setNombre(nombre);
    	nuevaHabilidad.setEstado(estado);
    	this.habilidades.add(nuevaHabilidad);
    }
    public void agregarHabilidad(Habilidades nuevaHabilidad)
    {
    	this.habilidades.add(nuevaHabilidad);
    }
}