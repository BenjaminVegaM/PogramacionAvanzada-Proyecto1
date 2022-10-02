import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	public VentanaInicio(Instituto instituto) {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenid@");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 98, 414, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn_Ingresar = new JButton("Ingresar");
		btn_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInstituto ventanaInstituto = new VentanaInstituto(instituto);
				ventanaInstituto.setVisible(true);
				dispose();
			}
		});
		btn_Ingresar.setBounds(173, 123, 89, 23);
		contentPane.add(btn_Ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("Versión 0.01");
		lblNewLabel_1.setForeground(new Color(145, 145, 145));
		lblNewLabel_1.setBackground(new Color(145, 145, 145));
		lblNewLabel_1.setBounds(0, 247, 434, 14);
		contentPane.add(lblNewLabel_1);
	}
}
