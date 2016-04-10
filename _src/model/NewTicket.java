package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controller.EmptyException;

public class NewTicket {

	public JList<String> listStaff;
	public Vector<String> listDataStaff;
	public JList<String> listCustomer;
	public Vector<String> listDataCustomer;
	private Connection conn;

	/**
	 * making the connection
	 * @param conn
	 */
	public NewTicket(Connection conn) {
		this.conn = conn;
	}

	/**
	 * add a new ticket
	 * @param name
	 * @param desc
	 * @param indexC
	 * @param indexS
	 * @throws EmptyException
	 * @throws SQLException
	 */
	public void add(String name, String desc, int indexC, int indexS) throws EmptyException, SQLException{
		//check received data
		if ((name.equals("")) || (desc.equals(""))) {
			throw new EmptyException("Missing name/last name.");
		}
		
		//what is id of the staff
		String itemStaff = new String(); 
		itemStaff = (String) listDataStaff.get(indexS);
		//System.out.println(itemStaff);
		itemStaff = itemStaff.replaceAll("\\D+","");
		//System.out.println(itemStaff);
		int idStaff = Integer.parseInt(itemStaff);
		
		//what is id of the customer
		String itemCustomer = new String(); 
		itemCustomer = (String) listDataCustomer.get(indexC);
		//System.out.println(itemCustomer);
		itemCustomer = itemCustomer.replaceAll("\\D+","");
		//System.out.println(itemCustomer);
		int idCustomer = Integer.parseInt(itemCustomer);
		
		//what is the the time of adding
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();
		 
		//what is the date of adding
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		Calendar cal2 = Calendar.getInstance();
		 
		//System.out.println("Name: "+name+"\n Desc: "+desc+" \n Staff: "+idStaff+"   Customer: "+idCustomer);
		//System.out.println("Date: "+dateFormat.format(cal.getTime())+"\n Time: "+dateFormat2.format(cal2.getTime()));
		
		//adding new ticket
		Statement stmt = null;

		stmt = conn.createStatement();
		String sql = "BEGIN; INSERT INTO ticket (name, descr, sinced, sincet, s_id, st_id, c_id)"
        + "VALUES ('"+name+"','"+desc+"','"+dateFormat.format(cal.getTime())+"','"+dateFormat2.format(cal2.getTime())+"'"
        		+ ",'"+idStaff+"','1','"+idCustomer+"'); COMMIT;";
		/*String sql = "INSERT INTO ticket (name, descr, sinced, sincet, s_id, st_id, c_id)"
              + "VALUES ('"+name+"','"+desc+"','"+dateFormat.format(cal.getTime())+"','"+dateFormat2.format(cal2.getTime())+"','"+idStaff+"','1','"+idCustomer+"');";*/
        
		stmt.executeUpdate(sql);
		stmt.close();
		  
		conn.commit();
	}

	/**
	 * returning the list of staff
	 * @return
	 * @throws SQLException
	 */
	public JList<String> showStaff() throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM staff;" );
		
		listStaff = new JList<String>();
		listStaff.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listStaff.setLayoutOrientation(JList.VERTICAL);
	    listStaff.setVisibleRowCount(-1);
	    
	    listDataStaff = new Vector<>();
	    
		while ( rs.next() ) {
			int id = rs.getInt("s_id");
            String  name = rs.getString("name");
            String  lastname = rs.getString("namelast");
            
            //System.out.println(id+" "+name);
            listDataStaff.add(id+" "+name+" "+lastname+"\n");
    	}
    	//nastavenie udajov do tabulky
		listStaff.setListData(listDataStaff);
		
		rs.close();
        stmt.close();
        
		return listStaff;
	}

	/**
	 * returning the list of customers
	 * @return
	 * @throws SQLException
	 */
	public JList<String> showCustomer() throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM customer;" );
		
		listCustomer = new JList<String>();
		listCustomer.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listCustomer.setLayoutOrientation(JList.VERTICAL);
	    listCustomer.setVisibleRowCount(-1);
	    
	    listDataCustomer = new Vector<>();
	    
		while ( rs.next() ) {
			int id = rs.getInt("c_id");
            String  name = rs.getString("name");
            String  lastname = rs.getString("namelast");
            
            //System.out.println(id+" "+name);
            listDataCustomer.add(id+" "+name+" "+lastname+"\n");
    	}
    	//nastavenie udajov do tabulky
		listCustomer.setListData(listDataCustomer);
		
		rs.close();
        stmt.close();
		return listCustomer;
	}

}
