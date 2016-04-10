package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ShowTicket {
	
	private view.ShowTicket theView;
	private model.ShowTicket  theModel;
	@SuppressWarnings("unused")
	private Connection conn;
	private int id=0;
	
	/**
	 * controller of showTIcket
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public ShowTicket(view.ShowTicket theView, model.ShowTicket theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.scrollPane = new JScrollPane(this.theModel.showTickets());
		
		//enable the openButton if a ticket is selected
		this.theModel.list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

			        if (theModel.list.getSelectedIndex() == -1) {
			        	setButtonFalse();

			        } else {
			        	setButtonTrue();
			        }
			    }
				
			}});
		
		this.theView.frame.getContentPane().add(this.theView.scrollPane, this.theView.gbc_scrollPane);
		
		this.theView.addbtnOpenListener(new btnOpenListener());
		this.theView.addbtnSaveListener(new btnSaveListener());
	}
	
	class btnOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				id = theModel.getID(theModel.list.getSelectedIndex());
				
				theView.textField.setText(theModel.getName(id));
				theView.textPane.setText(theModel.getDescr(id));
				theView.lblCustomernow.setText(theModel.getCustomer(id));
				theView.lblStaffnow.setText(theModel.getStaff(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			theView.btnSave.setEnabled(true);
		}
	}
	
	class btnSaveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				
				theModel.updateTicket(id, theView.textField.getText(), theView.textPane.getText(),theView.chckbxInprogress.isSelected(), theView.chckbxDone.isSelected());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setButtonFalse (){
		theView.btnOpen.setEnabled(false);
	}
	
	public void setButtonTrue (){
		theView.btnOpen.setEnabled(true);
	}
}
