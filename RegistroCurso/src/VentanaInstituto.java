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
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class VentanaInstituto extends JFrame {

	private JPanel contentPane;

	public VentanaInstituto(Instituto instituto) {
		setTitle("Lista de Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 149, 117, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_Cursos = new JComboBox();
		String[] listaNombreCursos = new String[instituto.getTamaño()+1];
		listaNombreCursos[0] = "";
		for(int i = 1 ; i < instituto.getTamaño()+1 ; i++)
		{
			listaNombreCursos[i] = instituto.getNombreCurso(i-1);
		}
		comboBox_Cursos.setModel(new DefaultComboBoxModel(listaNombreCursos));
		comboBox_Cursos.setToolTipText("Lista de Cursos");
		comboBox_Cursos.setBounds(137, 145, 208, 22);
		contentPane.add(comboBox_Cursos);
		
		JButton btn_Atras = new JButton("Atrás");
		btn_Atras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				VentanaInicio ventanaInicio = new VentanaInicio(instituto);
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
				if(comboBox_Cursos.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Por favor seleccione un curso.");
				}
				else
				{
					VentanaCurso ventanaCurso = new VentanaCurso(instituto, comboBox_Cursos.getSelectedIndex()-1);
					ventanaCurso.setVisible(true);
					dispose();
				}
			}
		});
		btnVerCurso.setToolTipText("Ver el curso seleccionado.");
		btnVerCurso.setBounds(335, 227, 89, 23);
		contentPane.add(btnVerCurso);
		
		JButton btnAnyadirCurso = new JButton("Añadir Curso");
		btnAnyadirCurso.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				VentanaAnyadirCurso ventanaAnyadirCurso = new VentanaAnyadirCurso(instituto);
				ventanaAnyadirCurso.setVisible(true);
				dispose();
			}
		});
		btnAnyadirCurso.setBounds(152, 227, 118, 23);
		contentPane.add(btnAnyadirCurso);
		
		JButton btnEliminarCurso = new JButton("Eliminar");
		btnEliminarCurso.setBounds(355, 145, 69, 23);
		contentPane.add(btnEliminarCurso);
		btnEliminarCurso.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(comboBox_Cursos.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Por favor seleccione un curso.");
				}
				else
				{
					VentanaEstaSeguro ventanaEstaSeguro = new VentanaEstaSeguro(instituto, comboBox_Cursos.getSelectedIndex());
					ventanaEstaSeguro.setVisible(true);
					dispose();
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 136, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de Cursos:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(10, 38, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel(Integer.toString(instituto.getTamaño()));
		lblNewLabel_3_1.setBounds(137, 38, 287, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de Alumnos:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setBounds(10, 63, 117, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblCantAlumnos = new JLabel(Integer.toString(instituto.cantidadAlumnosTotal()));
		lblCantAlumnos.setBounds(137, 63, 287, 14);
		contentPane.add(lblCantAlumnos);
		
		JButton btnMostrarAprovados = new JButton("Mostrar Aprovados");
		btnMostrarAprovados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListaAprovados ventanaListaAprovados = new VentanaListaAprovados(instituto, true);
				ventanaListaAprovados.setVisible(true);
				dispose();
			}
		});
		btnMostrarAprovados.setBounds(281, 34, 143, 23);
		contentPane.add(btnMostrarAprovados);
		
		JButton btnMostrarReprovados = new JButton("Mostrar Reprovados");
		btnMostrarReprovados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListaAprovados ventanaListaAprovados = new VentanaListaAprovados(instituto, false);
				ventanaListaAprovados.setVisible(true);
				dispose();
			}
		});
		btnMostrarReprovados.setBounds(281, 63, 143, 23);
		contentPane.add(btnMostrarReprovados);
	}
}
