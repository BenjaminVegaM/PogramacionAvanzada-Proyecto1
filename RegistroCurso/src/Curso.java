/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author pablo
 */
public class Curso 
{
   private String nombre;
   private Hashtable<Integer,Alumno> alumnos;
   private ArrayList<String> nombreHabilidades;
   private int cantAlumnos;

    /*constructores: igual lo cambiamos luego*/
    public Curso() 
    {
        this.nombre = "Nombre";
        this.alumnos = new Hashtable<>();
        this.nombreHabilidades = new ArrayList<>();
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
    public void setNombre(String nombre)
    {
    	this.nombre = nombre;
    }
    public void setCantAlumnos(int cantidad)
    {
    	this.cantAlumnos = cantidad;
    }
    public void setNombreHabilidades(ArrayList<String> nombreHabilidades)
    {
    	this.nombreHabilidades = nombreHabilidades;
    }
    
    // Métodos (funciones)
    public void agregarEstudiante(String nombre, int run, ArrayList<Boolean> habilidades)
    {
    	Alumno nuevo = new Alumno();
    	nuevo.setNombre(nombre);
    	nuevo.setRUN(run);
    	nuevo.setHabilidades(habilidades);
    	this.alumnos.put(run, nuevo);
    }
    
    /*igual funciÃ³n para leer de un .txt???*/
   
}