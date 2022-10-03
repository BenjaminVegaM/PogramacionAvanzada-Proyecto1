/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class Habilidades 
{
    private String nombre;
    private boolean estado = false;

    public Habilidades()
    {
    	this.nombre = "Habilidad";
    	this.estado = false;
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
    
    /*getters*/
    public String getNombre() 
    {
        return this.nombre;
    }
    public boolean getEstado() 
    {
        return this.estado;
    }
}