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

public class ShowTicket {

	public JList<String> list;
	public Vector<String> listData;
	private Connection conn;
	
	/**
	 * Constructor
	 * @param conn
	 */
	public ShowTicket(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Returning the list of tickets
	 * @return
	 * @throws SQLException
	 */
	public JList<String> showTickets() throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ticket;" );
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
	    list.setVisibleRowCount(-1);
	    
	    listData = new Vector<>();
	    
		while ( rs.next() ) {
			int id = rs.getInt("t_id");
            String  name = rs.getString("name");
            
            //System.out.println(id+" "+name);
            listData.add(id+" "+name+"\n");
    	}
    	//nastavenie udajov do tabulky
		list.setListData(listData);
		
		rs.close();
        stmt.close();
        
		return list;
	}

	/**
	 * Get ID of a specific ticket.
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	public int getID(int index) throws SQLException {
		int id = 0;
		String item = new String(); 
		item = (String) listData.get(index);
		item = item.replaceAll("\\D+","");
		id = Integer.parseInt(item);
		return id;
	}
	
	/**
	 * Get name of a specific ticket.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getName(int id) throws SQLException {
		//System.out.println(id);
		
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ticket WHERE t_id="+id+";");
		rs.next();
        String  name = rs.getString("name");
		
		rs.close();
        stmt.close();
        
		return name;
	}
	
	/**
	 * Get describtion of a specific ticket.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getDescr(int id) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ticket WHERE t_id="+id+";");
		rs.next();
        String  descr = rs.getString("descr");
		
		rs.close();
        stmt.close();
		
		return descr;
	}
	
	/**
	 * Get customer of a specific ticket.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getCustomer(int id) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ticket WHERE t_id="+id+";");
		rs.next();
        int  c_id = rs.getInt("c_id");
		
		rs.close();
        stmt.close();
        
        stmt = conn.createStatement();
		ResultSet rs2 = stmt.executeQuery( "SELECT * FROM customer WHERE c_id="+c_id+";");
		rs2.next();
        String  customer = (rs2.getString("name")+" "+rs2.getString("namelast"));
		
		rs.close();
        stmt.close();
		
		return customer;
	}
	
	/**
	 * Get member of staff of a specific ticket.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getStaff(int id) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM ticket WHERE t_id="+id+";");
		rs.next();
		int  s_id = rs.getInt("s_id");
		
		rs.close();
        stmt.close();
        
        stmt = conn.createStatement();
		ResultSet rs2 = stmt.executeQuery( "SELECT * FROM staff WHERE s_id="+s_id+";");
		rs2.next();
        String  staff = (rs2.getString("name")+" "+rs2.getString("namelast"));
		
		rs.close();
        stmt.close();
		
		return staff;
	}
	
	/**
	 * Update one selected ticket
	 * @param id
	 * @param name
	 * @param descr
	 * @param statusA
	 * @param statusB
	 * @throws SQLException
	 */
	public void updateTicket(int id, String name, String descr, boolean statusA, boolean statusB) throws SQLException {
		int status = 1; //ticket is new
		if (statusA)
			status = 2; //ticket is InProgress
		if (statusB){
			status = 3; //ticket is Done
		}
		
		
		Statement stmt = null;
		String sql;
		stmt = conn.createStatement();
		//update
		if (status == 3) //ticket is done
		{
			//what is the the time of adding
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			//what is the date of adding
			DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
			Calendar cal2 = Calendar.getInstance();
			//updating the DONE ticket with the time and date of closing
			sql = "BEGIN; UPDATE ticket set name = '"+name+"', descr = '"+descr+"', st_id = '"+status+"', tod = '"+dateFormat.format(cal.getTime())+"', tot = '"+dateFormat2.format(cal2.getTime())+"'  where t_id="+id+"; COMMIT;";
		}
		//still working on ticket
		else {
			sql = "BEGIN; UPDATE ticket set name = '"+name+"', descr = '"+descr+"', st_id = '"+status+"', tod = NULL, tot = NULL  where t_id="+id+"; COMMIT;";
		}
		stmt.executeUpdate(sql);
		
		//end
		conn.commit();
		stmt.close();
		
	}
}
