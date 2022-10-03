import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEstaSeguro extends JFrame
{

	private JPanel contentPane;

	public VentanaEstaSeguro(Instituto instituto, int indiceCurso)
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
				instituto.eliminarCurso(indiceCurso-1);
				VentanaInstituto ventanaInstituto = new VentanaInstituto(instituto);
				ventanaInstituto.setVisible(true);
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
				VentanaInstituto ventanaInstituto = new VentanaInstituto(instituto);
				ventanaInstituto.setVisible(true);
				dispose();
			}
		});
		btnNo.setBounds(282, 169, 97, 25);
		contentPane.add(btnNo);
	}

}
