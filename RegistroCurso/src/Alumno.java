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
public class Alumno 
{
    private String nombre;
    private int run;            /*asegurarse que el rut sea válido, pero que no rompa con el proceso de agregar alumnos*/
    private ArrayList<Boolean> habilidades;
    /*lo de las habilidades, se supone que serán listas????????*/
    /*numero de habilidades aprendidas y numero de habilidades requeridas*/
    
    /*igual poner asignaturas para ver cuantas se van a aprovar, o tipo que asignaturas tengan las habiliades dentro*/
    /*ni cagando eso funciona*/
    
    /*constructores: igual lo cambiamos luego*/
    public Alumno() 
    {
        this.nombre = "José Antonio";
        this.run = 0;
        this.habilidades = new ArrayList<>();
    }
    /*hay que hacer una wea para que los ruts sean válidos
    * revisar casos en los que sean el último dígito sea k
    * (podríamos aplicar la fórmula también)
    * (o podemos no pedir dígito verificador uwu)
    */
   
    /*getters*/
    public String getNombre() 
    {
        return nombre;
    }
    public int getRUN() 
    {
        return run;
    }
    public ArrayList<Boolean> getHabilidades() 
    {
        return habilidades;
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
    public void setHabilidades(ArrayList<Boolean> habilidades)
    {
        this.habilidades = habilidades;
    }
    //toggleHabilidad -> cambie una habilidad i entre True y False
}