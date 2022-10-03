import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class VentanaListaAprovados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaListaAprovados(Instituto instituto, boolean flag) {
		String aprov;
		if(flag) aprov = "Aprovado";
		else aprov = "Reprovado";
		setTitle("Lista de "+aprov+"s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarAlumno = new JLabel("Lista Alumnos "+aprov+"s:");
		lblSeleccionarAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccionarAlumno.setBounds(10, 89, 183, 14);
		contentPane.add(lblSeleccionarAlumno);
		
		String [] arrayAlumnosT = new String [instituto.cantidadAlumnosTotal()+1];
		int[] arrayIndices = new int[instituto.cantidadAlumnosTotal()+1];
		Alumno alumnoAux;
		int k = 1;
		for(int i = 0 ; i < instituto.getNumeroCursos() ; i++)
		{
			Enumeration<Integer> enu = instituto.getKeysAlumnosCurso(i);
			for(int j = 0 ; j < instituto.getCantAlumnosCurso(i) ; j++)
			{
				alumnoAux = instituto.getCopiaAlumnoCurso(i, enu.nextElement());
				if(alumnoAux.getAprobado() == flag)
				{
					arrayAlumnosT[k] = alumnoAux.getNombre();
					arrayIndices[k] = i;
					k++;
				}
			}
		}
		String [] arrayAlumnos = new String [k];
		for(int i = 0 ; i < k ; i++)
		{
			arrayAlumnos[i] = arrayAlumnosT[i];
		}
		
		JComboBox<String[]> comboBox_Alumnos = new JComboBox<>();
		comboBox_Alumnos.setModel(new DefaultComboBoxModel(arrayAlumnos));
		comboBox_Alumnos.setToolTipText("Lista de Alumnos "+aprov+"s");
		comboBox_Alumnos.setBounds(203, 85, 208, 22);
		contentPane.add(comboBox_Alumnos);

		JButton btnVerAlumno = new JButton("Ver Alumno");
        btnVerAlumno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(comboBox_Alumnos.getSelectedIndex() == 0)
				{
        			if(arrayAlumnos.length < 2)
        			{        				   				  				
        				JOptionPane.showMessageDialog(null, "No hay alumnos "+aprov+"s.");
        			}
        			else
        			{
        				JOptionPane.showMessageDialog(null, "Por favor seleccione un alumno.");
        			}
				}
				else
				{
					VentanaAlumno ventanaAlumno = new VentanaAlumno(instituto, arrayIndices[comboBox_Alumnos.getSelectedIndex()], arrayAlumnos[comboBox_Alumnos.getSelectedIndex()], false, flag);
	        		ventanaAlumno.setVisible(true);
	        		dispose();
				}
        	}
        });
		btnVerAlumno.setToolTipText("Ver el curso seleccionado.");
		btnVerAlumno.setBounds(335, 227, 89, 23);
		contentPane.add(btnVerAlumno);
		
		JButton btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                VentanaInstituto ventanaInstituto = new VentanaInstituto(instituto);
                ventanaInstituto.setVisible(true);
                dispose();
            }
        });
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblCantidad = new JLabel();
		lblCantidad.setText("Cantidad de "+aprov+"s: "+(k-1));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(10, 49, 414, 14);
		contentPane.add(lblCantidad);
	}
}
