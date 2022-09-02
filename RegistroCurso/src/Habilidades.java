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
    /*le queremos poner nombre de asignatura???*/
    private boolean conseguido;

    /*constructores: igual lo cambiamos luego*/
    public Habilidades(String nombre) 
    {
        this.nombre = nombre;
    }
    public Habilidades(boolean conseguido) 
    {
        this.conseguido = conseguido;
    }

    /*getters*/
    public String getNombre() 
    {
        return nombre;
    }
    public boolean isConseguido() 
    {
        return conseguido;
    }
}