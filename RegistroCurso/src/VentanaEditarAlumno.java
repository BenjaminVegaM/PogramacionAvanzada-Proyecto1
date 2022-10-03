import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaEditarAlumno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreAlumno;
	private JTextField textEdad;

	public VentanaEditarAlumno(Instituto instituto, int indiceCurso, String nombreAlumno, boolean flag, boolean flag2) {
		setTitle("Editar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAlumno = new JLabel("Nombre Alumno:");
		lblNombreAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreAlumno.setBounds(74, 62, 117, 14);
		contentPane.add(lblNombreAlumno);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.setText(instituto.getNombreAlumno(indiceCurso, nombreAlumno));
		textNombreAlumno.setColumns(10);
		textNombreAlumno.setBounds(201, 59, 160, 20);
		contentPane.add(textNombreAlumno);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEdad.setBounds(74, 90, 117, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setText(Integer.toString(instituto.getEdadAlumno(indiceCurso, nombreAlumno)));
		textEdad.setColumns(10);
		textEdad.setBounds(201, 87, 160, 20);
		contentPane.add(textEdad);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				VentanaAlumno ventanaAlumno = new VentanaAlumno(instituto, indiceCurso, nombreAlumno, flag, flag2);
				ventanaAlumno.setVisible(true);
                dispose();
			}
		});
		btnCancelar.setBounds(24, 211, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				instituto.editarAlumno(indiceCurso, nombreAlumno, textNombreAlumno.getText(), Integer.parseInt(textEdad.getText()));
				JOptionPane.showMessageDialog(null, "Datos cambiados correctamente.");
				VentanaAlumno ventanaAlumno = new VentanaAlumno(instituto, indiceCurso, instituto.getNombreAlumno(indiceCurso, textNombreAlumno.getText()), flag, flag2);
				ventanaAlumno.setVisible(true);
				dispose();
			}
		});
		btnCambiar.setBounds(314, 211, 97, 25);
		contentPane.add(btnCambiar);
		
		JLabel lblAvisoElEstado = new JLabel("Aviso: El estado de las habilidades debe ser cambiado manualmente");
		lblAvisoElEstado.setVerticalAlignment(SwingConstants.TOP);
		lblAvisoElEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAvisoElEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvisoElEstado.setBounds(24, 117, 387, 20);
		contentPane.add(lblAvisoElEstado);
	}
}
