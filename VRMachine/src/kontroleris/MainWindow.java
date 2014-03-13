package kontroleris;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Component;
import java.awt.SystemColor;


public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtf;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtF;
	private JTextField textField_7;
	private JTextField txtV;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 404);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 319, 142);
		contentPane.add(panel);
		panel.setLayout(null);

		textField_3 = new JTextField();
		textField_3.setBounds(85, 11, 35, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("AR");
		lblNewLabel.setBounds(10, 14, 20, 14);
		panel.add(lblNewLabel);

		textField = new JTextField("0000");
		textField.setBounds(40, 11, 35, 20);
		panel.add(textField);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("BR");
		lblNewLabel_1.setBounds(10, 39, 20, 14);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField("0000");
		textField_1.setBounds(40, 37, 35, 20);
		panel.add(textField_1);
		textField_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("IP");
		lblNewLabel_2.setBounds(10, 64, 20, 14);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField("0000");
		textField_2.setBounds(40, 61, 35, 20);
		panel.add(textField_2);
		textField_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("SF");
		lblNewLabel_3.setBounds(10, 89, 20, 14);
		panel.add(lblNewLabel_3);

		txtf = new JTextField("0");
		txtf.setBounds(40, 86, 14, 20);
		panel.add(txtf);
		txtf.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtf.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(85, 36, 35, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(85, 61, 35, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);

		txtF = new JTextField();
		txtF.setText("0");
		txtF.setBounds(85, 86, 14, 20);
		panel.add(txtF);
		txtF.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("VM");
		lblNewLabel_4.setBounds(95, 117, 20, 14);
		panel.add(lblNewLabel_4);

		JLabel lblRm = new JLabel("RM");
		lblRm.setBounds(50, 117, 20, 14);
		panel.add(lblRm);

		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setBounds(189, 11, 35, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblTimer = new JLabel("TIMER");
		lblTimer.setBounds(144, 14, 35, 14);
		panel.add(lblTimer);

		JLabel lblMode = new JLabel("MODE");
		lblMode.setBounds(144, 39, 46, 14);
		panel.add(lblMode);

		JLabel lblPtr = new JLabel("PTR");
		lblPtr.setBounds(144, 64, 46, 14);
		panel.add(lblPtr);

		txtV = new JTextField();
		txtV.setText("0");
		txtV.setBounds(189, 36, 35, 20);
		panel.add(txtV);
		txtV.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setText("0000");
		textField_9.setBounds(189, 61, 35, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);

		JLabel lblSi = new JLabel("PI");
		lblSi.setBounds(250, 14, 20, 14);
		panel.add(lblSi);

		JLabel lblPi = new JLabel("SI");
		lblPi.setBounds(250, 39, 20, 14);
		panel.add(lblPi);

		JLabel lblTi = new JLabel("TI");
		lblTi.setBounds(250, 64, 20, 14);
		panel.add(lblTi);

		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setBounds(280, 11, 20, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setBounds(280, 36, 20, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setBounds(280, 61, 20, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
	}
	
	public void changeField(String name){
		textField_1.setText(name);
		System.out.println("Ilgis: " + name.length());
	}

}
