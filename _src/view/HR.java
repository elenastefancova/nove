package view;


import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class HR {

	public JFrame frame;
	public JTextField textField;
	public JTextField textFieldl;
	public JButton btnAdd;
	public JButton btnDelete;
	public JScrollPane scrollPaneStaff;
	public GridBagConstraints gbc_scrollPane_3;

	/**
	 * Create the application.
	 * @param conn 
	 * @param theModel 
	 * @throws SQLException 
	 */
	public HR() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param conn 
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setTitle("HR");
		frame.setBounds(100, 100, 450, 300);
		//frmSpravaZamestnancov.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//nacitanie zoznamu
		gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridwidth = 6;
		gbc_scrollPane_3.gridheight = 7;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 1;
		//frame.getContentPane().add(scrollPaneStaff, gbc_scrollPane_3);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnZmazat = new GridBagConstraints();
		gbc_btnZmazat.insets = new Insets(0, 0, 5, 5);
		gbc_btnZmazat.gridx = 2;
		gbc_btnZmazat.gridy = 8;
		frame.getContentPane().add(btnDelete, gbc_btnZmazat);
		
		JLabel lblMeno = new JLabel("Name");
		GridBagConstraints gbc_lblMeno = new GridBagConstraints();
		gbc_lblMeno.insets = new Insets(0, 0, 5, 5);
		gbc_lblMeno.gridx = 1;
		gbc_lblMeno.gridy = 9;
		frame.getContentPane().add(lblMeno, gbc_lblMeno);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 9;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMenol = new JLabel("Last Name");
		GridBagConstraints gbc_lblMenol = new GridBagConstraints();
		gbc_lblMenol.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenol.gridx = 1;
		gbc_lblMenol.gridy = 10;
		frame.getContentPane().add(lblMenol, gbc_lblMenol);
		
		textFieldl = new JTextField();
		GridBagConstraints gbc_textFieldl = new GridBagConstraints();
		gbc_textFieldl.gridwidth = 2;
		gbc_textFieldl.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldl.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldl.gridx = 2;
		gbc_textFieldl.gridy = 10;
		frame.getContentPane().add(textFieldl, gbc_textFieldl);
		textFieldl.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnPridat = new GridBagConstraints();
		gbc_btnPridat.insets = new Insets(0, 0, 5, 5);
		gbc_btnPridat.gridx = 2;
		gbc_btnPridat.gridy = 11;
		frame.getContentPane().add(btnAdd, gbc_btnPridat);
	}
	
	public void addbtnDeleteListener(ActionListener listenForbtnDelete) {
		this.btnDelete.addActionListener(listenForbtnDelete);
	}
	
	public void addbtnAddListener(ActionListener listenForbtnAdd) {
		this.btnAdd.addActionListener(listenForbtnAdd);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "error", JOptionPane.ERROR_MESSAGE);
 	}
}
