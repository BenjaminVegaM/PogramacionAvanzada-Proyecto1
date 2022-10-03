public class Persona
{
	private String nombre;
	private int run;
	private int edad;
	
	public Persona() 
	{
		this.nombre = "Nombre Apellido";
		this.run = 0;
	}
	
	// Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters
	public void setNombre(String newNombre)
	{
		this.nombre = newNombre;
	}
	public void setRUN(int newRUN)
	{
		this.run = newRUN;
	}
	public void setEdad(int newEdad)
	{
		this.edad = newEdad;
	}
	
	// Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters
	public String getNombre()
	{
		return this.nombre;
	}
	public int getRUN()
	{
		return this.run;
	}
	public int getEdad()
	{
		return this.edad;
	}

	// Métodos
	public String getInfo()
	{
		return nombre +"de R.U.N. "+ run +" tiene "+edad+"años.";
	}
}
