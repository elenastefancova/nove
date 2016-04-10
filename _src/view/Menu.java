package view;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	public JButton btnAddNewTicket;
	public JButton btnSprvyZamestnancov;
	public JButton showTickets;
	public JButton btnAddACustomer;
	public JButton btnFilterTickets;
	public JButton btnShowStatistics;
	
	public JFrame frmMenu;
	/**
	 * Create the application.
	 * @param conn 
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param conn 
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmMenu.getContentPane().setLayout(gridBagLayout);
		
		btnAddNewTicket = new JButton("Add a new ticket");
		btnAddNewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnVytvoriNov = new GridBagConstraints();
		gbc_btnVytvoriNov.insets = new Insets(0, 0, 5, 5);
		gbc_btnVytvoriNov.gridx = 2;
		gbc_btnVytvoriNov.gridy = 2;
		frmMenu.getContentPane().add(btnAddNewTicket, gbc_btnVytvoriNov);
		
		btnSprvyZamestnancov = new JButton("HR");
		btnSprvyZamestnancov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		GridBagConstraints gbc_btnSprvyZamestnancov = new GridBagConstraints();
		gbc_btnSprvyZamestnancov.insets = new Insets(0, 0, 5, 0);
		gbc_btnSprvyZamestnancov.gridx = 6;
		gbc_btnSprvyZamestnancov.gridy = 2;
		frmMenu.getContentPane().add(btnSprvyZamestnancov, gbc_btnSprvyZamestnancov);
		
		showTickets = new JButton("Show tickets");
		showTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_btnZoznamZamestnancov = new GridBagConstraints();
		gbc_btnZoznamZamestnancov.insets = new Insets(0, 0, 5, 5);
		gbc_btnZoznamZamestnancov.gridx = 2;
		gbc_btnZoznamZamestnancov.gridy = 4;
		frmMenu.getContentPane().add(showTickets, gbc_btnZoznamZamestnancov);
		
		btnAddACustomer = new JButton("Add a customer");
		btnAddACustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnZoznamPoiadaviek = new GridBagConstraints();
		gbc_btnZoznamPoiadaviek.insets = new Insets(0, 0, 5, 0);
		gbc_btnZoznamPoiadaviek.gridx = 6;
		gbc_btnZoznamPoiadaviek.gridy = 4;
		frmMenu.getContentPane().add(btnAddACustomer, gbc_btnZoznamPoiadaviek);
		
		btnFilterTickets = new JButton("Filter tickets");
		btnFilterTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnFilterTickets = new GridBagConstraints();
		gbc_btnFilterTickets.insets = new Insets(0, 0, 0, 5);
		gbc_btnFilterTickets.gridx = 2;
		gbc_btnFilterTickets.gridy = 6;
		frmMenu.getContentPane().add(btnFilterTickets, gbc_btnFilterTickets);
		
		btnShowStatistics = new JButton("Show statistics");
		btnShowStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnShowStatistics = new GridBagConstraints();
		gbc_btnShowStatistics.gridx = 6;
		gbc_btnShowStatistics.gridy = 6;
		frmMenu.getContentPane().add(btnShowStatistics, gbc_btnShowStatistics);
	}
	
	public void addbtnAddACustomerListener(ActionListener listenForbtnAddACustomer) {
		this.btnAddACustomer.addActionListener(listenForbtnAddACustomer);
	}
	
	public void addbtnFilterTicketsListener(ActionListener listenForbtnFilterTickets) {
		this.btnFilterTickets.addActionListener(listenForbtnFilterTickets);
	}
	
	public void addbtnShowStatisticsListener(ActionListener listenForbtnShowStatistics) {
		this.btnShowStatistics.addActionListener(listenForbtnShowStatistics);
	}
	
	public void addshowTicketsListener(ActionListener listenForshowTickets) {
		this.showTickets.addActionListener(listenForshowTickets);
	}
	
	public void addbtnSprvyZamestnancovListener(ActionListener listenForbtnSprvyZamestnancov) {
		this.btnSprvyZamestnancov.addActionListener(listenForbtnSprvyZamestnancov);
	}
	
	public void addbtnAddNewTicketListener(ActionListener listenForbtnAddNewTicket) {
		this.btnAddNewTicket.addActionListener(listenForbtnAddNewTicket);
	}
}
