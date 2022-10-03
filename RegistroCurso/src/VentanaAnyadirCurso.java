/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class VentanaAnyadirCurso extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JLabel lblTextoNombreCurso;
	private JLabel lblNombreProfesor;
	private JLabel lblRUTProfesor;
	private JLabel lblAsignaturaProfesor;
	private JTextField txtNombreCurso;
	private JTextField txtNombreProfesor;
	private JTextField txtRUTProfesor;
	private JTextField txtEdadProfesor;
	private JComboBox<String[]> comboBoxAsignaturaProfesor;

	public VentanaAnyadirCurso(Instituto instituto) {
		setTitle("Añadir Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton("Cancelar");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInstituto ventanaCursos = new VentanaInstituto(instituto);
                ventanaCursos.setVisible(true);
                dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		lblTextoNombreCurso = new JLabel("Nombre Curso:");
		lblTextoNombreCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextoNombreCurso.setBounds(57, 32, 117, 14);
		contentPane.add(lblTextoNombreCurso);
		
		lblNombreProfesor = new JLabel("Nombre Profesor:");
		lblNombreProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreProfesor.setBounds(57, 68, 117, 14);
		contentPane.add(lblNombreProfesor);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(184, 29, 160, 20);
		contentPane.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		
		txtNombreProfesor = new JTextField();
		txtNombreProfesor.setColumns(10);
		txtNombreProfesor.setBounds(184, 65, 160, 20);
		contentPane.add(txtNombreProfesor);
		
		lblRUTProfesor = new JLabel("R.U.N. Profesor:");
		lblRUTProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRUTProfesor.setBounds(57, 96, 117, 14);
		contentPane.add(lblRUTProfesor);
		
		txtRUTProfesor = new JTextField();
		txtRUTProfesor.setColumns(10);
		txtRUTProfesor.setBounds(184, 93, 160, 20);
		contentPane.add(txtRUTProfesor);
		
		lblAsignaturaProfesor = new JLabel("Asignatura Profesor:");
		lblAsignaturaProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAsignaturaProfesor.setBounds(57, 157, 117, 14);
		contentPane.add(lblAsignaturaProfesor);
		
		comboBoxAsignaturaProfesor = new JComboBox<String[]>();
		comboBoxAsignaturaProfesor.setModel(new DefaultComboBoxModel(new String[] {"Lenguaje", "Matemáticas", "Historia", "Ciencias", "Inglés"}));
		comboBoxAsignaturaProfesor.setBounds(184, 153, 160, 22);
		contentPane.add(comboBoxAsignaturaProfesor);
		
		JLabel lblTextoEdad = new JLabel("Edad Profesor");
		lblTextoEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextoEdad.setBounds(57, 126, 117, 14);
		contentPane.add(lblTextoEdad);
		
		txtEdadProfesor = new JTextField();
		txtEdadProfesor.getText();
		txtEdadProfesor.setColumns(10);
		txtEdadProfesor.setBounds(184, 123, 160, 20);
		contentPane.add(txtEdadProfesor);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                boolean encontrado = false;
                String endOfCurso = "*****";
                String endOfFile = "—————";
                
                for (int cont = 0; cont < instituto.getTamaño() ; cont++)
                {
                	if (Objects.equals(txtNombreCurso.getText(),instituto.getNombreCurso(cont)))
                	{
                		encontrado = true;
                	}
                }
                
                if (Objects.equals(txtNombreCurso.getText(), endOfCurso) || Objects.equals(txtNombreCurso.getText(), endOfFile))
            	{
                	//sacar popup
                	JOptionPane.showMessageDialog(null, "Nombre del curso inválido, inténtelo de nuevo.");
            	}
                else if (encontrado == true)
                {
                	JOptionPane.showMessageDialog(null, "El nombre ingresado ya existe, ingrese otro.");
                	encontrado = false;
                }
                else
                {
                	Curso cursoTemp = new Curso();
                	Profesor profesorAux = new Profesor();
                	profesorAux.setNombre(txtNombreProfesor.getText());
                	try
                	{
                		profesorAux.setEdad(Integer.parseInt(txtEdadProfesor.getText()));
                    	profesorAux.setRUN(Integer.parseInt(txtRUTProfesor.getText()));
                	}
                	catch (NumberFormatException e1)
                	{
                		JOptionPane.showMessageDialog(null, "Los datos del profesor no son válidos");
                		return;
                	}
                	profesorAux.setMateriaPrincipal(comboBoxAsignaturaProfesor.getSelectedItem().toString());
                	
                	cursoTemp.setNombre(txtNombreCurso.getText());
                	cursoTemp.setProfesor(profesorAux);
                	instituto.addCurso(cursoTemp);
                    
                    JOptionPane.showMessageDialog(null, "Nuevo curso "+txtNombreCurso.getText()+" creado correctamente.");
                    VentanaInstituto ventanaCursos = new VentanaInstituto(instituto);
                    ventanaCursos.setVisible(true);
                    dispose();
                } 
			}
		});
		btnCrear.setBounds(325, 226, 97, 25);
		contentPane.add(btnCrear);
	}
}
