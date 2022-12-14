/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
import java.util.*;
import java.io.*;

public class Curso 
{
	private String nombre;
	private Profesor profesor;
	private Hashtable<Integer,Alumno> alumnos;

    public Curso() 
    {
        this.nombre = "Nombre";
        this.profesor = new Profesor();
        this.alumnos = new Hashtable<>();
    }
    
    /*Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters----------Setters*/
    public void setNombre (String newNombre)
    {
    	this.nombre = newNombre;
    }
    public void setProfesor (Profesor newProfesor)
    {
    	this.profesor = newProfesor;
    }

    /*Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters----------Getters*/
    public String getNombre()
    {
    	return this.nombre;
    }
    public String getNombreProfesor()
    {
    	return this.profesor.getNombre();
    }
    public int getEdadProfesor()
    {
    	return this.profesor.getEdad();
    }
    public int getRUNProfesor()
    {
    	return this.profesor.getRUN();
    }
    public String getMateriaProfesor()
    {
    	return this.profesor.getMateriaPrincipal();
    }
    public String getNombreAlumno_RUN(int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	return alumno.getNombre();
    }
    public Hashtable<Integer,Alumno> getAlumnos()
    {
    	Hashtable<Integer,Alumno> copiaAlumnos = this.alumnos;
        return copiaAlumnos;
    }
    public ArrayList<Habilidades> getHabilidadesAlumno_RUN(int run)
    {
    	Alumno alumno = this.alumnos.get(run);
    	alumno.getHabilidades();
    	return alumno.getHabilidades();
    }
    public int getCantAlumnos() 
    {
        return this.alumnos.size();
    }
    public String getNombreCurso() 
    {
        return this.nombre;
    }
    public ArrayList<String> getNombreHabilidades()
    {
    	/*esto asume que todos los alumnos tienen los mismos nombres en las habilidades, por tanto esto se saca del primero que encuentre*/
    	Enumeration<Integer> enu = this.getAlumnos().keys();
    	Alumno alumnoTemp = this.alumnos.get(enu.nextElement());
    	return alumnoTemp.getNombreHabilidades();
    }
    public int getPorcentajeAprobacion()
    {
    	//saca el porcentaje dependiendo de la cantidad de aprobados y la cantidad total de alumnos
    	if (this.alumnos.size() <= 0)
    	{
    		return 0;
    	}
        int cantAprobados = this.alumnosAprobados().size();
        int resultado = (cantAprobados*100)/(this.alumnos.size());
        return resultado;
    }
    public boolean agregarAlumno (String nombre, int run, ArrayList<Habilidades> habilidades)
    {
    	Alumno nuevo = new Alumno();
    	nuevo.setNombre(nombre);
    	nuevo.setRUN(run);
    	nuevo.setHabilidades(habilidades);
    	this.alumnos.put(run, nuevo);
    	return true;
    }
    public boolean agregarAlumno (Alumno alumno)
    {
    	this.alumnos.put(alumno.getRUN(), alumno);
    	return true;
    }
    
    public Alumno buscarAlumno(int run)
    {
    	Alumno copiaAlumno = this.alumnos.get(run);
    	return copiaAlumno;
    }

