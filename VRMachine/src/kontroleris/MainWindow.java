package kontroleris;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

import java.awt.TextField;
import java.awt.Button;

import javax.swing.SwingConstants;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// --------REGISTRAI--------------------
	private JTextField text_reg_RM_AR;
	private JTextField text_reg_RM_BR;
	private JTextField text_reg_RM_IP;
	private JTextField text_flag_RM_Z;
	private JTextField text_flag_RM_C;
	private JTextField text_flag_RM_B;
	private JTextField text_flag_RM_S;

	private JTextField text_reg_VM_AR;
	private JTextField text_reg_VM_BR;
	private JTextField text_reg_VM_IP;
	private JTextField text_flag_VM_Z;
	private JTextField text_flag_VM_C;
	private JTextField text_flag_VM_B;
	private JTextField text_flag_VM_S;

	private JTextField text_reg_TIMER;
	private JTextField text_reg_MODE;
	private JTextField text_reg_PTR;

	private JTextField text_reg_PI;
	private JTextField text_reg_SI;
	private JTextField text_reg_TI;

	private JTextField text_reg_CHST_Input;
	private JTextField text_reg_CHST_EMemory;
	private JTextField text_reg_CHST_Lempute;
	private JTextField text_reg_CHST_Output;
	// --------------------------------------

	// --------ATMINTIES-LANGAI--------------
	private JScrollPane scrollPane_VA;
	private JList<String> list_EM;

	private JScrollPane scrollPane_RA;
	private JList<String> list_VM;

	private JScrollPane scrollPane_EM;
	private JList<String> list_RM;

	private static DefaultListModel<String> listEMemory;

	// --------------------------------------

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Virtuali Maðina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 421);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ------------REGISTRAI--------------------------------------------
		JPanel panel_registrai = new JPanel();
		panel_registrai.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_registrai.setBounds(10, 0, 378, 183);
		contentPane.add(panel_registrai);
		panel_registrai.setLayout(null);

		JLabel lbl_VM = new JLabel("VM");
		lbl_VM.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_VM.setBounds(80, 0, 35, 20);
		panel_registrai.add(lbl_VM);

		JLabel lbl_RM = new JLabel("RM");
		lbl_RM.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RM.setBounds(30, 0, 35, 20);
		panel_registrai.add(lbl_RM);

		// ---AR---
		JLabel lbl_reg_AR = new JLabel("AR");
		lbl_reg_AR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_AR.setBounds(10, 20, 20, 20);
		panel_registrai.add(lbl_reg_AR);

		text_reg_RM_AR = new JTextField("0000");
		text_reg_RM_AR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_RM_AR.setBounds(30, 20, 40, 20);
		panel_registrai.add(text_reg_RM_AR);
		text_reg_RM_AR.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_RM_AR.setColumns(10);

		text_reg_VM_AR = new JTextField();
		text_reg_VM_AR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_VM_AR.setText("0000");
		text_reg_VM_AR.setBounds(80, 20, 40, 20);
		panel_registrai.add(text_reg_VM_AR);
		text_reg_VM_AR.setColumns(10);

		// ---BR---
		JLabel lbl_reg_BR = new JLabel("BR");
		lbl_reg_BR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_BR.setBounds(10, 45, 20, 20);
		panel_registrai.add(lbl_reg_BR);

		text_reg_RM_BR = new JTextField("0000");
		text_reg_RM_BR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_RM_BR.setBounds(30, 45, 40, 20);
		panel_registrai.add(text_reg_RM_BR);
		text_reg_RM_BR.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_RM_BR.setColumns(10);

		text_reg_VM_BR = new JTextField();
		text_reg_VM_BR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_VM_BR.setText("0000");
		text_reg_VM_BR.setBounds(80, 45, 40, 20);
		panel_registrai.add(text_reg_VM_BR);
		text_reg_VM_BR.setColumns(10);

		// ---IP---
		JLabel lbl_reg_IP = new JLabel("IP");
		lbl_reg_IP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_IP.setBounds(10, 70, 20, 20);
		panel_registrai.add(lbl_reg_IP);

		text_reg_RM_IP = new JTextField("0000");
		text_reg_RM_IP.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_RM_IP.setBounds(30, 70, 40, 20);
		panel_registrai.add(text_reg_RM_IP);
		text_reg_RM_IP.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_RM_IP
				.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		text_reg_RM_IP.setColumns(10);

		text_reg_VM_IP = new JTextField();
		text_reg_VM_IP.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_VM_IP.setText("0000");
		text_reg_VM_IP.setBounds(80, 70, 40, 20);
		panel_registrai.add(text_reg_VM_IP);
		text_reg_VM_IP.setColumns(10);

		// ---TIMER---
		JLabel lbl_reg_TIMER = new JLabel("TIMER");
		lbl_reg_TIMER.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_TIMER.setBounds(140, 20, 40, 20);
		panel_registrai.add(lbl_reg_TIMER);

		text_reg_TIMER = new JTextField();
		text_reg_TIMER.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_TIMER.setText("0");
		text_reg_TIMER.setBounds(180, 20, 40, 20);
		panel_registrai.add(text_reg_TIMER);
		text_reg_TIMER.setColumns(10);

		// ---MODE---
		JLabel lbl_reg_MODE = new JLabel("MODE");
		lbl_reg_MODE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_MODE.setBounds(140, 45, 40, 20);
		panel_registrai.add(lbl_reg_MODE);

		text_reg_MODE = new JTextField();
		text_reg_MODE.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_MODE.setText("0");
		text_reg_MODE.setBounds(180, 45, 40, 20);
		panel_registrai.add(text_reg_MODE);
		text_reg_MODE.setColumns(10);

		// ---PTR---
		JLabel lbl_reg_PTR = new JLabel("PTR");
		lbl_reg_PTR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_PTR.setBounds(140, 70, 40, 20);
		panel_registrai.add(lbl_reg_PTR);

		text_reg_PTR = new JTextField();
		text_reg_PTR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_PTR.setText("0000");
		text_reg_PTR.setBounds(180, 70, 40, 20);
		panel_registrai.add(text_reg_PTR);
		text_reg_PTR.setColumns(10);

		// ---PI---
		JLabel lbl_reg_PI = new JLabel("PI");
		lbl_reg_PI.setBounds(280, 20, 20, 20);
		panel_registrai.add(lbl_reg_PI);

		text_reg_PI = new JTextField();
		text_reg_PI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_PI.setText("0");
		text_reg_PI.setBounds(300, 20, 20, 20);
		panel_registrai.add(text_reg_PI);
		text_reg_PI.setColumns(10);

		// ---SI---
		JLabel lbl_reg_SI = new JLabel("SI");
		lbl_reg_SI.setBounds(280, 45, 20, 20);
		panel_registrai.add(lbl_reg_SI);

		text_reg_SI = new JTextField();
		text_reg_SI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_SI.setText("0");
		text_reg_SI.setBounds(300, 45, 20, 20);
		panel_registrai.add(text_reg_SI);
		text_reg_SI.setColumns(10);

		// ---TI---
		JLabel lbl_reg_TI = new JLabel("TI");
		lbl_reg_TI.setBounds(280, 70, 20, 20);
		panel_registrai.add(lbl_reg_TI);

		text_reg_TI = new JTextField();
		text_reg_TI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_TI.setText("0");
		text_reg_TI.setBounds(300, 70, 20, 20);
		panel_registrai.add(text_reg_TI);
		text_reg_TI.setColumns(10);

		JLabel lbl_reg_CHST = new JLabel("CHST");
		lbl_reg_CHST.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST.setBounds(140, 95, 40, 20);
		panel_registrai.add(lbl_reg_CHST);

		// ---SF---
		JLabel lbl_reg_SF = new JLabel("SF");
		lbl_reg_SF.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_SF.setBounds(10, 95, 20, 20);
		panel_registrai.add(lbl_reg_SF);

		JPanel panel_RM_SF = new JPanel();
		panel_RM_SF.setLayout(null);
		panel_RM_SF.setBounds(30, 95, 40, 80);
		panel_registrai.add(panel_RM_SF);

		JLabel lbl_flag_RM_Z = new JLabel("Z");
		lbl_flag_RM_Z.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_Z.setBounds(0, 0, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_Z);

		text_flag_RM_Z = new JTextField("0");
		text_flag_RM_Z.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_RM_Z.setColumns(10);
		text_flag_RM_Z.setAlignmentX(0.0f);
		text_flag_RM_Z.setBounds(20, 0, 20, 20);
		panel_RM_SF.add(text_flag_RM_Z);

		JLabel lbl_flag_RM_C = new JLabel("C");
		lbl_flag_RM_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_C.setBounds(0, 20, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_C);

		text_flag_RM_C = new JTextField();
		text_flag_RM_C.setText("0");
		text_flag_RM_C.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_RM_C.setColumns(10);
		text_flag_RM_C.setBounds(20, 20, 20, 20);
		panel_RM_SF.add(text_flag_RM_C);

		JLabel lbl_flag_RM_S = new JLabel("S");
		lbl_flag_RM_S.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_S.setBounds(0, 40, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_S);

		text_flag_RM_S = new JTextField();
		text_flag_RM_S.setText("0");
		text_flag_RM_S.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_RM_S.setColumns(10);
		text_flag_RM_S.setBounds(20, 40, 20, 20);
		panel_RM_SF.add(text_flag_RM_S);

		JLabel lbl_flag_RM_B = new JLabel("B");
		lbl_flag_RM_B.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_B.setBounds(0, 60, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_B);

		text_flag_RM_B = new JTextField();
		text_flag_RM_B.setText("0");
		text_flag_RM_B.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_RM_B.setColumns(10);
		text_flag_RM_B.setBounds(20, 60, 20, 20);
		panel_RM_SF.add(text_flag_RM_B);

		JPanel panel_VM_SF = new JPanel();
		panel_VM_SF.setLayout(null);
		panel_VM_SF.setBounds(80, 95, 40, 80);
		panel_registrai.add(panel_VM_SF);

		JLabel lbl_flag_VM_Z = new JLabel("Z");
		lbl_flag_VM_Z.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_VM_Z.setBounds(0, 0, 20, 20);
		panel_VM_SF.add(lbl_flag_VM_Z);

		text_flag_VM_Z = new JTextField("0");
		text_flag_VM_Z.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_VM_Z.setColumns(10);
		text_flag_VM_Z.setAlignmentX(0.0f);
		text_flag_VM_Z.setBounds(20, 0, 20, 20);
		panel_VM_SF.add(text_flag_VM_Z);

		JLabel lbl_flag_VM_C = new JLabel("C");
		lbl_flag_VM_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_VM_C.setBounds(0, 20, 20, 20);
		panel_VM_SF.add(lbl_flag_VM_C);

		text_flag_VM_C = new JTextField();
		text_flag_VM_C.setText("0");
		text_flag_VM_C.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_VM_C.setColumns(10);
		text_flag_VM_C.setBounds(20, 20, 20, 20);
		panel_VM_SF.add(text_flag_VM_C);

		JLabel lbl_flag_VM_S = new JLabel("S");
		lbl_flag_VM_S.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_VM_S.setBounds(0, 40, 20, 20);
		panel_VM_SF.add(lbl_flag_VM_S);

		text_flag_VM_S = new JTextField();
		text_flag_VM_S.setText("0");
		text_flag_VM_S.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_VM_S.setColumns(10);
		text_flag_VM_S.setBounds(20, 40, 20, 20);
		panel_VM_SF.add(text_flag_VM_S);

		JLabel lbl_flag_VM_B = new JLabel("B");
		lbl_flag_VM_B.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_VM_B.setBounds(0, 60, 20, 20);
		panel_VM_SF.add(lbl_flag_VM_B);

		text_flag_VM_B = new JTextField();
		text_flag_VM_B.setText("0");
		text_flag_VM_B.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_VM_B.setColumns(10);
		text_flag_VM_B.setBounds(20, 60, 20, 20);
		panel_VM_SF.add(text_flag_VM_B);

		// ---CHST[]---
		JLabel lbl_reg_CHST_Input = new JLabel("I");
		lbl_reg_CHST_Input.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Input.setBounds(180, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Input);

		text_reg_CHST_Input = new JTextField();
		text_reg_CHST_Input.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Input.setText("0");
		text_reg_CHST_Input.setBounds(180, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Input);
		text_reg_CHST_Input.setColumns(10);

		JLabel lbl_reg_CHST_Output = new JLabel("O");
		lbl_reg_CHST_Output.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Output.setBounds(200, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Output);

		text_reg_CHST_Output = new JTextField();
		text_reg_CHST_Output.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Output.setText("0");
		text_reg_CHST_Output.setBounds(200, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Output);
		text_reg_CHST_Output.setColumns(10);

		JLabel lbl_reg_CHST_EMemory = new JLabel("EM");
		lbl_reg_CHST_EMemory.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_EMemory.setBounds(220, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_EMemory);

		text_reg_CHST_EMemory = new JTextField();
		text_reg_CHST_EMemory.setText("0");
		text_reg_CHST_EMemory.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_EMemory.setBounds(220, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_EMemory);
		text_reg_CHST_EMemory.setColumns(10);

		JLabel lbl_reg_CHST_Lempute = new JLabel("L");
		lbl_reg_CHST_Lempute.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Lempute.setBounds(240, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Lempute);

		text_reg_CHST_Lempute = new JTextField();
		text_reg_CHST_Lempute.setText("0");
		text_reg_CHST_Lempute.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Lempute.setBounds(240, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Lempute);
		text_reg_CHST_Lempute.setColumns(10);
		// ----------------------------------------------------------------

		// ------------ATMINTIS--------------------------------------------
		JPanel panel_atmintis = new JPanel();
		panel_atmintis.setBounds(400, 0, 502, 370);
		contentPane.add(panel_atmintis);
		panel_atmintis.setLayout(null);

		// ---ISORINE---
		listEMemory = new DefaultListModel<String>();
		for (int i = 0; i < 16; i++) {
			for (int n = 0; n < 16; n++) {
				listEMemory.addElement(String.format("%02X", i * 16 + n) + ": "+ "0000");
			}
		}

		JLabel lblEm = new JLabel("EM");
		lblEm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEm.setBounds(10, 0, 150, 20);
		panel_atmintis.add(lblEm);

		scrollPane_EM = new JScrollPane();
		scrollPane_EM.setBounds(10, 20, 150, 340);
		panel_atmintis.add(scrollPane_EM);

		list_EM = new JList<String>(listEMemory);
		scrollPane_EM.setViewportView(list_EM);

		// ---REALI---
		JLabel lblNewLabel = new JLabel("RA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 0, 150, 20);
		panel_atmintis.add(lblNewLabel);

		scrollPane_RA = new JScrollPane();
		scrollPane_RA.setBounds(175, 20, 150, 340);
		panel_atmintis.add(scrollPane_RA);

		list_RM = new JList<String>();
		scrollPane_RA.setViewportView(list_RM);

		// ---VIRTUALI---
		JLabel lblVm = new JLabel("VA");
		lblVm.setHorizontalAlignment(SwingConstants.CENTER);
		lblVm.setBounds(340, 0, 150, 20);
		panel_atmintis.add(lblVm);

		scrollPane_VA = new JScrollPane();
		scrollPane_VA.setBounds(340, 20, 150, 340);
		panel_atmintis.add(scrollPane_VA);

		list_VM = new JList<String>();
		scrollPane_VA.setViewportView(list_VM);
		// -----------------------------------------------------------------

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 378, 2);
		contentPane.add(separator);

		// ------------KONSOLE--------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 378, 94);
		contentPane.add(scrollPane);

		JTextPane txtpnconsole = new JTextPane();
		scrollPane.setViewportView(txtpnconsole);
		txtpnconsole.setText(">>> Console");
		txtpnconsole.setEditable(false);

		TextField console = new TextField();
		console.setBounds(10, 307, 378, 22);
		contentPane.add(console);
		// ----------------------------------------------------------------

		// ------------MYGTUKAI--------------------------------------------
		Button btn_Load = new Button("Pakrauti program\u0105");
		btn_Load.setBounds(10, 335, 111, 22);
		contentPane.add(btn_Load);

		Button btn_Start = new Button("Vykdyti");
		btn_Start.setBounds(127, 335, 83, 22);
		contentPane.add(btn_Start);

		Button btn_End = new Button("Pabaigti");
		btn_End.setBounds(216, 335, 83, 22);
		contentPane.add(btn_End);

		Button btn_Step = new Button("Po \u017Eingsn\u012F");
		btn_Step.setBounds(305, 335, 83, 22);
		contentPane.add(btn_Step);
		// -----------------------------------------------------------------
	}

	public void set(String register, String value) {
		if (register == "RM_AR") {
			text_reg_RM_AR.setText(value);
		}
		if (register == "RM_BR") {
			text_reg_RM_BR.setText(value);
		}
		if (register == "RM_IP") {
			text_reg_RM_IP.setText(value);
		}
		if (register == "RM_Z") {
			text_flag_RM_Z.setText(value);
		}
		if (register == "RM_C") {
			text_flag_RM_C.setText(value);
		}
		if (register == "RM_B") {
			text_flag_RM_B.setText(value);
		}
		if (register == "RM_S") {
			text_flag_RM_S.setText(value);
		}
		if (register == "VM_AR") {
			text_reg_VM_AR.setText(value);
		}
		if (register == "VM_BR") {
			text_reg_VM_BR.setText(value);
		}
		if (register == "VM_IP") {
			text_reg_VM_IP.setText(value);
		}
		if (register == "VM_Z") {
			text_flag_VM_Z.setText(value);
		}
		if (register == "VM_C") {
			text_flag_VM_C.setText(value);
		}
		if (register == "VM_B") {
			text_flag_VM_B.setText(value);
		}
		if (register == "VM_S") {
			text_flag_VM_S.setText(value);
		}
		if (register == "TIMER") {
			text_reg_TIMER.setText(value);
		}
		if (register == "MODE") {
			text_reg_MODE.setText(value);
		}
		if (register == "PTR") {
			text_reg_PTR.setText(value);
		}
		if (register == "PI") {
			text_reg_PI.setText(value);
		}
		if (register == "SI") {
			text_reg_SI.setText(value);
		}
		if (register == "TI") {
			text_reg_TI.setText(value);
		}
		if (register == "INPUT") {
			text_reg_CHST_Input.setText(value);
		}
		if (register == "EMEMORY") {
			text_reg_CHST_EMemory.setText(value);
		}
		if (register == "LEMPUTE") {
			text_reg_CHST_Lempute.setText(value);
		}
		if (register == "OUTPUT") {
			text_reg_CHST_Output.setText(value);
		}
	}
	
	public String get(String register) {
		if (register == "RM_AR") {
			return text_reg_RM_AR.getText();
		}
		if (register == "RM_BR") {
			return text_reg_RM_BR.getText();
		}
		if (register == "RM_IP") {
			return text_reg_RM_IP.getText();
		}
		if (register == "RM_Z") {
			return text_flag_RM_Z.getText();
		}
		if (register == "RM_C") {
			return text_flag_RM_C.getText();
		}
		if (register == "RM_B") {
			return text_flag_RM_B.getText();
		}
		if (register == "RM_S") {
			return text_flag_RM_S.getText();
		}
		if (register == "VM_AR") {
			return text_reg_VM_AR.getText();
		}
		if (register == "VM_BR") {
			return text_reg_VM_BR.getText();
		}
		if (register == "VM_IP") {
			return text_reg_VM_IP.getText();
		}
		if (register == "VM_Z") {
			return text_flag_VM_Z.getText();
		}
		if (register == "VM_C") {
			return text_flag_VM_C.getText();
		}
		if (register == "VM_B") {
			return text_flag_VM_B.getText();
		}
		if (register == "VM_S") {
			return text_flag_VM_S.getText();
		}
		if (register == "TIMER") {
			return text_reg_TIMER.getText();
		}
		if (register == "MODE") {
			return text_reg_MODE.getText();
		}
		if (register == "PTR") {
			return text_reg_PTR.getText();
		}
		if (register == "PI") {
			return text_reg_PI.getText();
		}
		if (register == "SI") {
			return text_reg_SI.getText();
		}
		if (register == "TI") {
			return text_reg_TI.getText();
		}
		if (register == "INPUT") {
			return text_reg_CHST_Input.getText();
		}
		if (register == "EMEMORY") {
			return text_reg_CHST_EMemory.getText();
		}
		if (register == "LEMPUTE") {
			return text_reg_CHST_Lempute.getText();
		}
		if (register == "OUTPUT") {
			return text_reg_CHST_Output.getText();
		}
		
		return "Klaida!";
	}
}
