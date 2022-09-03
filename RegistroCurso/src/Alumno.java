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
    private int run;            /*asegurarse que el rut sea válido, pero que no rompa con el proceso de agregar alumnos*/
    //private ArrayList<Boolean> habilidades;
    private ArrayList<Habilidades> habilidades;
    /*numero de habilidades aprendidas y numero de habilidades requeridas*/
    
    /*igual poner asignaturas para ver cuantas se van a aprovar, o tipo que asignaturas tengan las habiliades dentro*/
    /*ni cagando eso funciona*/
    
    /*constructores: igual lo cambiamos luego*/
    public Alumno() 
    {
        this.nombre = "José Antonio";
        this.run = 0;
        this.habilidades = null;
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
    public ArrayList<Habilidades> getHabilidades() 
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
    public void setHabilidades(ArrayList<Habilidades> habilidades)
    {
        this.habilidades = habilidades;
    }
    //toggleHabilidad -> cambie una habilidad i entre True y False
    
    //funciones
    /*para mostrar el estado de las habilidades de un estudiante*/
    public void mostrarHabilidades()
    {
    	//System.out.print("El estado de las habilidades es: ");
    	String estadoHab = "a";
    	for (int index = 0 ; index < this.habilidades.size() ; index += 1)
    	{
    		if  (this.habilidades.get(index).getEstado()== true)
			{
				estadoHab = "conseguido";
    		}
    		else 
    		{
    			estadoHab = "pendiente";
    		}
 
    		System.out.println(this.habilidades.get(index).getNombre()+": "+ estadoHab);
    	}
    	
    	System.out.println("\n");
    }
    
    /*muestra el nombre y el rut de un estudiante*/
    public void mostrarDatos()
    {
    	System.out.println("\nNombre: "+ this.nombre);
    	System.out.println("RUN: "+ this.run);
    }
}