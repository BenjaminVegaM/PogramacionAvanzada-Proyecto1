import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrueba() {
		setTitle("aaaaaaaaaa");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Estudiante\\Pictures\\animes.jpg"));
		setForeground(new Color(0, 255, 0));
		setAutoRequestFocus(false);
		setBackground(Color.RED);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setBounds(10, 11, 71, 14);
		contentPane.add(lblNewLabel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setForeground(Color.YELLOW);
		txtIngreseNombre.setBackground(new Color(255, 128, 255));
		txtIngreseNombre.setToolTipText("ingrese nombre\r\n");
		txtIngreseNombre.setBounds(57, 8, 220, 20);
		contentPane.add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBackground(Color.RED);
		rdbtnNewRadioButton.setForeground(Color.ORANGE);
		rdbtnNewRadioButton.setBounds(34, 77, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
	}
}
