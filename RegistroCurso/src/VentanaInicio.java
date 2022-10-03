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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame
{

	private JPanel contentPane;

	public VentanaInicio(Instituto instituto)
	{
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
		btn_Ingresar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		    	File testFile = new File("Guardado.txt");
		    	FileWriter testFileWriter;
		    	PrintWriter printWriterTestFile;
		    	//Guardando para Cargar
				try
				{
					testFileWriter = new FileWriter(testFile);
					printWriterTestFile = new PrintWriter(testFileWriter);
			    	
			    	for (int cont = 0; cont < instituto.getTamaño(); cont += 1)
			    	{
			    		Curso cursoTemp1 = instituto.getCopiaCurso(cont);
			        	Enumeration<Integer> enu1 = instituto.getKeysAlumnosCurso(cont);
			        	cursoTemp1.updateFile(testFile,testFileWriter,printWriterTestFile,enu1);
			        	printWriterTestFile.write("\n*****\n");
			    	}
			    	printWriterTestFile.write("—————");
			    	printWriterTestFile.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//Guardando csv bonito
				testFile = new File("DatosInstituto.csv");
				try
				{
					testFileWriter = new FileWriter(testFile);
					printWriterTestFile = new PrintWriter(testFileWriter);
			    	
			    	for (int cont = 0; cont < instituto.getTamaño(); cont += 1)
			    	{
			    		Curso cursoTemp1 = instituto.getCopiaCurso(cont);
			        	Enumeration<Integer> enu1 = instituto.getKeysAlumnosCurso(cont);
			        	cursoTemp1.guardarCSVBonito(testFile, testFileWriter,  printWriterTestFile, enu1);
			        	printWriterTestFile.write("\n\n");
			    	}
			    	printWriterTestFile.write("");
			    	printWriterTestFile.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    	
				System.exit(0);
			}
		});
		//Pido disculpas por el hecho de no dejarlo centrado
		btnGuardarYSalir.setBounds(159, 159, 117, 23);
		contentPane.add(btnGuardarYSalir);
	}
}
