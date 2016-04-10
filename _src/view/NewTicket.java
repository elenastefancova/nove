package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class NewTicket {

	public JFrame frmNewTicket;
	public JTextField textField;
	public JTextPane textPane;
	public Connection conn;
	public JScrollPane scrollPaneStaff;
	public JScrollPane scrollPaneCustomer;
	public JButton btnAdd;
	public GridBagConstraints gbc_scrollPaneCustomer;
	public GridBagConstraints gbc_scrollPaneStaff;

	/**
	 * Create the application.
	 * @param conn 
	 */
	public NewTicket(Connection conn) {
		this.conn = conn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewTicket = new JFrame();
		frmNewTicket.setTitle("New ticket");
		frmNewTicket.setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 0, 0, 30, 35, 309, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frmNewTicket.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 4;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		frmNewTicket.getContentPane().add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 1;
		frmNewTicket.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPopis = new JLabel("Description");
		GridBagConstraints gbc_lblPopis = new GridBagConstraints();
		gbc_lblPopis.anchor = GridBagConstraints.WEST;
		gbc_lblPopis.gridwidth = 4;
		gbc_lblPopis.insets = new Insets(0, 0, 5, 5);
		gbc_lblPopis.gridx = 1;
		gbc_lblPopis.gridy = 2;
		frmNewTicket.getContentPane().add(lblPopis, gbc_lblPopis);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.anchor = GridBagConstraints.NORTH;
		gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPane.gridx = 5;
		gbc_textPane.gridy = 2;
		frmNewTicket.getContentPane().add(textPane, gbc_textPane);
		
		JLabel lblCustomer = new JLabel("Customer");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.WEST;
		gbc_lblCustomer.gridwidth = 4;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 1;
		gbc_lblCustomer.gridy = 3;
		frmNewTicket.getContentPane().add(lblCustomer, gbc_lblCustomer);
		
		gbc_scrollPaneCustomer = new GridBagConstraints();
		gbc_scrollPaneCustomer.gridheight = 4;
		gbc_scrollPaneCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneCustomer.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCustomer.gridx = 5;
		gbc_scrollPaneCustomer.gridy = 3;
		//frmVytvovritNovy.getContentPane().add(scrollPaneCustomer, gbc_scrollPaneCustomer);
		
		JLabel lblStaff = new JLabel("Staff");
		GridBagConstraints gbc_lblStaff = new GridBagConstraints();
		gbc_lblStaff.gridwidth = 4;
		gbc_lblStaff.anchor = GridBagConstraints.WEST;
		gbc_lblStaff.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaff.gridx = 1;
		gbc_lblStaff.gridy = 7;
		frmNewTicket.getContentPane().add(lblStaff, gbc_lblStaff);
		
		gbc_scrollPaneStaff = new GridBagConstraints();
		gbc_scrollPaneStaff.gridheight = 4;
		gbc_scrollPaneStaff.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneStaff.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneStaff.gridx = 5;
		gbc_scrollPaneStaff.gridy = 7;
		//frmVytvovritNovy.getContentPane().add(scrollPaneStaff, gbc_scrollPaneStaff);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 8;
		frmNewTicket.getContentPane().add(btnAdd, gbc_btnAdd);
		btnAdd.setEnabled(false);
	}
	
	public void addbtnAddListener(ActionListener listenForbtnAdd) {
		this.btnAdd.addActionListener(listenForbtnAdd);
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "error", JOptionPane.ERROR_MESSAGE);
 	}
}
