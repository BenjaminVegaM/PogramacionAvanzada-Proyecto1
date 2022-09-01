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
public class Alumno 
{
    private String nombre;
    private int rut;            /*asegurarse que el rut sea válido, pero que no rompa con el proceso de agregar alumnos*/
    private ArrayList<Habilidades> habilidades;
    /*lo de las habilidades, se supone que serán listas????????*/
    /*numero de habilidades aprendidas y numero de habilidades requeridas*/
    
    /*igual poner asignaturas para ver cuantas se van a aprovar, o tipo que asignaturas tengan las habiliades dentro*/
    /*ni cagando eso funciona*/
    
    /*constructores: igual lo cambiamos luego*/
    public Alumno(String nombre) 
    {
        this.nombre = nombre;
    }
    /*hay que hacer una wea para que los ruts sean válidos
    * revisar casos en los que sean el último dígito sea k
    * (podríamos aplicar la fórmula también)
    * (o podemos no pedir dígito verificador uwu)
    */
    public Alumno(int rut) 
    {
        this.rut = rut;
    }
    public Alumno(ArrayList<Habilidades> habilidades) 
    {
        this.habilidades = habilidades;
    }
    

    /*getters*/
    public String getNombre() 
    {
        return nombre;
    }
    public int getRut() 
    {
        return rut;
    }
    public ArrayList<Habilidades> getHabilidades() 
    {
        return habilidades;
    } 
    
}
