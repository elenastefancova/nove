package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Menu {

	private view.Menu theView;
	private model.Menu  theModel;
	@SuppressWarnings("unused")
	private Connection conn;
	
	/**
	 * controller of the menu
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public Menu(view.Menu theView, model.Menu theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
	
		this.theView.addbtnAddACustomerListener(new btnAddACustomerListener());
		this.theView.addbtnFilterTicketsListener(new btnFilterTicketsListener());
		this.theView.addbtnShowStatisticsListener(new btnShowStatisticsListener());
		this.theView.addshowTicketsListener(new btnshowTicketsListener());
		this.theView.addbtnSprvyZamestnancovListener(new btnSprvyZamestnancovListener());
		this.theView.addbtnAddNewTicketListener(new btnAddNewTicketListener());
	}
	
	class btnAddACustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.addCustomer();
		}
	}	
	class btnFilterTicketsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.filterTickets();
		}
	}	
	class btnShowStatisticsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.showStatistics();
		}
	}	
	class btnshowTicketsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.showTickets();
		}
	}	
	class btnSprvyZamestnancovListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.hr();
		}
	}	
	class btnAddNewTicketListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.newTicket();
		}
	}
}