    //funciones de importacion
    /*importa un alumno de una línea de texto previamente separada*/
    public boolean importarAlumno (ArrayList<String> nombreHabilidades, String[] textoSeparado) throws ImportarAlumnosException
    {
    	Alumno alumnoTemp = new Alumno();
        ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
        int cont = 0;
        int posInicial = 3;
        while(cont < nombreHabilidades.size())
        {
            Habilidades habTemp = new Habilidades();
            habTemp.setNombre(nombreHabilidades.get(cont));
            try
            {
                habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
            }
            catch (ArrayIndexOutOfBoundsException exception)
            {
                habTemp.setEstado(false);
            }
            habilidadesTemp.add(habTemp);
            posInicial += 1;
            cont += 1;
        }
        alumnoTemp.setHabilidades(habilidadesTemp);
        alumnoTemp.setNombre(textoSeparado[0]);
        if (textoSeparado[0].equals("*****") == true || textoSeparado[0].equals("—————"))
        {
            //esto es por si ocurre que el nombre es igual al fin de línea o algo así
            return false;
        }

        //se asegura que el run sea válido (o de siquiera es un número), el proceso se corta en caso de no ser así
        try
        {
            alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));
            alumnoTemp.setEdad(Integer.parseInt(textoSeparado[2]));
        }
        catch (NumberFormatException exception)
        {
            throw new ImportarAlumnosException();
        }
        if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
        {
            return false;
        }

        this.agregarAlumno(alumnoTemp);
        return true;
    }
    
    //parametros de entrada invertido
    public boolean importarAlumno (String[] textoSeparado, ArrayList<String> nombreHabilidades) throws ImportarAlumnosException
    {
    	Alumno alumnoTemp = new Alumno();
        ArrayList<Habilidades> habilidadesTemp = new ArrayList<>();
        int cont = 0;
        int posInicial = 3;
        while(cont < nombreHabilidades.size())
        {
            Habilidades habTemp = new Habilidades();
            habTemp.setNombre(nombreHabilidades.get(cont));
            try
            {
                habTemp.setEstado(Boolean.parseBoolean(textoSeparado[posInicial]));
            }
            catch (ArrayIndexOutOfBoundsException exception)
            {
                habTemp.setEstado(false);
            }
            habilidadesTemp.add(habTemp);
            posInicial += 1;
            cont += 1;
        }
        alumnoTemp.setHabilidades(habilidadesTemp);
        alumnoTemp.setNombre(textoSeparado[0]);
        if (textoSeparado[0].equals("*****") == true || textoSeparado[0].equals("—————"))
        {
            //esto es por si ocurre que el nombre es igual al fin de línea o algo así
            return false;
        }

      //se asegura que el run sea válido (o de siquiera es un número), el proceso se corta en caso de no ser así
        try
        {
            alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));
            alumnoTemp.setEdad(Integer.parseInt(textoSeparado[2]));
        }
        catch (NumberFormatException exception)
        {
            throw new ImportarAlumnosException();
        }
        
        if (alumnoTemp.getRUN() <= 1000000 || this.alumnos.get(alumnoTemp.getRUN()) != null)
        {
            return false;
        }

        this.agregarAlumno(alumnoTemp);
        return true;
    }
    
    public void importarProfesor (String[] textoSeparado)
    {
    	/* te voy a ser muy sincero, esto confía mucho en que el string tenga las cosas bien,
    	 * pero gracias a como implementamos las cosas por ventanas, nos pudimos permitir esto
    	 * programar es bonito
    	 */
    	Profesor newProfesor = new Profesor();
    	
    	newProfesor.setNombre(textoSeparado[0]);
    	newProfesor.setRUN(Integer.parseInt(textoSeparado[1]));
    	newProfesor.setEdad(Integer.parseInt(textoSeparado[2]));
    	newProfesor.setMateriaPrincipal(textoSeparado[3]);
    	newProfesor.setAnyosEnsenyando(Integer.parseInt(textoSeparado[4]));
    	newProfesor.setCalidad(Integer.parseInt(textoSeparado[5]));
    	
    	this.setProfesor(newProfesor);
    }
    
    public void updateFile (File file, FileWriter fileWriter, PrintWriter printWriter, Enumeration<Integer> enu)
    {
    	int rutPrueba;
    	try
		{
    		rutPrueba = enu.nextElement();
		}
		catch (NoSuchElementException exception)
		{
			printWriter.write(this.getNombreCurso());
			printWriter.write("\n");
			printWriter.write(this.profesor.getNombre()+","+this.profesor.getRUN()+","+this.profesor.getEdad()+
					","+this.profesor.getMateriaPrincipal()+","+this.profesor.getAnyosEnsenyando()+","
					+this.profesor.getCalidad());
			return;
		}
    	
    	Alumno alumnoTemp = this.buscarAlumno(rutPrueba);
    	ArrayList<Habilidades> habilidadesTemp = alumnoTemp.getHabilidades();
    	
    	//asumiendo que las habilidades en todos son iguales se usan los nombres que tenga el primero para la primera linea
    	printWriter.write(this.getNombreCurso());
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		printWriter.write(",");
    		printWriter.write(habilidadesTemp.get(contHab).getNombre());
    	}
    	printWriter.write("\n");
    	
    	//Se asume que el profesor existe, ya que no hay forma de importar un curso sin profesor
    	printWriter.write(this.profesor.getNombre()+","+this.profesor.getRUN()+","+this.profesor.getEdad()+
    					","+this.profesor.getMateriaPrincipal()+","+this.profesor.getAnyosEnsenyando()+","
    					+this.profesor.getCalidad());
    	printWriter.write("\n");
    	
    	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN()+","+alumnoTemp.getEdad());
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		printWriter.write(",");
    		printWriter.write(String.valueOf(habilidadesTemp.get(contHab).getEstado()));
    	}
    	
        while (enu.hasMoreElements())
        {
        	/* Sobre esto, ya se que se ve mal, pero si miras la línea 241, se pilla el primer alumno
        	 * para sacar el ArrayList de las habilidades y poder ponerlo luego del nombre del curso
        	 * luego en el proceso de las lineas 271 - 276 se meten los datos de ese mismo alumno
        	 * y aquí empezamos a seguir con el resto
        	 * */
        	alumnoTemp = this.buscarAlumno(enu.nextElement());
        	habilidadesTemp = alumnoTemp.getHabilidades();
        	printWriter.write("\n");
        	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN()+","+alumnoTemp.getEdad());
        	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
        	{
        		printWriter.write(",");
        		printWriter.write(String.valueOf(habilidadesTemp.get(contHab).getEstado()));
        	}
        }
    }
    
    //Similar al updateFile de arriba, ya que es simplemente una adaptación de este, no tiene mucho misterio
    public void guardarCSVBonito (File file, FileWriter fileWriter, PrintWriter printWriter, Enumeration<Integer> enu)
    {
    	int rutPrueba;
    	printWriter.write("Curso:,"+this.getNombreCurso());
		printWriter.write("\n");
    	try
		{
    		rutPrueba = enu.nextElement();
		}
		catch (NoSuchElementException exception)
		{
			printWriter.write("Nombre Profesor, R.U.N. Profesor, Edad Profesor, Asignatura Profesor, Años Enseñando, Calidad\n");
			printWriter.write(this.profesor.getNombre()+","+this.profesor.getRUN()+","+this.profesor.getEdad()+
					","+this.profesor.getMateriaPrincipal()+","+this.profesor.getAnyosEnsenyando()+","
					+this.profesor.getCalidad());
			return;
		}
    	
    	Alumno alumnoTemp = this.buscarAlumno(rutPrueba);
    	ArrayList<Habilidades> habilidadesTemp = alumnoTemp.getHabilidades();

    	//Se asume que el profesor existe, ya que no hay forma de importar un curso sin profesor
    	printWriter.write("Nombre Profesor, R.U.N. Profesor, Edad Profesor, Asignatura Profesor, Años Enseñando, Calidad\n");
    	printWriter.write(this.profesor.getNombre()+","+this.profesor.getRUN()+","+this.profesor.getEdad()+
    					","+this.profesor.getMateriaPrincipal()+","+this.profesor.getAnyosEnsenyando()+","
    					+this.profesor.getCalidad());
    	printWriter.write("\n");
    	
    	printWriter.write("Alumnos,,,,,Habilidades\nNombre, R.U.N., Edad");
    	//asumiendo que las habilidades en todos son iguales se usan los nombres que tenga el primero para la primera linea
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		printWriter.write(","+habilidadesTemp.get(contHab).getNombre());
    	}
    	printWriter.write("\n");

    	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN()+","+alumnoTemp.getEdad());
    	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
    	{
    		String aprov;
    		if(habilidadesTemp.get(contHab).getEstado()) aprov = "Conseguida";
    		else aprov = "No Conseguida";
    		
    		printWriter.write(","+aprov);
    	}

        while (enu.hasMoreElements())
        {
        	alumnoTemp = this.buscarAlumno(enu.nextElement());
        	habilidadesTemp = alumnoTemp.getHabilidades();
        	printWriter.write("\n");
        	printWriter.write(alumnoTemp.getNombre()+","+alumnoTemp.getRUN()+","+alumnoTemp.getEdad());
        	for (int contHab = 0 ; contHab < habilidadesTemp.size() ; contHab += 1)
        	{
        		String aprov;
        		if(habilidadesTemp.get(contHab).getEstado()) aprov = "Conseguida";
        		else aprov = "No Conseguida";
        		
        		printWriter.write(","+aprov);
        	}
        }
    }
    
    public void cambiarEstadoHabilidadesAlumno (int rut, int inputUsuario)
    {
    	this.alumnos.get(rut).cambiarEstadoHabilidad(inputUsuario);
    }
    
    public ArrayList<Alumno> alumnosAprobados ()
    {
    	/* que retorna el arrayList de los que aprueban
    	 * que está en el nombre
    	 * */
    	ArrayList<Alumno> aprobados = new ArrayList<>();
    	if (this.alumnos.size() < 1)
    	{
    		return aprobados;
    	}
    	Enumeration<Integer> enu = this.getAlumnos().keys();
    	
    	Alumno alumnoTemp;
    	try
		{
    		alumnoTemp = this.buscarAlumno(enu.nextElement());
		}
		catch (NoSuchElementException exception)
		{
			return null;
		}

    	while (alumnoTemp != null)
    	{
    		if (alumnoTemp.getAprobado() == true)
    		{
    			aprobados.add(alumnoTemp);
    		}
    		
    		try
    		{
    			alumnoTemp = this.buscarAlumno(enu.nextElement());
    		}
    		catch (NoSuchElementException exception)
    		{
    			break;
    		}
    	}
    	
    	return aprobados;
    }
    public String getNombreAlumno(String nombreAlumno)
    {
    	/* Ya se que podría parecer que tengo 70 años ahora mismo
    	 * pero mira, son las 4am, no me vengas con cosas
    	 * */
    	return this.getAlumnoNombre(nombreAlumno).getNombre();
    }
    public int getEdadAlumno(String nombreAlumno)
    {
    	return this.getAlumnoNombre(nombreAlumno).getEdad();
    }
    public int getRUNAlumno(String nombreAlumno)
    {
    	return this.getAlumnoNombre(nombreAlumno).getRUN();
    }
    public Alumno getAlumnoNombre (String nombreAlumno)
    {
        Enumeration<Integer> enu = this.getAlumnos().keys();
        Alumno alumnoAux = new Alumno();
        for(int i = 0 ; i < this.alumnos.size() && alumnoAux != null ; i++)
        {
            alumnoAux = this.alumnos.get(enu.nextElement());
            if (alumnoAux.getNombre().equals(nombreAlumno) == true)
            {
            	return alumnoAux;
            }
        }
        return null;
    }
    public void cambiarEstadoHabilidadesAlumnoIndice (String nombreAlumno, int indiceHabilidad)
    {
        this.getAlumnoNombre(nombreAlumno).cambiarEstadoHabilidad(indiceHabilidad);
    }
    public boolean getEstadoHabilidad(String nombreAlumno, int indiceHabilidad)
    {
        return this.getAlumnoNombre(nombreAlumno).getEstadoHabilidad(indiceHabilidad);
    }
    public void editarAlumno (String viejoNombreAlumno, String nuevoNombreAlumno, int nuevaEdad)
	{
		this.getAlumnoNombre(viejoNombreAlumno).editarAlumno(nuevoNombreAlumno, nuevaEdad);
	}
    public void eliminarAlumnoNombre (String nombreAlumno)
    {
    	this.alumnos.remove(this.getAlumnoNombre(nombreAlumno).getRUN());
    }
}