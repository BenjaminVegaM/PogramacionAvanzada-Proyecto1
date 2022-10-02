import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaAnyadirCurso extends JFrame {

	private JPanel contentPane;
	private JButton btnAtras;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField txtNombreactualprofesor;
	private JTextField txtNombreactualprofesor_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;

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
		
		lblNewLabel = new JLabel("Nombre Curso:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(56, 40, 117, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Nombre Profesor:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(56, 76, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNombreactualprofesor = new JTextField();
		txtNombreactualprofesor.setBounds(183, 37, 160, 20);
		contentPane.add(txtNombreactualprofesor);
		txtNombreactualprofesor.setColumns(10);
		
		txtNombreactualprofesor_1 = new JTextField();
		txtNombreactualprofesor_1.setColumns(10);
		txtNombreactualprofesor_1.setBounds(183, 73, 160, 20);
		contentPane.add(txtNombreactualprofesor_1);
		
		lblNewLabel_1 = new JLabel("R.U.N. Profesor:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(56, 104, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 101, 160, 20);
		contentPane.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Asignatura Profesor:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(56, 132, 117, 14);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lenguaje", "Matemáticas", "Historia", "Ciencias", "Inglés"}));
		comboBox.setBounds(183, 128, 160, 22);
		contentPane.add(comboBox);
	}

}
