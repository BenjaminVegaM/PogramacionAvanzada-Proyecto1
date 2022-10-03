import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaEditarCurso extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JLabel lblTextoNombreCurso;
	private JTextField txtNombreCurso;

	public VentanaEditarCurso(Instituto instituto, int indiceCurso) {

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
				VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		lblTextoNombreCurso = new JLabel("Nombre Curso:");
		lblTextoNombreCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextoNombreCurso.setBounds(57, 104, 117, 14);
		contentPane.add(lblTextoNombreCurso);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setText(instituto.getNombreCurso(indiceCurso));
		txtNombreCurso.setBounds(184, 101, 160, 20);
		contentPane.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		
		JButton btnEditar = new JButton("Cambiar");
		btnEditar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                JOptionPane.showMessageDialog(null, "Nombre cambiado correctamente.");
                VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
				dispose();
			}
		});
		btnEditar.setBounds(325, 226, 97, 25);
		contentPane.add(btnEditar);
	}
}
