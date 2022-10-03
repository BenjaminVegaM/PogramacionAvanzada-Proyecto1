import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAnyadirAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreAlumno;
	private JTextField textRUT;
	private JTextField textEdad;
	private JTextField textEstadoHabilidades;


	public VentanaAnyadirAlumno(Instituto instituto, int indiceCurso)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAlumno = new JLabel("Nombre Alumno:");
		lblNombreAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreAlumno.setBounds(74, 26, 117, 14);
		contentPane.add(lblNombreAlumno);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.setColumns(10);
		textNombreAlumno.setBounds(201, 23, 160, 20);
		contentPane.add(textNombreAlumno);
		
		JLabel lblRutr = new JLabel("RUT:");
		lblRutr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRutr.setBounds(74, 62, 117, 14);
		contentPane.add(lblRutr);
		
		textRUT = new JTextField();
		textRUT.setColumns(10);
		textRUT.setBounds(201, 59, 160, 20);
		contentPane.add(textRUT);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEdad.setBounds(74, 90, 117, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(201, 87, 160, 20);
		contentPane.add(textEdad);
		
		JLabel lblEstadHabilidades = new JLabel("Estado Habilidades:");
		lblEstadHabilidades.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstadHabilidades.setBounds(74, 120, 117, 14);
		contentPane.add(lblEstadHabilidades);
		
		textEstadoHabilidades = new JTextField();
		textEstadoHabilidades.setColumns(10);
		textEstadoHabilidades.setBounds(201, 117, 160, 20);
		contentPane.add(textEstadoHabilidades);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
                dispose();
			}
		});
		btnCancelar.setBounds(24, 211, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String[] lineaAlumno = new String[3];
				lineaAlumno[0] = textNombreAlumno.getText();
				lineaAlumno[1] = textRUT.getText();
				lineaAlumno[2] = textEdad.getText();
				
				try
				{
					instituto.importarAlumno(indiceCurso, lineaAlumno, instituto.getNombreHabilidadesCurso(indiceCurso));
				}
				catch (ImportarAlumnosException e1)
				{
					JOptionPane.showMessageDialog(null, "Error al importar alumno");
					e1.printStackTrace();
				}
				
				VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
                dispose();
			}
		});
		btnAñadir.setBounds(314, 211, 97, 25);
		contentPane.add(btnAñadir);
	}
}