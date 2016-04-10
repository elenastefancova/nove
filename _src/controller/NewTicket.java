package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewTicket {
	private view.NewTicket theView;
	private model.NewTicket  theModel;
	private Connection conn;
	public int pom1, pom2;
	
	/**
	 * controller of new ticket
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public NewTicket(view.NewTicket theView, model.NewTicket theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.scrollPaneStaff = new JScrollPane(this.theModel.showStaff ());
		this.theView.scrollPaneCustomer = new JScrollPane(this.theModel.showCustomer ());
		
		//enable the addButton if member of staff is selected and a customer has been selected yet
		this.theModel.listStaff.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

			        if (theModel.listStaff.getSelectedIndex() == -1) {
			        	pom1 = 0;
			        	setButtonFalse();

			        } else {
			        	pom1 = 1;
			        	if (pom1 == 1 && pom2 == 1)
			        		setButtonTrue();
			        }
			    }
				
			}});
		//enable the addButton if customer is selected and a member of staff has been selected yet
		this.theModel.listCustomer.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

			        if (theModel.listCustomer.getSelectedIndex() == -1) {
			        	pom2 = 0;
			        	setButtonFalse();

			        } else {
			        	pom2 = 1;
			        	if (pom1 == 1 && pom2 == 1)
			        		setButtonTrue();
			        }
			    }
				
			}});
		
		this.theView.frmNewTicket.getContentPane().add(this.theView.scrollPaneStaff, this.theView.gbc_scrollPaneStaff);
		this.theView.frmNewTicket.getContentPane().add(this.theView.scrollPaneCustomer, this.theView.gbc_scrollPaneCustomer);
		
		this.theView.addbtnAddListener(new btnAddListener2());
	}

	class btnAddListener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//what if the staff doesn t exist
			Savepoint savepoint = null;
			try {
				savepoint = conn.setSavepoint();
				try {
					theModel.add(theView.textField.getText(), theView.textPane.getText(), theModel.listCustomer.getSelectedIndex(), theModel.listStaff.getSelectedIndex());
					theView.textField.setText(null);
					theView.textPane.setText(null);
				} catch (EmptyException e) {
					theView.displayErrorMessage("Missing name/last name");
				}
				
			} catch (SQLException e) {
				theView.displayErrorMessage("The member of staff does not exist.");
			    if(conn != null && savepoint != null) {
			        try {
						conn.rollback(savepoint);
					} catch (SQLException e1) {
						
					}
			    }
			}
		}
	}
	
	public void setButtonFalse (){
		theView.btnAdd.setEnabled(false);
	}
	
	public void setButtonTrue (){
		theView.btnAdd.setEnabled(true);
	}
}
