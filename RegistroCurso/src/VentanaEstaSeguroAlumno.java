/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaEstaSeguroAlumno extends JFrame
{

	private JPanel contentPane;

	public VentanaEstaSeguroAlumno(Instituto instituto, int indiceCurso, String nombreAlumno)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//No está centrado, lo siento
		JLabel lblNewLabel = new JLabel("¿Está seguro?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 68, 270, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnSi = new JButton("Sí");
		btnSi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				instituto.eliminarAlumnoCursoNombre(indiceCurso, nombreAlumno);
				VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
				dispose();
			}
		});
		btnSi.setBounds(45, 169, 97, 25);
		contentPane.add(btnSi);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
				ventanaCurso.setVisible(true);
				dispose();
			}
		});
		btnNo.setBounds(282, 169, 97, 25);
		contentPane.add(btnNo);
	}

}
