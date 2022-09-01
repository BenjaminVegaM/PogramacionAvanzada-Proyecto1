/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecto1;
import java.util.*;

/**
 *
 * @author pablo
 */
public class Curso 
{
   private String nombre;
   private ArrayList<Alumno> alumnos;
   private int cantAlumnos;

    /*constructores: igual lo cambiamos luego*/
    public Curso(String nombre) 
    {
        this.nombre = nombre;
    }
    public Curso(ArrayList<Alumno> alumnos) 
    {
        this.alumnos = alumnos;
    }
    public Curso(int cantAlumnos) 
    {
        this.cantAlumnos = cantAlumnos;
    }

    /*getters*/
    public ArrayList<Alumno> getAlumnos()
    {
        return alumnos;
    }
    public int getCantAlumnos() 
    {
        return cantAlumnos;
    }
    public String getNombre() 
    {
        return nombre;
    }
    
    /*igual función para leer de un .txt???*/
   
}
