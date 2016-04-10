package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HR {

	private view.HR theView;
	private model.HR  theModel;
	private Connection conn;
	
	/**
	 * Controller of the HR
	 * @param theView
	 * @param theModel
	 * @param conn
	 * @throws SQLException
	 */
	public HR(view.HR theView, model.HR theModel, Connection conn) throws SQLException {
		this.theModel = theModel;
		this.theView = theView;
		this.conn = conn;
		
		this.theView.scrollPaneStaff = new JScrollPane(this.theModel.update());
		
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
		
		this.theView.frame.getContentPane().add(this.theView.scrollPaneStaff, this.theView.gbc_scrollPane_3);
		
		this.theView.addbtnDeleteListener(new btnDeleteListener());
		this.theView.addbtnAddListener(new btnAddListener());
	}
	
	class btnDeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Savepoint savepoint = null;
			try {
				savepoint = conn.setSavepoint();
				theModel.delete(theModel.list.getSelectedIndex());
			} catch (SQLException e1) {
				theView.displayErrorMessage("This member of staff has some work to do, some tickets on him.");
			    if(conn != null && savepoint != null) {
			        try {
						conn.rollback(savepoint);
					} catch (SQLException e) {
						
					}
			    }
			}
		}
	}
	
	class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				try {
					theModel.add(theView.textField.getText(), theView.textFieldl.getText());
					theView.textField.setText(""); 
					theView.textFieldl.setText("");
				} catch (EmptyException e) {
					theView.displayErrorMessage("Missing name/last name.");
				}
			} catch (SQLException e1) {
				
			}
			}
		}

	public void setButtonFalse (){
		theView.btnDelete.setEnabled(false);
	}
	
	public void setButtonTrue (){
		theView.btnDelete.setEnabled(true);
	}
}
