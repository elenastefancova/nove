package model;

import java.sql.Connection;
import java.sql.SQLException;

public class Menu {

	public Connection conn;
	
	/**
	 * Marking connection
	 * @param conn
	 */
	public Menu(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Open new HR window
	 */
	public void hr(){
		view.HR theView;
		try {
			theView = new view.HR();
			theView.frame.setVisible(true);
			model.HR theModel;
			theModel = new model.HR(conn);
		
			@SuppressWarnings("unused")
			controller.HR  theController = new controller.HR(theView,theModel, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	/**
	 * Open new NewTicket window.
	 */
	public void newTicket(){
		view.NewTicket theView = new view.NewTicket(conn);
		theView.frmNewTicket.setVisible(true);
		
		model.NewTicket theModel;
		theModel = new model.NewTicket(conn);
		
		try {
			@SuppressWarnings("unused")
			controller.NewTicket  theController = new controller.NewTicket(theView,theModel, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Open new ShowTickets window
	 */
	public void showTickets(){
		try {
			view.ShowTicket theView = new view.ShowTicket(conn);
			theView.frame.setVisible(true);
			model.ShowTicket theModel;
			theModel = new model.ShowTicket(conn);
		
			@SuppressWarnings("unused")
			controller.ShowTicket  theController = new controller.ShowTicket(theView,theModel, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Open new add a customer window
	 */
	public void addCustomer(){
		view.Customer theView = new view.Customer(conn);
		theView.frame.setVisible(true);
		model.Customer theModel;
		theModel = new model.Customer(conn);
		try {
			@SuppressWarnings("unused")
			controller.Customer  theController = new controller.Customer(theView,theModel, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Open new window with ticket filtring
	 */
	public void filterTickets(){
		try {
			view.FilterTickets theView = new view.FilterTickets(conn);
			theView.frame.setVisible(true);
			model.FilterTickets theModel;
			theModel = new model.FilterTickets(conn);
			@SuppressWarnings("unused")
			controller.FilterTickets  theController = new controller.FilterTickets(theView,theModel, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Open new window with statistics.
	 */
	public void showStatistics(){
		try {
			view.ShowStatistics theView = new view.ShowStatistics(conn);
			theView.frame.setVisible(true);
			model.ShowStatistics theModel;
			theModel = new model.ShowStatistics(conn);
			@SuppressWarnings("unused")
			controller.ShowStatistics  theController = new controller.ShowStatistics(theView,theModel, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
