package view;

import java.sql.Connection;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FilterTickets {

	public JFrame frame;
	public JTextPane textField;
	public JScrollPane scrollPane;
	public GridBagConstraints gbc_scrollPane;
	
	public JButton btnShow;
	public JCheckBox chckbxNew;
	public JCheckBox chckbxInProgress;
	public JCheckBox chckbxDone;

	/**
	 * Create the application.
	 * @param conn 
	 */
	public FilterTickets(Connection conn) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Filter tickets");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		//frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		chckbxNew = new JCheckBox("New");
		GridBagConstraints gbc_chckbxNew = new GridBagConstraints();
		gbc_chckbxNew.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNew.gridx = 6;
		gbc_chckbxNew.gridy = 2;
		frame.getContentPane().add(chckbxNew, gbc_chckbxNew);
		
		chckbxInProgress = new JCheckBox("In Progress");
		GridBagConstraints gbc_chckbxInProgress = new GridBagConstraints();
		gbc_chckbxInProgress.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxInProgress.gridx = 6;
		gbc_chckbxInProgress.gridy = 3;
		frame.getContentPane().add(chckbxInProgress, gbc_chckbxInProgress);
		
		chckbxDone = new JCheckBox("Done");
		GridBagConstraints gbc_chckbxDone = new GridBagConstraints();
		gbc_chckbxDone.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDone.gridx = 6;
		gbc_chckbxDone.gridy = 4;
		frame.getContentPane().add(chckbxDone, gbc_chckbxDone);
		
		btnShow = new JButton("Show");
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow.gridx = 6;
		gbc_btnShow.gridy = 5;
		frame.getContentPane().add(btnShow, gbc_btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textField = new JTextPane();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 3;
		gbc_textField.gridwidth = 9;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		frame.getContentPane().add(textField, gbc_textField);
	}

	public void addbtnShowListener(ActionListener listenForbtnShow) {
		this.btnShow.addActionListener(listenForbtnShow);
	}
}
