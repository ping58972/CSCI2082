package edu.century.pa1;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EmployeePayCalculatorGUI {

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
		PayCalculator payCal = new PayCalculator("jonh", 14.75);
		PayCalculator payCal2 = new PayCalculator("Ping", 18.75);
		System.out.println(payCal.getReportId());
		//System.out.println(payCal2.getReportId());
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
