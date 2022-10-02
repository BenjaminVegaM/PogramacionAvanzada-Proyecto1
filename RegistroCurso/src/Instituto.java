import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Instituto
{
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
	public Curso getCopiaCurso (int i)
	{
		Curso copiaCurso = this.cursos.get(i);
		return copiaCurso;
	}
	public String getNombreCurso(int i)
	{
		return this.cursos.get(i).getNombre();
	}
	public int getCantAlumnosCurso (int i)
	{
		return this.cursos.get(i).getAlumnos().size();
	}
	public Enumeration<Integer> getKeysAlumnosCurso (int i)
	{
		return this.cursos.get(i).getAlumnos().keys();
	}
	public Alumno getCopiaAlumnoCurso (int i, int key)
	{
		//ya retorna una copia en el buscarAlumno
		return this.cursos.get(i).buscarAlumno(key);
	}
	public ArrayList<Alumno> getAlumnosAprobadosCurso (int i)
	{
		return this.cursos.get(i).alumnosAprobados();
	}
	public boolean addCurso(Curso curso)
	{
		return this.cursos.add(curso);
	}
	public ArrayList<String> getNombreHabilidadesCurso(int i)
    {
    	return cursos.get(i).getNombreHabilidades();
    }
	public int getTamaño()
	{
		return cursos.size();
	}
	
	/*métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos*/
	public boolean importarAlumno(int i, String[] textoSeparado, ArrayList<String> nombreHabilidades)
	{
		return cursos.get(i).importarAlumno(textoSeparado, nombreHabilidades);
	}
	
	public void cambiarEstadoHabilidadesAlumno (int index, int rut, String inputUsuario, BufferedReader lector) throws IOException
	{
		cursos.get(index).cambiarEstadoHabilidadesAlumno(rut, inputUsuario, lector);
	}
	public Alumno buscarAlumno (int index, int rut)
	{
		return this.cursos.get(index).buscarAlumno(rut);
	}
	
	//cursos.get(cont).importarAlumno(2, lineaLeida, cursos.get(cont).getNombreHabilidades());
	
}