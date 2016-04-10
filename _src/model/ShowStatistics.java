package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ShowStatistics {

	public JList<String> listStaff;
	public Vector<String> listDataStaff;
	private Connection conn;
	
	/**
	 * marking the connection
	 * @param conn
	 */
	public ShowStatistics(Connection conn) {
		this.conn = conn;
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
	 * Get ID of a specific member of staff.
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	public int getID(int index) throws SQLException {
		int id = 0;
		String item = new String(); 
		item = (String) listDataStaff.get(index);
		item = item.replaceAll("\\D+","");
		id = Integer.parseInt(item);
		return id;
	}

	/**
	 * get the statistics of selected or all input
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String getStatistic(int id) throws SQLException {
		String s="SELECT staff.name, staff.namelast, tabii.days FROM (SELECT s_id, AVG(datediff) AS days FROM (SELECT  datediff, t_id, st_id , "
				+ "s_id FROM (SELECT DATE_PART('day', ticket.tod::timestamp - ticket.sinced::timestamp) AS datediff, ticket.t_id, ticket.st_id , "
				+ "ticket.s_id FROM ticket WHERE ticket.st_id=3) AS tab) AS tabi GROUP BY s_id) AS tabii INNER JOIN staff ON tabii.s_id=staff.s_id "
				+ "";
		
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs;
		
		//if someone specific is selected
		if (id != -1){
			rs = stmt.executeQuery(s+"WHERE staff.s_id="+id+";");
		} //if not
		else {
			rs = stmt.executeQuery(s+";");
		}
		
		DecimalFormat df = new DecimalFormat(".##");
		//staff.name, staff.namelast, tabii.days
		String send="";
		while (rs.next()){
			send=(send+"STAFF: '"+rs.getString("name")+" "+rs.getString("namelast")+"' AVERAGE NUMMBER OF DAYS TO SOLVE A TICKET: "+ df.format(rs.getDouble("days") )+" \n");
		}
        
		rs.close();
        stmt.close();
		return send;
	}
}
