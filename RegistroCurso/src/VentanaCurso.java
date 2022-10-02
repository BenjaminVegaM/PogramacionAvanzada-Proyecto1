import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class VentanaCurso extends JFrame {

	private JPanel contentPane;

	public VentanaCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInstituto ventanaCursos = new VentanaInstituto();
				ventanaCursos.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblSeleccionarAlumno = new JLabel("Seleccionar Alumno");
		lblSeleccionarAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccionarAlumno.setBounds(10, 15, 117, 14);
		contentPane.add(lblSeleccionarAlumno);
		
		JComboBox comboBox_Cursos = new JComboBox();
		comboBox_Cursos.setToolTipText("Lista de Cursos");
		comboBox_Cursos.setBounds(137, 11, 287, 22);
		contentPane.add(comboBox_Cursos);
	}

}
