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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaAnyadirAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreAlumno;
	private JTextField textRUN;
	private JTextField textEdad;


	public VentanaAnyadirAlumno(Instituto instituto, int indiceCurso)
	{
		setTitle("Añadir Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAlumno = new JLabel("Nombre Alumno:");
		lblNombreAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreAlumno.setBounds(74, 34, 117, 14);
		contentPane.add(lblNombreAlumno);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.setColumns(10);
		textNombreAlumno.setBounds(201, 31, 160, 20);
		contentPane.add(textNombreAlumno);
		
		JLabel lblRUN = new JLabel("R.U.N.:");
		lblRUN.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRUN.setBounds(74, 62, 117, 14);
		contentPane.add(lblRUN);
		
		textRUN = new JTextField();
		textRUN.setColumns(10);
		textRUN.setBounds(201, 59, 160, 20);
		contentPane.add(textRUN);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEdad.setBounds(74, 90, 117, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(201, 87, 160, 20);
		contentPane.add(textEdad);
		
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
		
		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String[] lineaAlumno = new String[3];
				lineaAlumno[0] = textNombreAlumno.getText();
				lineaAlumno[1] = textRUN.getText();
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
		btnAnyadir.setBounds(314, 211, 97, 25);
		contentPane.add(btnAnyadir);
		
		JLabel lblAvisoElEstado = new JLabel("Aviso: El estado de las habilidades del alumno que va a ingresar");
		lblAvisoElEstado.setVerticalAlignment(SwingConstants.TOP);
		lblAvisoElEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAvisoElEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvisoElEstado.setBounds(24, 117, 387, 55);
		contentPane.add(lblAvisoElEstado);
		
		JLabel lblSeInicializarnSiempre = new JLabel(" se inicializarán siempre como reprobado");
		lblSeInicializarnSiempre.setVerticalAlignment(SwingConstants.TOP);
		lblSeInicializarnSiempre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeInicializarnSiempre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeInicializarnSiempre.setBounds(24, 132, 387, 55);
		contentPane.add(lblSeInicializarnSiempre);
	}
}
