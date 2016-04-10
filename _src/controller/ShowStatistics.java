package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JScrollPane;

public class ShowStatistics {

	private view.ShowStatistics theView;
	private model.ShowStatistics  theModel;
	@SuppressWarnings("unused")
	private Connection conn;
	private int id=-1;
	
	/**
	 * controller of statistics
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public ShowStatistics(view.ShowStatistics theView, model.ShowStatistics theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.scrollPane = new JScrollPane(this.theModel.showStaff());
		this.theView.frame.getContentPane().add(this.theView.scrollPane, this.theView.gbc_scrollPane);
		
		this.theView.addbtnShowListener(new btnOpenListener());
	}
	
	class btnOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				if (!theModel.listStaff.isSelectionEmpty()){
					id = theModel.getID(theModel.listStaff.getSelectedIndex());		
				}
					
				System.out.println(id);
				theView.textField.setText(theModel.getStatistic(id));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
