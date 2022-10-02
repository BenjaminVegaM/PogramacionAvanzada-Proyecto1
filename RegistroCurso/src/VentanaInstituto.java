import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInstituto extends JFrame {

	private JPanel contentPane;

	public VentanaInstituto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 11, 117, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_Cursos = new JComboBox();
		comboBox_Cursos.setToolTipText("Lista de Cursos");
		comboBox_Cursos.setBounds(137, 7, 287, 22);
		contentPane.add(comboBox_Cursos);
		
		JButton btn_Atras = new JButton("Atrás");
		btn_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio();
		    	ventanaInicio.setVisible(true);
		    	dispose();
			}
		});
		btn_Atras.setToolTipText("Volver a la anterior ventana.");
		btn_Atras.setBounds(10, 227, 89, 23);
		contentPane.add(btn_Atras);
		
		JButton btnVerCurso = new JButton("Ver Curso");
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCurso ventanaAlumnos = new VentanaCurso();
				ventanaAlumnos.setVisible(true);
			}
		});
		
		if(comboBox_Cursos.getSelectedIndex() == -1)
		{
			btnVerCurso.setEnabled(false);
		}
		else
		{
			btnVerCurso.setEnabled(true);
		}
		btnVerCurso.setToolTipText("Ver el curso seleccionado.");
		btnVerCurso.setBounds(335, 227, 89, 23);
		contentPane.add(btnVerCurso);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 100, 414, 14);
		contentPane.add(lblNewLabel_1);
	}
}
