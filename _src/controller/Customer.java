package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Customer {
	private view.Customer theView;
	private model.Customer theModel;
	@SuppressWarnings("unused")
	private Connection conn;

	/**
	 * controller of customer
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public Customer(view.Customer theView, model.Customer theModel, Connection conn) throws SQLException {
		
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.addbtnAddListener(new btnAddListener());
		
		this.theView.scrollPane = new JScrollPane(this.theModel.showDepartment ());
		this.theModel.list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

			        if (theModel.list.getSelectedIndex() == -1) {
			        	setButtonFalse();

			        } else {
			        //department is marked, set the button true
			        	setButtonTrue();
			        }
			    }
				
			}});
		this.theView.frame.getContentPane().add(this.theView.scrollPane, this.theView.gbc_scrollPane);
	}

	class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				try {
					theModel.add(theView.NametextField.getText(), theView.LastNametextField.getText(), theModel.list.getSelectedIndex());
					//clean the fields
					theView.NametextField.setText(null);
					theView.LastNametextField.setText(null);
				} catch (SQLException e) {

				}
			} catch (EmptyException e) {
				//pop up error window
				theView.displayErrorMessage("Missing name/last name.");
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
