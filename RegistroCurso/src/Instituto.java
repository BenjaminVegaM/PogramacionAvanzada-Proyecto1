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
    	return this.cursos.get(i).getNombreHabilidades();
    }
	public int getTamaño()
	{
		return this.cursos.size();
	}
	public String getNombreProfesorCurso (int i)
	{
	  return this.cursos.get(i).getNombreProfesor();
	}
	public int getEdadProfesorCurso (int i)
	{
	  return this.cursos.get(i).getEdadProfesor();
	}
	public int getRUNProfesorCurso (int i)
	{
	  return this.cursos.get(i).getRUNProfesor();
	}
	public String getMateriaProfesorCurso(int i)
    {
    	return this.cursos.get(i).getMateriaProfesor();
    }

	/*métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos----------métodos*/
	public int getPorcentajeAprobacionCurso (int i)
	{
		return this.cursos.get(i).getPorcentajeAprobacion();
	}
	public boolean importarAlumno(int i, String[] textoSeparado, ArrayList<String> nombreHabilidades) throws ImportarAlumnosException
	{
		boolean resultado = this.cursos.get(i).importarAlumno(textoSeparado, nombreHabilidades);
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
		this.cursos.get(index).cambiarEstadoHabilidadesAlumno(rut, inputUsuario);
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
		this.cursos.get(indiceCurso).cambiarEstadoHabilidadesAlumnoIndice(nombreAlumno, indiceHabilidad);
    }
	public boolean getEstadoHabilidad (int indiceCurso, String nombreAlumno, int indiceHabilidad)
    {
        return this.cursos.get(indiceCurso).getEstadoHabilidad(nombreAlumno, indiceHabilidad);
    }
	public String getNombreAlumno(int indiceCurso, String nombreAlumno)
	{
		return this.cursos.get(indiceCurso).getNombreAlumno(nombreAlumno);
	}
	public int getEdadAlumno(int indiceCurso, String nombreAlumno)
	{
		return this.cursos.get(indiceCurso).getEdadAlumno(nombreAlumno);
	}
	public int getRUNAlumno(int indiceCurso, String nombreAlumno)
	{
		return this.cursos.get(indiceCurso).getRUNAlumno(nombreAlumno);
	}
	public void editarAlumno (int indiceCurso, String viejoNombreAlumno, String nuevoNombreAlumno, int nuevaEdad)
	{
		this.cursos.get(indiceCurso).editarAlumno(viejoNombreAlumno, nuevoNombreAlumno, nuevaEdad);
	}
	public void editarNombreCurso(int indiceCurso, String nuevoNombre)
	{
		this.cursos.get(indiceCurso).setNombre(nuevoNombre);
	}
	public void eliminarAlumnoCursoNombre (int indiceCurso, String nombreAlumno)
	{
		this.cursos.get(indiceCurso).eliminarAlumnoNombre(nombreAlumno);
	}
}