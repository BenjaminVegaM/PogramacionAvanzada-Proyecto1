/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
import java.util.*;

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
    	ArrayList<Habilidades> copiaHabilidades = this.habilidades;
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
    public boolean getEstadoHabilidad (int index)
    {
        return this.habilidades.get(index).getEstado();
    }
    
    //Métodos
    public void cambiarEstadoHabilidad (int index)
    {
    	if (this.habilidades.get(index).getEstado() == true)
    	{
    		this.habilidades.get(index).setEstado(false);
    	}
    	else
    	{
    		this.habilidades.get(index).setEstado(true);
    	}
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

    public void editarAlumno (String nuevoNombreAlumno, int nuevaEdad)
	{
    	this.setNombre(nuevoNombreAlumno);
    	this.setEdad(nuevaEdad);
	}
    
    //Sobreescribe al getInfo() de la clase Persona
    public String getInfo()
    {
    	String aprovado;
    	if(this.aprobado)
    	{
    		aprovado = "aprovado";
    	}
    	else
    	{
    		aprovado = "repitiendo";
    	}
    	return this.getNombre() +"de R.U.N. "+ this.getRUN() +" es un alumno que tiene "+ this.getEdad() +" años y está "+ aprovado +".";
    }
}