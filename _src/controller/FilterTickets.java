package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JScrollPane;

public class FilterTickets {

	private view.FilterTickets theView;
	private model.FilterTickets theModel;
	@SuppressWarnings("unused")
	private Connection conn;
	private int id=-1;
	
	/**
	 * controller of filtring the tickets
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public FilterTickets(view.FilterTickets theView, model.FilterTickets theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.scrollPane = new JScrollPane(this.theModel.showStaff());
		this.theView.frame.getContentPane().add(this.theView.scrollPane, this.theView.gbc_scrollPane);
		
		this.theView.addbtnShowListener(new btnShowListener());
	}

	class btnShowListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				//if someone is selected
				if (!theModel.listStaff.isSelectionEmpty()){
					id = theModel.getID(theModel.listStaff.getSelectedIndex());
					theView.textField.setText(theModel.showTickets(id, theView.chckbxNew.isSelected(), 
							theView.chckbxInProgress.isSelected(),theView.chckbxDone.isSelected()));
				}
				else {
					//if not
					theView.textField.setText(theModel.showTickets(-1, theView.chckbxNew.isSelected(), 
							theView.chckbxInProgress.isSelected(), theView.chckbxDone.isSelected()));
				}
				//System.out.println(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
