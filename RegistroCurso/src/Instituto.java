import java.util.ArrayList;
import java.util.Enumeration;

public class Instituto
{
	private ArrayList<Curso> cursos;
	
	public Instituto()
	{
		this.cursos = new ArrayList<>();
	}
	
    /*Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters*/
	public void setProfesorCurso (int indiceCurso, Profesor newProfesor)
	{
		this.cursos.get(indiceCurso).setProfesor(newProfesor);
	}
	
	/*Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters*/
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
	public ArrayList<String> getNombreHabilidadesCurso(int i)
    {
    	return cursos.get(i).getNombreHabilidades();
    }
	public int getTamaño()
	{
		return cursos.size();
	}
	public Profesor getProfesorCurso (int i)
	{
	  return cursos.get(i).getProfesor();
	}
	public int getPorcentajeAprobacionCurso (int i)
	{
	    return this.cursos.get(i).getPorcentajeAprobacion();
	}

	/*métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos*/
	public boolean importarAlumno(int i, String[] textoSeparado, ArrayList<String> nombreHabilidades) throws ImportarAlumnosException
	{
		boolean resultado = cursos.get(i).importarAlumno(textoSeparado, nombreHabilidades);
		if (resultado == true)
		{
			return resultado;
		}
		else
		{
			throw new ImportarAlumnosException();
		}
	}
	public void cambiarEstadoHabilidadesAlumno (int index, int rut, int inputUsuario)
	{
		cursos.get(index).cambiarEstadoHabilidadesAlumno(rut, inputUsuario);
	}
	public Alumno buscarAlumno (int index, int rut)
	{
		return this.cursos.get(index).buscarAlumno(rut);
	}
	public boolean addCurso(Curso curso)
	{
		return this.cursos.add(curso);
	}
	public int cantidadAlumnosTotal()
	{
		int cantAlumnos = 0;
		for(int i = 0 ; i < this.getTamaño() ; i++)
		{
			cantAlumnos += this.getCantAlumnosCurso(i);
		}
		return cantAlumnos;
	}
	public boolean eliminarCurso(int index)
	{
		this.cursos.remove(index);
		return true;
	}
	public void cambiarEstadoHabilidadesAlumnoNombre (int indiceCurso, String nombreAlumno, int indiceHabilidad)
    {
        cursos.get(indiceCurso).cambiarEstadoHabilidadesAlumnoIndice(nombreAlumno, indiceHabilidad);
    }
	public boolean getEstadoHabilidad (int indiceCurso, String nombreAlumno, int indiceHabilidad)
    {
        return cursos.get(indiceCurso).getEstadoHabilidad(nombreAlumno, indiceHabilidad);
    }
	public void eliminarAlumnoCursoNombre (int indiceCurso, String nombreAlumno)
	{
		cursos.get(indiceCurso).eliminarAlumnoNombre(nombreAlumno);
	}
}