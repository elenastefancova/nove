package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Customer {

	public JFrame frame;
	public JTextField NametextField;
	public JTextField LastNametextField;
	public JButton btnAdd;
	public Connection conn;
	public JScrollPane scrollPane;
	public GridBagConstraints gbc_scrollPane;

	/**
	 * Create the application.
	 * @param conn 
	 */
	public Customer(Connection conn) {
		this.conn = conn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a new customer");
		frame.setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 50};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 50};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 4;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);
		btnAdd.setEnabled(false);
		
		JLabel lblDepartments = new JLabel("Departments");
		GridBagConstraints gbc_lblDepartments = new GridBagConstraints();
		gbc_lblDepartments.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartments.gridx = 4;
		gbc_lblDepartments.gridy = 0;
		frame.getContentPane().add(lblDepartments, gbc_lblDepartments);
	    
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		//frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 2;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		NametextField = new JTextField();
		GridBagConstraints gbc_NametextField = new GridBagConstraints();
		gbc_NametextField.insets = new Insets(0, 0, 5, 5);
		gbc_NametextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NametextField.gridx = 4;
		gbc_NametextField.gridy = 2;
		frame.getContentPane().add(NametextField, gbc_NametextField);
		NametextField.setColumns(10);
		
		JLabel lblLastname = new JLabel("Last name");
		GridBagConstraints gbc_lblLastname = new GridBagConstraints();
		gbc_lblLastname.gridwidth = 2;
		gbc_lblLastname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastname.gridx = 1;
		gbc_lblLastname.gridy = 3;
		frame.getContentPane().add(lblLastname, gbc_lblLastname);
		
		LastNametextField = new JTextField();
		GridBagConstraints gbc_LastNametextField_1 = new GridBagConstraints();
		gbc_LastNametextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_LastNametextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_LastNametextField_1.gridx = 4;
		gbc_LastNametextField_1.gridy = 3;
		frame.getContentPane().add(LastNametextField, gbc_LastNametextField_1);
		LastNametextField.setColumns(10);
		
	}
	
	public void addbtnAddListener(ActionListener listenForbtnAdd) {
		this.btnAdd.addActionListener(listenForbtnAdd);
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "error", JOptionPane.ERROR_MESSAGE);
 	}
}
