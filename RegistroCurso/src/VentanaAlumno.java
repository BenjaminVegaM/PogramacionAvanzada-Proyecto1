/**
 * @author Benjamín Vega
 * @author Diego Truyol
 * @author Pablo Paillalef Avendaño
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class VentanaAlumno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaAlumno(Instituto instituto, int indiceCurso, String nombreAlumno, boolean flag, boolean flag2) {
		setTitle("Información Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag)
				{
					VentanaCurso ventanaCurso = new VentanaCurso(instituto, indiceCurso);
					ventanaCurso.setVisible(true);
					dispose();					
				}
				else
				{
					VentanaListaAprovados ventanaListaAprovados = new VentanaListaAprovados(instituto, flag2);
					ventanaListaAprovados.setVisible(true);
					dispose();	
				}
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 11, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRun = new JLabel("R.U.N.:");
		lblRun.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRun.setBounds(10, 36, 111, 14);
		contentPane.add(lblRun);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEdad.setBounds(10, 61, 111, 14);
		contentPane.add(lblEdad);
		
		JLabel lblEstadoDeAprovacin = new JLabel("Estado de Aprovación:");
		lblEstadoDeAprovacin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstadoDeAprovacin.setBounds(10, 86, 111, 14);
		contentPane.add(lblEstadoDeAprovacin);
		
		JLabel lblHabilidades = new JLabel("Habilidades:");
		lblHabilidades.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHabilidades.setBounds(10, 133, 111, 14);
		contentPane.add(lblHabilidades);
		
		JLabel lblEstadoH = new JLabel();
		lblEstadoH.setBounds(131, 162, 293, 14);
		contentPane.add(lblEstadoH);
		
		ArrayList<String> nombreHabilidades = instituto.getNombreHabilidadesCurso(indiceCurso); 
		String [] arregloHabilidades = new String [nombreHabilidades.size()+1];
		arregloHabilidades[0] = "";
	    for(int index = 1 ; index <= nombreHabilidades.size();index++) 
    	{
	    	arregloHabilidades[index] = nombreHabilidades.get(index-1);
        }
		
		JComboBox<String[]> comboBox_Habilidades = new JComboBox<String[]>();
		comboBox_Habilidades.setModel(new DefaultComboBoxModel(arregloHabilidades));
		comboBox_Habilidades.setBounds(131, 129, 293, 22);
		comboBox_Habilidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox_Habilidades.getSelectedIndex() != 0)
                {
                    if (instituto.getEstadoHabilidad(indiceCurso, nombreAlumno, comboBox_Habilidades.getSelectedIndex()-1) == true)
                    {
                    	lblEstadoH.setText("Aprobado");
                    }
                    else
                    {
                    	lblEstadoH.setText("Reprobado");
                    }
                }
                else
                {
                	lblEstadoH.setText("");
                }
            }
        });
		contentPane.add(comboBox_Habilidades);
		
		JButton btnCambiarHabilidad = new JButton("Cambiar Estado Habilidad");
		//No muestra el valor antes

		btnCambiarHabilidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox_Habilidades.getSelectedIndex() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione una habilidad.");
                }
                else
                {
                    instituto.cambiarEstadoHabilidadesAlumnoNombre(indiceCurso, nombreAlumno, comboBox_Habilidades.getSelectedIndex()-1);
                    String mensajeAprovada;
                    if(instituto.getEstadoHabilidad(indiceCurso, nombreAlumno, comboBox_Habilidades.getSelectedIndex()-1)) mensajeAprovada = "Aprovada";
                    else mensajeAprovada = "Reprovada";
                    JOptionPane.showMessageDialog(null, "Habilidad cambiada a "+ mensajeAprovada);
                    if (instituto.getEstadoHabilidad(indiceCurso, nombreAlumno, comboBox_Habilidades.getSelectedIndex()-1) == true)
                    {
                    	lblEstadoH.setText("Aprobado");
                    }
                    else
                    {
                    	lblEstadoH.setText("Reprobado");
                    }
                }
            }
        });
		
		btnCambiarHabilidad.setBounds(131, 227, 179, 23);
		contentPane.add(btnCambiarHabilidad);
		
		JLabel lblEstadoHabilidad = new JLabel("Estado Habilidad:");
		lblEstadoHabilidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstadoHabilidad.setBounds(10, 162, 111, 14);
		contentPane.add(lblEstadoHabilidad);

	    Alumno alumnoAux = instituto.getCopiaCurso(indiceCurso).getAlumnoNombre(nombreAlumno);
		
		JLabel lblNewLabel_1 = new JLabel(alumnoAux.getNombre());
		lblNewLabel_1.setToolTipText("uwu");
		lblNewLabel_1.setBounds(131, 11, 293, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(Integer.toString(alumnoAux.getRUN()));
		lblNewLabel_1_1.setBounds(131, 36, 293, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(Integer.toString(alumnoAux.getEdad()));
		lblNewLabel_1_2.setBounds(131, 61, 293, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel();
		if (alumnoAux.getAprovacion())
        {
			lblNewLabel_1_3.setText("Aprobado");
        }
        else
        {
        	lblNewLabel_1_3.setText("Reprobado");
        }
		lblNewLabel_1_3.setBounds(131, 86, 293, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 414, 2);
		contentPane.add(separator);
		
		JButton btnEditarAlumno = new JButton("Editar Alumno");
		btnEditarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEditarAlumno ventanaEditarAlumno = new VentanaEditarAlumno(instituto, indiceCurso, nombreAlumno, flag, flag2);
				ventanaEditarAlumno.setVisible(true);
				dispose();
			}
		});
		btnEditarAlumno.setBounds(326, 42, 99, 23);
		contentPane.add(btnEditarAlumno);
	}
}
