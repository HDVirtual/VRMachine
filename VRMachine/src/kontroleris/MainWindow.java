package kontroleris;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

import java.awt.TextField;
import java.awt.Button;

import javax.swing.SwingConstants;

import RM.RM;
import RM.RealMemory;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// --------REGISTRAI--------------------
	private static JTextField text_reg_AR;
	private static JTextField text_reg_BR;
	private static JTextField text_reg_IP;
	private static JTextField text_flag_Z;
	private static JTextField text_flag_C;
	private static JTextField text_flag_B;
	private static JTextField text_flag_S;

	private static JTextField text_reg_TIMER;
	private static JTextField text_reg_MODE;
	private static JTextField text_reg_PTR;

	private static JTextField text_reg_PI;
	private static JTextField text_reg_SI;
	private static JTextField text_reg_TI;

	private static JTextField text_reg_CHST_Input;
	private static JTextField text_reg_CHST_EMemory;
	private static JTextField text_reg_CHST_Lempute;
	private static JTextField text_reg_CHST_Output;
	// --------------------------------------

	private JFileChooser fc;
	private static DefaultListModel<String> listModel;
	private static JTextPane txtpnconsole;

	// --------ATMINTIES-LANGAI--------------
	private static JScrollPane scrollPane_VA;

	private static JScrollPane scrollPane_RA;

	private static JScrollPane scrollPane_EM;

	private static JTextField textField;
	private JTable table_VA;
	private static JTable table_RA;
	private JTable table_EM;

	private static Canvas canvas_Lempute;

	// --------------------------------------

	// -----ATMINTIES-LENTELES-STRUKTURA----
	public static Object[] EMcolumnNames;
	public static Object[][] EMdata;
	public static Object[] RMcolumnNames;
	public static Object[][] RMdata;

	Button btn_Load = new Button("Pakrauti program\u0105");
	Button btn_Start = new Button("Vykdyti");
	Button btn_End = new Button("Pabaigti");
	Button btn_Step = new Button("Po \u017Eingsn\u012F");

	// -------------------------------------

	/**
	 * Create the frame.
	 */
	public MainWindow(final RM rm) {
		setTitle("Virtuali Ma�ina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 538);
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
		panel_registrai.setBounds(10, 0, 380, 183);
		contentPane.add(panel_registrai);
		panel_registrai.setLayout(null);

		// ---AR---
		JLabel lbl_reg_AR = new JLabel("AR");
		lbl_reg_AR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_AR.setBounds(10, 20, 20, 20);
		panel_registrai.add(lbl_reg_AR);

		text_reg_AR = new JTextField("0000");
		text_reg_AR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_AR.setBounds(30, 20, 40, 20);
		panel_registrai.add(text_reg_AR);
		text_reg_AR.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_AR.setColumns(10);

		// ---BR---
		JLabel lbl_reg_BR = new JLabel("BR");
		lbl_reg_BR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_BR.setBounds(10, 45, 20, 20);
		panel_registrai.add(lbl_reg_BR);

		text_reg_BR = new JTextField("0000");
		text_reg_BR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_BR.setBounds(30, 45, 40, 20);
		panel_registrai.add(text_reg_BR);
		text_reg_BR.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_BR.setColumns(10);

		// ---IP---
		JLabel lbl_reg_IP = new JLabel("IP");
		lbl_reg_IP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_IP.setBounds(10, 70, 20, 20);
		panel_registrai.add(lbl_reg_IP);

		text_reg_IP = new JTextField("0000");
		text_reg_IP.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_IP.setBounds(30, 70, 40, 20);
		panel_registrai.add(text_reg_IP);
		text_reg_IP.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_reg_IP.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		text_reg_IP.setColumns(10);

		// ---TIMER---
		JLabel lbl_reg_TIMER = new JLabel("TIMER");
		lbl_reg_TIMER.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_TIMER.setBounds(90, 20, 40, 20);
		panel_registrai.add(lbl_reg_TIMER);

		text_reg_TIMER = new JTextField();
		text_reg_TIMER.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_TIMER.setText("0");
		text_reg_TIMER.setBounds(130, 20, 40, 20);
		panel_registrai.add(text_reg_TIMER);
		text_reg_TIMER.setColumns(10);

		// ---MODE---
		JLabel lbl_reg_MODE = new JLabel("MODE");
		lbl_reg_MODE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_MODE.setBounds(90, 45, 40, 20);
		panel_registrai.add(lbl_reg_MODE);

		text_reg_MODE = new JTextField();
		text_reg_MODE.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_MODE.setText("0");
		text_reg_MODE.setBounds(130, 45, 40, 20);
		panel_registrai.add(text_reg_MODE);
		text_reg_MODE.setColumns(10);

		// ---PTR---
		JLabel lbl_reg_PTR = new JLabel("PTR");
		lbl_reg_PTR.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_PTR.setBounds(90, 70, 40, 20);
		panel_registrai.add(lbl_reg_PTR);

		text_reg_PTR = new JTextField();
		text_reg_PTR.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_PTR.setText("0000");
		text_reg_PTR.setBounds(130, 70, 40, 20);
		panel_registrai.add(text_reg_PTR);
		text_reg_PTR.setColumns(10);

		// ---PI---
		JLabel lbl_reg_PI = new JLabel("PI");
		lbl_reg_PI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_PI.setBounds(230, 20, 20, 20);
		panel_registrai.add(lbl_reg_PI);

		text_reg_PI = new JTextField();
		text_reg_PI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_PI.setText("0");
		text_reg_PI.setBounds(250, 20, 20, 20);
		panel_registrai.add(text_reg_PI);
		text_reg_PI.setColumns(10);

		// ---SI---
		JLabel lbl_reg_SI = new JLabel("SI");
		lbl_reg_SI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_SI.setBounds(230, 45, 20, 20);
		panel_registrai.add(lbl_reg_SI);

		text_reg_SI = new JTextField();
		text_reg_SI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_SI.setText("0");
		text_reg_SI.setBounds(250, 45, 20, 20);
		panel_registrai.add(text_reg_SI);
		text_reg_SI.setColumns(10);

		// ---TI---
		JLabel lbl_reg_TI = new JLabel("TI");
		lbl_reg_TI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_TI.setBounds(230, 70, 20, 20);
		panel_registrai.add(lbl_reg_TI);

		text_reg_TI = new JTextField();
		text_reg_TI.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_TI.setText("0");
		text_reg_TI.setBounds(250, 70, 20, 20);
		panel_registrai.add(text_reg_TI);
		text_reg_TI.setColumns(10);

		JLabel lbl_reg_CHST = new JLabel("CHST");
		lbl_reg_CHST.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST.setBounds(90, 95, 40, 20);
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

		text_flag_Z = new JTextField("0");
		text_flag_Z.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_Z.setColumns(10);
		text_flag_Z.setAlignmentX(0.0f);
		text_flag_Z.setBounds(20, 0, 20, 20);
		panel_RM_SF.add(text_flag_Z);

		JLabel lbl_flag_RM_C = new JLabel("C");
		lbl_flag_RM_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_C.setBounds(0, 20, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_C);

		text_flag_C = new JTextField();
		text_flag_C.setText("0");
		text_flag_C.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_C.setColumns(10);
		text_flag_C.setBounds(20, 20, 20, 20);
		panel_RM_SF.add(text_flag_C);

		JLabel lbl_flag_RM_S = new JLabel("S");
		lbl_flag_RM_S.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_S.setBounds(0, 40, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_S);

		text_flag_S = new JTextField();
		text_flag_S.setText("0");
		text_flag_S.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_S.setColumns(10);
		text_flag_S.setBounds(20, 40, 20, 20);
		panel_RM_SF.add(text_flag_S);

		JLabel lbl_flag_RM_B = new JLabel("B");
		lbl_flag_RM_B.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flag_RM_B.setBounds(0, 60, 20, 20);
		panel_RM_SF.add(lbl_flag_RM_B);

		text_flag_B = new JTextField();
		text_flag_B.setText("0");
		text_flag_B.setHorizontalAlignment(SwingConstants.CENTER);
		text_flag_B.setColumns(10);
		text_flag_B.setBounds(20, 60, 20, 20);
		panel_RM_SF.add(text_flag_B);

		// ---CHST[]---
		JLabel lbl_reg_CHST_Input = new JLabel("I");
		lbl_reg_CHST_Input.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Input.setBounds(130, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Input);

		text_reg_CHST_Input = new JTextField();
		text_reg_CHST_Input.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Input.setText("0");
		text_reg_CHST_Input.setBounds(130, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Input);
		text_reg_CHST_Input.setColumns(10);

		JLabel lbl_reg_CHST_Output = new JLabel("O");
		lbl_reg_CHST_Output.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Output.setBounds(150, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Output);

		text_reg_CHST_Output = new JTextField();
		text_reg_CHST_Output.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Output.setText("0");
		text_reg_CHST_Output.setBounds(150, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Output);
		text_reg_CHST_Output.setColumns(10);

		JLabel lbl_reg_CHST_EMemory = new JLabel("EM");
		lbl_reg_CHST_EMemory.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_EMemory.setBounds(170, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_EMemory);

		text_reg_CHST_EMemory = new JTextField();
		text_reg_CHST_EMemory.setText("0");
		text_reg_CHST_EMemory.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_EMemory.setBounds(170, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_EMemory);
		text_reg_CHST_EMemory.setColumns(10);

		JLabel lbl_reg_CHST_Lempute = new JLabel("L");
		lbl_reg_CHST_Lempute.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_reg_CHST_Lempute.setBounds(190, 115, 20, 20);
		panel_registrai.add(lbl_reg_CHST_Lempute);

		text_reg_CHST_Lempute = new JTextField();
		text_reg_CHST_Lempute.setText("0");
		text_reg_CHST_Lempute.setHorizontalAlignment(SwingConstants.CENTER);
		text_reg_CHST_Lempute.setBounds(190, 95, 20, 20);
		panel_registrai.add(text_reg_CHST_Lempute);
		text_reg_CHST_Lempute.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("BAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(90, 137, 40, 20);
		panel_registrai.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("00");
		textField.setBounds(130, 137, 40, 20);
		panel_registrai.add(textField);
		textField.setColumns(10);
		// ----------------------------------------------------------------

		// ------------ATMINTIS--------------------------------------------
		JPanel panel_atmintis = new JPanel();
		panel_atmintis.setBounds(400, 0, 753, 506);
		contentPane.add(panel_atmintis);
		panel_atmintis.setLayout(null);

		// ---ISORINE---

		JLabel lblEm = new JLabel("EM");
		lblEm.setBounds(10, 20, 20, 150);
		panel_atmintis.add(lblEm);

		scrollPane_EM = new JScrollPane();
		scrollPane_EM.setBounds(30, 20, 700, 150);
		panel_atmintis.add(scrollPane_EM);

		table_EM = new JTable();
		table_EM.setRowSelectionAllowed(false);
		table_EM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_EM.setShowGrid(false);
		table_EM.setShowVerticalLines(false);
		table_EM.getTableHeader().setReorderingAllowed(false);

		EMcolumnNames = new Object[Main.blokoDydis + 1];
		EMcolumnNames[0] = "Blokas";
		for (int i = 0; i < Main.blokoDydis; i++) {
			EMcolumnNames[i + 1] = String.format("%01X", i);
		}
		EMdata = new Object[Main.EMBlokuSkaicius][Main.blokoDydis];
		for (int i = 0; i < Main.EMBlokuSkaicius; i++) {
			EMdata[i][0] = String.format("%01X", i) + ":";
			for (int j = 1; j < Main.blokoDydis; j++) {
				EMdata[i][j] = "____";
			}
		}

		DefaultTableModel table_model_EM = new DefaultTableModel(EMdata,
				EMcolumnNames) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[Main.blokoDydis];

			public boolean isCellEditable(int row, int column) {
				columnEditables[0] = false;
				for (int i = 1; i < Main.blokoDydis; i++) {
					columnEditables[i] = true;
				}
				return columnEditables[column];
			}
		};

		table_EM.setModel(table_model_EM);
		table_EM.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_EM.getColumnModel().getColumn(0).setMinWidth(40);
		for (int i = 1; i < Main.blokoDydis; i++) {
			table_EM.getColumnModel().getColumn(i).setPreferredWidth(40);
			table_EM.getColumnModel().getColumn(i).setMinWidth(40);
		}
		scrollPane_EM.setViewportView(table_EM);

		table_EM.setValueAt("LM05", 2, 3);
		table_EM.setValueAt(table_EM.getValueAt(2, 3), 3, 3);

		// ---REALI---
		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(10, 181, 20, 150);
		panel_atmintis.add(lblRa);

		scrollPane_RA = new JScrollPane();
		scrollPane_RA.setBounds(30, 181, 700, 150);
		panel_atmintis.add(scrollPane_RA);

		table_RA = new JTable();
		table_RA.setRowSelectionAllowed(false);
		table_RA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_RA.setShowGrid(false);
		table_RA.setShowVerticalLines(false);
		table_RA.getTableHeader().setReorderingAllowed(false);
		RMcolumnNames = new Object[Main.blokoDydis + 1];
		RMcolumnNames[0] = "Blokas";
		for (int i = 0; i < Main.blokoDydis; i++) {
			RMcolumnNames[i + 1] = String.format("%01X", i);
		}
		RMdata = new Object[Main.RMBlokuSkaicius][Main.blokoDydis];
		for (int i = 0; i < Main.RMBlokuSkaicius; i++) {
			RMdata[i][0] = String.format("%01X", i) + ":";
			for (int j = 1; j < Main.blokoDydis; j++) {
				RMdata[i][j] = "____";
			}
		}
		DefaultTableModel table_model_RA = new DefaultTableModel(RMdata,
				RMcolumnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[Main.blokoDydis];

			public boolean isCellEditable(int row, int column) {
				columnEditables[0] = false;
				for (int i = 1; i < Main.blokoDydis; i++) {
					columnEditables[i] = true;
				}
				return columnEditables[column];
			}
		};
		table_RA.setModel(table_model_RA);
		table_RA.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_RA.getColumnModel().getColumn(0).setMinWidth(40);
		for (int i = 1; i < Main.blokoDydis; i++) {
			table_RA.getColumnModel().getColumn(i).setPreferredWidth(40);
			table_RA.getColumnModel().getColumn(i).setMinWidth(40);
		}
		scrollPane_RA.setViewportView(table_RA);

		// ---VIRTUALI---
		JLabel lblVa = new JLabel("VA");
		lblVa.setBounds(10, 342, 20, 150);
		panel_atmintis.add(lblVa);

		scrollPane_VA = new JScrollPane();
		scrollPane_VA.setBounds(30, 342, 700, 150);
		panel_atmintis.add(scrollPane_VA);

		table_VA = new JTable();
		table_VA.setRowSelectionAllowed(false);
		table_VA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_VA.setShowGrid(false);
		table_VA.setShowVerticalLines(false);
		table_VA.getTableHeader().setReorderingAllowed(false);

		DefaultTableModel table_model_VA = new DefaultTableModel(EMdata,
				EMcolumnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[Main.blokoDydis];

			public boolean isCellEditable(int row, int column) {
				columnEditables[0] = false;
				for (int i = 1; i < Main.blokoDydis; i++) {
					columnEditables[i] = true;
				}
				return columnEditables[column];
			}
		};
		table_VA.setModel(table_model_VA);
		table_VA.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_VA.getColumnModel().getColumn(0).setMinWidth(40);
		for (int i = 1; i < Main.blokoDydis; i++) {
			table_VA.getColumnModel().getColumn(i).setPreferredWidth(40);
			table_VA.getColumnModel().getColumn(i).setMinWidth(40);
		}
		scrollPane_VA.setViewportView(table_VA);

		// -----------------------------------------------------------------

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 378, 2);
		contentPane.add(separator);

		// ------------KONSOLE--------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 378, 94);
		contentPane.add(scrollPane);

		txtpnconsole = new JTextPane();
		scrollPane.setViewportView(txtpnconsole);
		txtpnconsole.setText(">>> Console");
		txtpnconsole.setEditable(false);

		TextField console = new TextField();
		console.setBounds(10, 307, 378, 22);
		contentPane.add(console);

		JScrollPane scrollPane_Lempute = new JScrollPane();
		scrollPane_Lempute.setBounds(370, 393, 20, 20);
		contentPane.add(scrollPane_Lempute);
		// ----------------------------------------------------------------

		// -----------LEMPUTES-LANGELIS------------------------------------
		canvas_Lempute = new Canvas();
		scrollPane_Lempute.setViewportView(canvas_Lempute);
		canvas_Lempute.setBackground(Color.lightGray);

		// ----------------------------------------------------------------

		// ------------MYGTUKAI--------------------------------------------

		btn_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser();
				fc.addChoosableFileFilter(new FileNameExtensionFilter(
						"VM Failai", "vm"));
				int returnVal = fc.showOpenDialog(MainWindow.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String s;
						s = br.readLine();
						int key1 = 0;
						int key2 = 0;
						if ((s) == "$STR")
							while ((s != null) || (s != "$END")) {
								s = br.readLine();
								String[] value = s.split("(?<=\\G.{1})");
								String Word = "";
								if (value.length == 4)
									if (value[0] == "$") {
										key1 = Integer.parseInt(value[2]);
										key2 = Integer.parseInt(value[3]);
									}
									else {

										int key = key1 * 10 + key2;
										String keyWord = String.format("%02d",
												key);

										Word = value[0] + value[1] + value[2]
												+ value[3];

										rm.Atmintis.set(key, Word);
										listModel.set(key, keyWord + ": "
												+ rm.Atmintis.get(key));
									}

							}
						fr.close();
					} catch (IOException e1) {
						// e1.printStackTrace();
					}
					rm.IP.set("0");
					// listas.setSelectedIndex(0);
					scrollPane_RA.revalidate();
					scrollPane_RA.repaint();
					updateListRM(rm.memory);
				}
				else {
					// Vartotojas at�aukia pasirinkim�
					txtpnconsole.setText(txtpnconsole.getText()
							+ "\n> File Chooser closed.");
				}
			}
		});

		btn_Load.setBounds(10, 335, 111, 22);
		contentPane.add(btn_Load);

		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rm.startProgram();
				btn_End.setEnabled(true);
			}
		});
		btn_Start.setBounds(127, 335, 83, 22);
		contentPane.add(btn_Start);
		btn_End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// I�saugom duomenis i�orin� atmintyje
				// rm.saveMemory();

				txtpnconsole.setText(">> Console restart");
				rm.Z.set("0");
				rm.S.set("0");
				rm.C.set("0");
				rm.B.set("0");
				rm.IP.set("0");
				rm.AR.set("0000");
				rm.BR.set("0000");
				rm.SI.set(0);
				rm.PI.set(0);
				rm.TI.set(0);
				rm.TIMER.update();
				rm.MODE.set(0);

				text_reg_AR.setText(rm.AR.get());
				text_reg_BR.setText(rm.BR.get());
				text_flag_Z.setText(rm.Z.get());
				text_flag_C.setText(rm.C.get());
				text_flag_S.setText(rm.S.get());
				text_flag_B.setText(rm.B.get());
				text_reg_IP.setText(rm.IP.get());
				text_reg_TIMER.setText(Integer.toString(RM.TIMER.get()));
				text_reg_SI.setText(Integer.toString(RM.SI.get()));
				text_reg_PI.setText(Integer.toString(RM.PI.get()));
				text_reg_TI.setText(Integer.toString(RM.TI.get()));
				text_reg_MODE.setText(Integer.toString(RM.MODE.get()));
				text_reg_CHST_Input.setText(Integer.toString(RM.CHST.get(0)));
				text_reg_CHST_EMemory.setText(Integer.toString(RM.CHST.get(1)));
				text_reg_CHST_Lempute.setText(Integer.toString(RM.CHST.get(2)));
				text_reg_CHST_Output.setText(Integer.toString(RM.CHST.get(3)));
				text_reg_PTR.setText(RM.PTR.get());

				btn_End.setEnabled(false);
				btn_Start.setEnabled(false);
				btn_Step.setEnabled(false);
			}
		});
		btn_End.setBounds(216, 335, 83, 22);
		contentPane.add(btn_End);

		btn_Step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_End.setEnabled(true);
				// Vykdyti program� po �ingsn�
				rm.startProgramStepByStep();
			}
		});
		btn_Step.setBounds(305, 335, 83, 22);
		contentPane.add(btn_Step);

		JLabel lblLemput = new JLabel("Lemput\u0117:");
		lblLemput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLemput.setBounds(317, 393, 51, 20);
		contentPane.add(lblLemput);

		// -----------------------------------------------------------------
	}

	public static void setLempute(boolean jungiklis) {
		if (jungiklis)
			canvas_Lempute.setBackground(Color.YELLOW);
		else
			canvas_Lempute.setBackground(Color.LIGHT_GRAY);

	}

	public static void set(String register, String str_value) {

		switch (register) {
		case "RM_AR":
			text_reg_AR.setText(str_value);
			break;
		case "RM_BR":
			text_reg_BR.setText(str_value);
			break;
		case "RM_IP":
			text_reg_IP.setText(str_value);
			break;
		case "RM_Z":
			text_flag_Z.setText(str_value);
			break;
		case "RM_C":
			text_flag_C.setText(str_value);
			break;
		case "RM_B":
			text_flag_B.setText(str_value);
			break;
		case "RM_S":
			text_flag_S.setText(str_value);
			break;
		case "TIMER":
			text_reg_TIMER.setText(str_value);
			break;
		case "RM_MODE":
			text_reg_MODE.setText(str_value);
			break;
		case "RM_PTR":
			text_reg_PTR.setText(str_value);
			break;
		case "RM_PI":
			text_reg_PI.setText(str_value);
			break;
		case "RM_SI":
			text_reg_SI.setText(str_value);
			break;
		case "RM_TI":
			text_reg_TI.setText(str_value);
			break;
		case "INPUT":
			text_reg_CHST_Input.setText(str_value);
			break;
		case "OUTPUT":
			text_reg_CHST_Output.setText(str_value);
			break;
		case "EMEMORY":
			text_reg_CHST_EMemory.setText(str_value);
			break;
		case "LEMPUTE":
			text_reg_CHST_Lempute.setText(str_value);
			break;
		}
	}

	public String get(String register) {
		switch (register) {
		case "RM_AR":
			return text_reg_AR.getText();
		case "RM_BR":
			return text_reg_BR.getText();
		case "RM_IP":
			return text_reg_IP.getText();
		case "RM_Z":
			return text_flag_Z.getText();
		case "RM_C":
			return text_flag_C.getText();
		case "RM_B":
			return text_flag_B.getText();
		case "RM_S":
			return text_flag_S.getText();
		case "TIMER":
			return text_reg_TIMER.getText();
		case "RM_MODE":
			return text_reg_MODE.getText();
		case "RM_PTR":
			return text_reg_PTR.getText();
		case "RM_PI":
			return text_reg_PI.getText();
		case "RM_SI":
			return text_reg_SI.getText();
		case "RM_TI":
			return text_reg_TI.getText();
		case "INPUT":
			return text_reg_CHST_Input.getText();
		case "EMEMORY":
			return text_reg_CHST_EMemory.getText();
		case "LEMPUTE":
			return text_reg_CHST_Lempute.getText();
		case "OUTPUT":
			return text_reg_CHST_Output.getText();
		default:
			return "Klaida!";
		}
	}

	public void setEMemory(String reiksme, int blokas, int elementas) {
		table_EM.setValueAt(reiksme, blokas, elementas);
	}

	public static void updateConsole(String text) {
		txtpnconsole.setText(txtpnconsole.getText() + "\n" + text);
	}

	public static void updateListRM(RealMemory Atmintis) {
		for (int i = 1; i < Main.RMBlokuSkaicius; i++) {
			for (int n = 0; n < Main.blokoDydis; n++) {
				table_RA.setValueAt(Atmintis.getWord(i, n), n, i);
			}
		}
		scrollPane_RA.revalidate();
		scrollPane_RA.repaint();
	}
}