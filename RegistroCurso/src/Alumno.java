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
public class Alumno extends Persona
{
    private ArrayList<Habilidades> habilidades;
    private boolean aprobado;

    public Alumno() 
    {
        super();
        this.habilidades = new ArrayList<>();
        this.aprobado = false;
    }
    
	// Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters
    public void setHabilidades(ArrayList<Habilidades> habilidades)
    {
        this.habilidades = habilidades;
    }
    public void setAprobado (boolean aprobado)
    {
    	this.aprobado = aprobado;
    }
    
	// Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters
    public boolean getAprovacion()
    {
    	return this.aprobado;
    }
    public ArrayList<Habilidades> getHabilidades() 
    {
    	//REVISAR
    	ArrayList<Habilidades> copiaHabilidades = (ArrayList) habilidades.clone();
        return copiaHabilidades;
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

    //toggleHabilidad -> cambie una habilidad i entre True y False
    
    //funciones
    /*para mostrar el estado de las habilidades de un alumno*/
    
    // solo MAIN debe tener System IO----------------------------------------------------------
    public String mostrarHabilidades(int index)
    {
    	String estadoHab = "a"; 
    	
    	//for (int index = 0 ; index < this.habilidades.size() ; index += 1)
    	//{
    		if  (this.habilidades.get(index).getEstado() == true)
			{
				estadoHab = "Conseguido";
    		}
    		else 
    		{
    			estadoHab = "Pendiente";
    		}
    		
    		//System.out.println(this.habilidades.get(index).getNombre()+": "+ estadoHab);
    	//}
    	return estadoHab;
    	//System.out.println("\n");
    }
    
    /*muestra el nombre y el run de un alumno*/
    
    public void mostrarDatos()
    {
    	System.out.println("\nNombre: "+ this.getNombre());
    	System.out.println("RUN: "+ this.getRUN());
    }
    public Alumno crearAlumno(String nombre, int run)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.setNombre(nombre);
    	this.setRUN(run);
    	return nuevoAlumno;
    }
    public Alumno crearAlumno(int run, String nombre)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.setNombre(nombre);
    	this.setRUN(run);
    	return nuevoAlumno;
    }
    public Alumno crearAlumno(String nombre, int run, ArrayList<Habilidades> habilidades)
    {
    	Alumno nuevoAlumno = new Alumno();
    	this.setNombre(nombre);
    	this.setRUN(run);
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