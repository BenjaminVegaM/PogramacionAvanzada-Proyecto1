/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class Profesor extends Persona
{
	private String materiaPrincipal;
	private int anyosEnsenyando;
	private int calidad;

	public Profesor()
	{
		super();
		this.materiaPrincipal = "";
		this.anyosEnsenyando = 0;
		this.calidad = 0;
	}
	
	// Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters
	public void setMateriaPrincipal(String materiaPrincipal)
	{
		this.materiaPrincipal = materiaPrincipal;
	}
	public void setAnyosEnsenyando(int i)
	{
		this.anyosEnsenyando = i;
	}
	public void setCalidad(int i)
	{
		this.calidad = i;
	}
	
	// Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters
	public String getMateriaPrincipal()
	{
		return this.materiaPrincipal;
	}
	public int getAnyosEnsenyando()
	{
		return this.anyosEnsenyando;
	}
	public int getCalidad()
	{
		return this.calidad;
	}

	// Métodos
	public String getInfo()
	{
		return this.getNombre() +"de R.U.N. "+ this.getRUN() +" es un profesor que tiene "+ this.getEdad() +" años y ha enseñado "+ materiaPrincipal +" por "+ this.anyosEnsenyando +".";
	}
}
