package conversor;
import java.text.DecimalFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class conversor extends JFrame {

	private JPanel contentPane;
	private JTextField monto;
	private JComboBox opciones;
	private JButton convertirBtn;
	private JLabel resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversor frame = new conversor();
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
	public conversor() {
		setTitle("Conversor Alura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 444);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Moneda");
		lblNewLabel.setBounds(195, 36, 346, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setBounds(226, 153, 179, 31);
		opciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"Pesos a Dolares", "Dolares a Pesos"}));
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el Monto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 227, 156, 25);
		contentPane.add(lblNewLabel_1);
		
		monto = new JTextField();
		monto.setBounds(259, 221, 146, 31);
		contentPane.add(monto);
		monto.setColumns(10);
		
		convertirBtn = new JButton("Convertir");
		convertirBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String monto2 = monto.getText();
				double valorNum = Double.parseDouble(monto2);
				
				double tipoCambio = 4000;
				double resultadoFinal = 0;
				
				DecimalFormat formato = new DecimalFormat("0.0");
				
				if(opciones.getSelectedIndex() == 0) {
					resultadoFinal = (valorNum / tipoCambio);
					resultado.setText("resultado :"+formato.format(resultadoFinal) + " Dolares");
				}else if(opciones.getSelectedIndex() == 1) {
					resultadoFinal = valorNum * tipoCambio;
					resultado.setText("resultado :"+resultadoFinal + " Pesos");
				}
			}
		});
		convertirBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		convertirBtn.setBounds(109, 335, 130, 38);
		contentPane.add(convertirBtn);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(506, 336, 146, 37);
		contentPane.add(btnSalir);
		
		resultado = new JLabel("0");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultado.setBounds(68, 278, 488, 25);
		contentPane.add(resultado);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\RYZEN\\Desktop\\MARCA-CON-VOLAMOS3.png"));
		lblNewLabel_3.setBounds(465, 167, 199, 64);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Convertir");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(109, 149, 96, 38);
		contentPane.add(lblNewLabel_4);
	}
}
