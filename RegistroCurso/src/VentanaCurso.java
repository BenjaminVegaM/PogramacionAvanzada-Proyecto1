import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class VentanaCurso extends JFrame {

    private JPanel contentPane;

    public VentanaCurso(Instituto instituto, int indiceCurso) {
    	setTitle("Información Curso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaInstituto ventanaCursos = new VentanaInstituto(instituto);
                ventanaCursos.setVisible(true);
                dispose();
            }
        });
        btnAtras.setBounds(10, 227, 89, 23);
        contentPane.add(btnAtras);
        
        JLabel lblSeleccionarAlumno = new JLabel("Seleccionar Alumno");
        lblSeleccionarAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
        lblSeleccionarAlumno.setBounds(10, 172, 117, 14);
        contentPane.add(lblSeleccionarAlumno);
        
        JComboBox comboBox_Alumnos = new JComboBox();
        String [] arrayAlumnos= new String [instituto.getCantAlumnosCurso(indiceCurso)+1];
        arrayAlumnos[0] = "";
        // Puede ser que el curso este vacio, eso puede dar un error
        Enumeration<Integer> enu = instituto.getKeysAlumnosCurso(indiceCurso);
        for(int index = 1 ; index-1 < instituto.getCantAlumnosCurso(indiceCurso);index++) 
        {
        	// Deberiamos poner un break si enu.hasMoreElements() == null
        	arrayAlumnos[index] = instituto.getCopiaAlumnoCurso(indiceCurso, enu.nextElement()).getNombre();
        }
        
        comboBox_Alumnos.setModel(new DefaultComboBoxModel(arrayAlumnos));
        comboBox_Alumnos.setToolTipText("Lista de Cursos");
        comboBox_Alumnos.setBounds(137, 168, 208, 22);
        contentPane.add(comboBox_Alumnos);
        
        JButton btnAadirAlumno = new JButton("Añadir Alumno");
        btnAadirAlumno.setBounds(152, 227, 118, 23);
        contentPane.add(btnAadirAlumno);
        
        JButton btnVerAlumno = new JButton("Ver Alumno");
        btnVerAlumno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaAlumno ventanaAlumno = new VentanaAlumno(instituto, indiceCurso, comboBox_Alumnos.getSelectedIndex()-1);
        		ventanaAlumno.setVisible(true);
        		dispose();
        	}
        });
        btnVerAlumno.setToolTipText("Ver el curso seleccionado.");
        btnVerAlumno.setBounds(335, 227, 89, 23);
        contentPane.add(btnVerAlumno);
        
        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setBounds(355, 168, 69, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNombreCurso = new JLabel(instituto.getNombreCurso(indiceCurso));
        lblNombreCurso.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreCurso.setBounds(10, 11, 414, 14);
        contentPane.add(lblNombreCurso);
        
        JLabel lblNewLabel_1 = new JLabel("Profesor Jefe: ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_1.setBounds(10, 96, 117, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNombreProfesor = new JLabel(instituto.getProfesorCurso(indiceCurso).getNombre());
        lblNombreProfesor.setBounds(137, 96, 287, 14);
        contentPane.add(lblNombreProfesor);
        
        JLabel lblCantidadAlumnos = new JLabel(Integer.toString(instituto.getCantAlumnosCurso(indiceCurso)));
        lblCantidadAlumnos.setBounds(137, 46, 287, 14);
        contentPane.add(lblCantidadAlumnos);
        
        JLabel lblNewLabel_2 = new JLabel("Cantidad de Alumnos:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_2.setBounds(10, 46, 117, 14);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Porcentaje de Aprovación:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_2_1.setBounds(10, 71, 117, 14);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblPorcentajeAprovacion = new JLabel(Integer.toString(instituto.getPorcentajeAprobacionCurso(indiceCurso)));
        lblPorcentajeAprovacion.setBounds(137, 71, 287, 14);
        contentPane.add(lblPorcentajeAprovacion);
        
        JLabel lblNewLabel_1_1 = new JLabel("R.U.N.:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_1_1.setBounds(10, 118, 117, 14);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblRunProfesor = new JLabel(Integer.toString(instituto.getProfesorCurso(indiceCurso).getRUN()));
        lblRunProfesor.setBounds(137, 118, 287, 14);
        contentPane.add(lblRunProfesor);
        
        JLabel lblNewLabel_1_2 = new JLabel("Asignatura:");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_1_2.setBounds(10, 143, 117, 14);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblAsignaturaProfesor = new JLabel(instituto.getProfesorCurso(indiceCurso).getMateriaPrincipal());
        lblAsignaturaProfesor.setBounds(137, 143, 287, 14);
        contentPane.add(lblAsignaturaProfesor);
        
        JButton btnCambiarProfesor = new JButton("Cambiar Profesor");
        btnCambiarProfesor.setBounds(307, 114, 117, 23);
        contentPane.add(btnCambiarProfesor);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 92, 414, 2);
        contentPane.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 159, 414, 2);
        contentPane.add(separator_1);
    }
}