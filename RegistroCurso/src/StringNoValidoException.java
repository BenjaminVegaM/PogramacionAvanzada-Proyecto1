/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class StringNoValidoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StringNoValidoException ()
	{
		super("Input inválido: Solo se permiten números");
	}
}
