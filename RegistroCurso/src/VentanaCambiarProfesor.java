import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaCambiarProfesor extends JFrame
{

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textRUT;
	private JTextField textEdad;


	public VentanaCambiarProfesor (Instituto instituto, int indiceCurso)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreProfesor = new JLabel("Nombre Profesor:");
		lblNombreProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreProfesor.setBounds(59, 27, 117, 14);
		contentPane.add(lblNombreProfesor);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(186, 24, 160, 20);
		contentPane.add(textNombre);
		
		JLabel lblRUTProfesor = new JLabel("R.U.N. Profesor:");
		lblRUTProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRUTProfesor.setBounds(59, 55, 117, 14);
		contentPane.add(lblRUTProfesor);
		
		textRUT = new JTextField();
		textRUT.setColumns(10);
		textRUT.setBounds(186, 52, 160, 20);
		contentPane.add(textRUT);
		
		JLabel lblTextoEdad = new JLabel("Edad Profesor");
		lblTextoEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextoEdad.setBounds(59, 85, 117, 14);
		contentPane.add(lblTextoEdad);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(186, 82, 160, 20);
		contentPane.add(textEdad);
		
		JLabel lblAsignaturaProfesor = new JLabel("Asignatura Profesor:");
		lblAsignaturaProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAsignaturaProfesor.setBounds(59, 116, 117, 14);
		contentPane.add(lblAsignaturaProfesor);
		
		JComboBox comboBoxAsignaturaProfesor = new JComboBox();
		comboBoxAsignaturaProfesor.setBounds(186, 112, 160, 22);
		contentPane.add(comboBoxAsignaturaProfesor);
		
		JButton btnAtras = new JButton("Cancelar");
		btnAtras.setBounds(12, 225, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String endOfCurso = "*****";
                String endOfFile = "—————";
                if (Objects.equals(textNombre.getText(), endOfCurso) || Objects.equals(textNombre.getText(), endOfFile))
            	{
                	//sacar popup
                	JOptionPane.showMessageDialog(null, "Nombre del curso inválido, inténtelo de nuevo");
            	}
                
            	//EDITAR PARA QUE TENGA QUE METER PROFESOR Y HABILIDADES
            	Curso cursoTemp = new Curso();
            	Profesor profesorAux = new Profesor();
            	profesorAux.setNombre(textNombre.getText());
            	//PONER TRYCATCH
            	profesorAux.setEdad(Integer.parseInt(textEdad.getText()));
            	profesorAux.setRUN(Integer.parseInt(textRUT.getText()));
            	profesorAux.setMateriaPrincipal(comboBoxAsignaturaProfesor.getSelectedItem().toString());
            	
            	cursoTemp.setProfesor(profesorAux);
            	instituto.addCurso(cursoTemp);
                
                VentanaInstituto ventanaCursos = new VentanaInstituto(instituto);
                ventanaCursos.setVisible(true);
                JOptionPane.showMessageDialog(null, "Nuevo profesor "+textNombre.getText()+" creado correctamente.");
                dispose();
			}
		});
		btnCrear.setBounds(325, 226, 97, 25);
		contentPane.add(btnCrear);
	}

}
