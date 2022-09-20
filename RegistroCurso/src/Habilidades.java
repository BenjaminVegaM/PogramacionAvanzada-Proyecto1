/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class Habilidades 
{
    private String nombre;
    private boolean estado = false;
    
    /*le queremos poner nombre de asignatura???*/

    /*constructores: igual lo cambiamos luego*/
    public Habilidades()
    {
    	this.nombre = "Habilidad";
    	this.estado = false;
    }

    /*getters*/
    public String getNombre() 
    {
        return this.nombre;
    }
    public boolean getEstado() 
    {
        return this.estado;
    }

    /*setters*/
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public void setEstado(boolean conseguido) 
    {
        this.estado = conseguido;
    }
}