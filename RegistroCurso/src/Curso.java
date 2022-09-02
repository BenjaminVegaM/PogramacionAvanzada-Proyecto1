/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
public class Curso 
{
   private String nombre;
   private ArrayList<String> nombreHabilidades;
   private Hashtable<Integer,Alumno> alumnos;
   private int cantAlumnos;

    /*constructores: igual lo cambiamos luego*/
    public Curso() 
    {
        this.nombre = "Nombre";
        this.alumnos = new Hashtable<>();
        this.nombreHabilidades = new ArrayList<>();
        this.cantAlumnos = 0;
    }

    /*getters*/
    public Hashtable<Integer,Alumno> getAlumnos()
    {
        return alumnos;
    }
    public int getCantAlumnos() 
    {
        return cantAlumnos;
    }
    public String getNombreCurso() 
    {
        return nombre;
    }
    public ArrayList<String> getNombreHabilidades()
    {
    	return nombreHabilidades;
    }
    
    //Setters
    public void setNombre(String nombre)
    {
    	this.nombre = nombre;
    }
    public void setCantAlumnos(int cantidad)
    {
    	this.cantAlumnos = cantidad;
    }
    public void setNombreHabilidades(ArrayList<String> nombreHabilidades)
    {
    	this.nombreHabilidades = nombreHabilidades;
    }
    
    // Métodos (funciones)
    /*para agrergar un estudiante con los datos separados, puede que no queramos esto*/
    public void agregarEstudiante(String nombre, int run, ArrayList<Boolean> habilidades)
    {
    	Alumno nuevo = new Alumno();
    	nuevo.setNombre(nombre);
    	nuevo.setRUN(run);
    	nuevo.setHabilidades(habilidades);
    	this.alumnos.put(run, nuevo);
    }
    
    /*para cuando se quiera agregar un objeto estudiante al hashtable*/
    public void agregarEstudiante(Alumno estudiante)
    {
    	System.out.println("Nombre: " + estudiante.getNombre() + "\nRut: "+estudiante.getRUN()+"\nEstado Habilidades: ");
    	estudiante.mostrarEstadoHabilidades();
    	System.out.println("\n");
    	this.alumnos.put(estudiante.getRUN(), estudiante);
    }
    
    /*para retornar un estudiante del hashtable cuando se le da un rut*/
    /*lo podríamos usar para alterar datos de un estudiante específico, requiere experimentación*/
    public Alumno buscarEstudiante(int run)
    {
    	return this.alumnos.get(run);
    }
    
    /*cuando se quiera mostrar los datos de un estudiante buscándolo por rut*/
    public void mostrarDatosEstudiante (int run)
    {
    	Alumno estudiante = this.alumnos.get(run);
    	System.out.println("Nombre: " + estudiante.getNombre() + "\nRut: "+estudiante.getRUN()+"\nEstado Habilidades: ");
    }
    
    //funciones de importacion
    /*cuidado con esto que igual pasa algo raro con la memoria*/
    public void importarHabilidades (String[] textoSeparado, int posInicial)
    {
		ArrayList<String> nombreHabilidadesTemp = new ArrayList<>();
		while (posInicial < textoSeparado.length)
		{
			System.out.println("se ha ingresado la habilidad: " + textoSeparado[posInicial]);
			nombreHabilidadesTemp.add(textoSeparado[posInicial]);
			posInicial += 1;
		}
		this.nombreHabilidades = nombreHabilidadesTemp;
    }
    
    /*importa un estudiante de una línea de texto previamente separada, también la podríamos separar ahí mismo tambien te digo*/
    public void importarEstudiante (String[] textoSeparado, int posInicial)
    {
    	Alumno alumnoTemp = new Alumno();
    	ArrayList<Boolean> habilidadesTemp = new ArrayList<>();
    	while(posInicial < textoSeparado.length)
		{
    		habilidadesTemp.add(Boolean.parseBoolean(textoSeparado[posInicial]));
			posInicial++;
		}
		alumnoTemp.setHabilidades(habilidadesTemp);
		alumnoTemp.setNombre(textoSeparado[0]);
		alumnoTemp.setRUN(Integer.parseInt(textoSeparado[1]));
		
		alumnoTemp.mostrarDatos();
		alumnoTemp.mostrarEstadoHabilidades();
		
		this.alumnos.put(alumnoTemp.getRUN(),alumnoTemp);
    }
    /*igual funciÃ³n para leer de un .txt???*/
}