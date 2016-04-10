package xstefancovae;
import java.awt.EventQueue;
import java.sql.*;

public class Start {
	static final String JDBC_DRIVER = "org.postgresql.Driver"; 
	static final String DB_URL = "jdbc:postgresql://localhost:5432/xstefancovae";
	
	static final String USER = "postgres";
	static final String PASS = "mojeN8Sheslo";
	
	public static void main(String[] args) {

		try {
			//making new connection conn
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			
			//open application
			EventQueue.invokeLater(new Runnable() {
				public void run() {

					view.Menu theView;
					try {
						theView = new view.Menu();
						theView.frmMenu.setVisible(true);
						model.Menu theModel;
						theModel = new model.Menu(conn);
					
						@SuppressWarnings("unused")
						controller.Menu  theController = new controller.Menu(theView,theModel, conn);
					} catch (SQLException e1) {
						
					}	
					
					
				}
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/*
		finally{
			try {
				if (conn != null)
				{
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}*/		
	}
	
}
