import java.util.ArrayList;
import java.util.Enumeration;

public class Instituto {
	private String nombre;
	private ArrayList<Curso> cursos;
	
	public Instituto()
	{
		this.nombre = "Nombre";
		this.cursos = new ArrayList<>();
		
	}
	
    /*Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters*/
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	/*Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters*/
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getNumeroCursos()
	{
		return this.cursos.size();
	}

	
	public String getNombreCurso(int i)
	{
		return this.cursos.get(i).getNombre();
	}
	
	public boolean addCurso(Curso curso)
	{
		return this.cursos.add(curso);
	}
	
	//cursos.get(cont).getNombreHabilidades()
	public ArrayList<String> getNombreHabilidadesCurso(int i)
    {
    	return cursos.get(i).getNombreHabilidades();
    }
	
	public boolean importarAlumno(int i, String[] textoSeparado, ArrayList<String> nombreHabilidades)
	{
		return cursos.get(i).importarAlumno(textoSeparado, nombreHabilidades);
	}
	
	//cursos.get(cont).importarAlumno(2, lineaLeida, cursos.get(cont).getNombreHabilidades());
	
}