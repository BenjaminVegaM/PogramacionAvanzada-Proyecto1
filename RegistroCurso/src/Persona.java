import java.util.ArrayList;

public class Persona {
	private String nombre;
	private int run;           						 /*asegurarse que el run sea válido, pero que no rompa con el proceso de agregar alumnos*/
	private int edad;
	
	public Persona() 
	{
		this.nombre = "Nombre Apellido";
		this.run = 0;
	}
	
	// Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters
		public void setNombre(String s)
		{
			this.nombre = s;
		}
		public void setRUN(int i)
		{
			this.run = i;
		}
		public void setEdad(int i)
		{
			this.edad = i;
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
}
