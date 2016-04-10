package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ShowTicket {

	public JFrame frame;
	public JLabel textField;
	public JScrollPane scrollPane;
	public JTextPane textPane;
	public JLabel lblCustomernow;
	public JLabel lblStaffnow;
	public GridBagConstraints gbc_scrollPane;
	public JButton btnOpen;
	public JButton btnSave;
	public JCheckBox chckbxInprogress;
	public JCheckBox chckbxDone;

	/**
	 * Create the application.
	 * @param conn 
	 */
	public ShowTicket(Connection conn) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Show Ticket");
		frame.setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		//frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		btnOpen = new JButton("Open");
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpen.gridx = 6;
		gbc_btnOpen.gridy = 2;
		frame.getContentPane().add(btnOpen, gbc_btnOpen);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpen.setEnabled(false);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridwidth = 3;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 3;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		textField = new JLabel();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		//textField.setColumns(10);
		
		JLabel lblDescribtion = new JLabel("Describtion");
		GridBagConstraints gbc_lblDescribtion = new GridBagConstraints();
		gbc_lblDescribtion.anchor = GridBagConstraints.WEST;
		gbc_lblDescribtion.gridwidth = 3;
		gbc_lblDescribtion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescribtion.gridx = 3;
		gbc_lblDescribtion.gridy = 4;
		frame.getContentPane().add(lblDescribtion, gbc_lblDescribtion);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 7;
		gbc_textPane.gridy = 4;
		frame.getContentPane().add(textPane, gbc_textPane);
		
		JLabel lblCustomer = new JLabel("Customer");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.WEST;
		gbc_lblCustomer.gridwidth = 2;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 3;
		gbc_lblCustomer.gridy = 6;
		frame.getContentPane().add(lblCustomer, gbc_lblCustomer);
		
		lblCustomernow = new JLabel("-");
		GridBagConstraints gbc_lblCustomernow = new GridBagConstraints();
		gbc_lblCustomernow.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustomernow.gridx = 7;
		gbc_lblCustomernow.gridy = 6;
		frame.getContentPane().add(lblCustomernow, gbc_lblCustomernow);
		
		JLabel lblStaff = new JLabel("Staff");
		GridBagConstraints gbc_lblStaff = new GridBagConstraints();
		gbc_lblStaff.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaff.gridx = 3;
		gbc_lblStaff.gridy = 7;
		frame.getContentPane().add(lblStaff, gbc_lblStaff);
		
		lblStaffnow = new JLabel("-");
		GridBagConstraints gbc_lblStaffnow = new GridBagConstraints();
		gbc_lblStaffnow.insets = new Insets(0, 0, 5, 0);
		gbc_lblStaffnow.gridx = 7;
		gbc_lblStaffnow.gridy = 7;
		frame.getContentPane().add(lblStaffnow, gbc_lblStaffnow);
		
		chckbxInprogress = new JCheckBox("InProgress");
		GridBagConstraints gbc_chckbxInprogress = new GridBagConstraints();
		gbc_chckbxInprogress.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxInprogress.gridx = 6;
		gbc_chckbxInprogress.gridy = 8;
		frame.getContentPane().add(chckbxInprogress, gbc_chckbxInprogress);
		
		chckbxDone = new JCheckBox("Done");
		GridBagConstraints gbc_chckbxDone = new GridBagConstraints();
		gbc_chckbxDone.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDone.gridx = 6;
		gbc_chckbxDone.gridy = 9;
		frame.getContentPane().add(chckbxDone, gbc_chckbxDone);
		
		btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 6;
		gbc_btnSave.gridy = 10;
		frame.getContentPane().add(btnSave, gbc_btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setEnabled(false);
	}
	
	public void addbtnOpenListener(ActionListener listenForbtnOpen) {
		this.btnOpen.addActionListener(listenForbtnOpen);
	}
	
	public void addbtnSaveListener(ActionListener listenForbtnSave) {
		this.btnSave.addActionListener(listenForbtnSave);
	}

}
