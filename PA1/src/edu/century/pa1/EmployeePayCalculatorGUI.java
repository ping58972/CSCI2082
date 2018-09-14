package edu.century.pa1;
/* public class EmployeePayCalculatorGUI
 * 	The class use for building the GUI for display the
 * 	result of PayCalcuator class.
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  EmployeePayCalculatorGUI.java, Programming Assignment 01.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/13/2018
 * */
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class EmployeePayCalculatorGUI implements Constants{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePayCalculatorGUI window = new EmployeePayCalculatorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the application.
	 */
	public EmployeePayCalculatorGUI() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PayCalculator payCal = new PayCalculator("Jonh Smith", 14.75);		
		String[] displays = new String[HOURS_WORKED.length];
		
		for(int i=0; i< HOURS_WORKED.length; i++ ) {
			if (HOURS_WORKED[i] != 0)
				displays[i] = String.format("%-16s%-18s%-43d%-35.2f%-44.2f%-50.2f%-50.2f%-50.2f%-50.2f%-40.2f\n",
						payCal.getName(), payCal.getReportId(),
						HOURS_WORKED[i],
						payCal.overTimeHoursWorked(HOURS_WORKED[i]),
						payCal.grossPay(HOURS_WORKED[i]),
						payCal.overTimePay(payCal.overTimeHoursWorked(HOURS_WORKED[i])),
						payCal.federalDeductions(payCal.grossPay(HOURS_WORKED[i])),
						payCal.stateDeductions(payCal.grossPay(HOURS_WORKED[i])),
						payCal.totalDeductions(payCal.federalDeductions(payCal.grossPay(HOURS_WORKED[i])), 
								payCal.stateDeductions(payCal.grossPay(HOURS_WORKED[i]))),
						payCal.netPay(HOURS_WORKED[i]));
			else displays[i] = "********* Vacation time : - ) **********\n";
		}
		
		frame = new JFrame();
		frame.setBounds(200, 200,900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea textArea = new JTextArea("Well come to Employee Pay Calculator!");
		
		textArea.setEditable(false);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblClickForCompute = new JLabel("Click For Compute the Pay Check For: ");
		panel.add(lblClickForCompute);
		
		JButton btnYear = new JButton("Year");
		panel.add(btnYear);
		btnYear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(command.equals("Year")) {
					textArea.setText("");
					textArea.append(String.format("%-20s%-20s%-30s%-30s%-40s%-40s%-40s%-40s%-40s%-40s\n",
							"Name", "|ID", "|Hours Woeked", "|Over Time", "|Regular Pay","|Overtime Pay", 
							"|Federal Deductions", "|State Deductions","|Total Deductions","|NetPay"));
					for(String display : displays) {
						textArea.append(display);
						}
				}
				
			}
		});
		
		
		JButton btnPeriod = new JButton("Period");
		panel.add(btnPeriod);
		String[] payPeriods = {"PAY_PERIOD_1","PAY_PERIOD_2","PAY_PERIOD_3",
				"PAY_PERIOD_4","PAY_PERIOD_5","PAY_PERIOD_6","PAY_PERIOD_7",
				"PAY_PERIOD_8","PAY_PERIOD_9","PAY_PERIOD_10","PAY_PERIOD_11",
				"PAY_PERIOD_12","PAY_PERIOD_13","PAY_PERIOD_14",
				"PAY_PERIOD_15","PAY_PERIOD_16","PAY_PERIOD_17","PAY_PERIOD_7",
				"PAY_PERIOD_19","PAY_PERIOD_20","PAY_PERIOD_21","PAY_PERIOD_22",
				"PAY_PERIOD_23","PAY_PERIOD_24","PAY_PERIOD_25","PAY_PERIOD_26",};
		JComboBox comboBox = new JComboBox(payPeriods);
		panel.add(comboBox);
		btnPeriod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(command.equals("Period")) {
					textArea.setText("");
					textArea.append(String.format("%-20s%-20s%-30s%-30s%-40s%-40s%-40s%-40s%-40s%-40s\n",
							"Name", "|ID", "|Hours Woeked", "|Over Time", "|Regular Pay","|Overtime Pay", 
							"|Federal Deductions", "|State Deductions","|Total Deductions","|NetPay"));
					
						textArea.append(displays[comboBox.getSelectedIndex()]+"\n");
						
				}
				
			}
		});

	}


}
