package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ShowStatistics {

	public JFrame frame;
	
	public JButton btnShow;
	public JTextPane textField;
	public JScrollPane scrollPane;
	public GridBagConstraints gbc_scrollPane;

	/**
	 * Create the application.
	 * @param conn 
	 */
	public ShowStatistics(Connection conn) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Show statistics");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		//frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JLabel lblShowAverageTime = new JLabel("Show average time of solving a ticket for a selected member of staff.");
		GridBagConstraints gbc_lblShowAverageTime = new GridBagConstraints();
		gbc_lblShowAverageTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAverageTime.gridx = 5;
		gbc_lblShowAverageTime.gridy = 6;
		frame.getContentPane().add(lblShowAverageTime, gbc_lblShowAverageTime);
		
		btnShow = new JButton("Show");
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow.gridx = 5;
		gbc_btnShow.gridy = 7;
		frame.getContentPane().add(btnShow, gbc_btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textField = new JTextPane();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 9;
		frame.getContentPane().add(textField, gbc_textField);
	}
	
	public void addbtnShowListener(ActionListener listenForbtnShow) {
		this.btnShow.addActionListener(listenForbtnShow);
	}

}
