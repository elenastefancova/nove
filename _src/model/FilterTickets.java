package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class FilterTickets {

	public JList<String> listStaff; //list of staff
	public Vector<String> listDataStaff; //list of staff
	private Connection conn; //connection to dbs
	
	/**
	 * Only one lonely constructor
	 * @param conn
	 */
	public FilterTickets(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Get id of member of the staff
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
	 * List of current staff
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
	 * Getting selected items in rows
	 * @param id
	 * @param selected1
	 * @param selected2
	 * @param selected3
	 * @return
	 * @throws SQLException
	 */
	public String showTickets(int id, boolean selected1, boolean selected2, boolean selected3) throws SQLException {
		String s = "";
		boolean pom=false; //is there at least one WHERE? esspecialy WHERE with staff id
		boolean temp=false; //is there at least one WHERE? esspecialy WHERE with status id
		//if is not selected status
		if (!selected1 && !selected2 && !selected3){
			s ="Sorry, nothing... Try to select type of status.";
			return s;
		}
		else {
			s = "SELECT ticket.t_id, ticket.name, customer.name AS cn, customer.namelast AS cnl, status.name AS stn, staff.name AS sn, "
					+ "staff.namelast AS snl,"
					+ " department.name AS dn "
					+ "FROM ticket INNER JOIN customer ON ticket.c_id=customer.c_id INNER JOIN status "
					+ "ON ticket.st_id=status.st_id INNER JOIN staff ON ticket.s_id=staff.s_id INNER JOIN department "
					+ "ON customer.d_id=department.d_id "
					+ "WHERE ";
			//if a specific member of staff is selected
			if (id != -1){
				s = (s+"staff.s_id="+id+" ");
				pom=true;
			}
			
			//if new is selected
			if (selected1){
				if (pom){
					s = (s+"AND (");
					pom=false;
				}
				else
					s = (s+" (");

				s = (s+"status.st_id=1 ");
				temp = true;
			}
			//if InProgress is selected
			if (selected2){
				if (pom){
					s = (s+"AND (");
				}
				if (temp){
					s = (s+"OR ");
				}
				else if (!pom){
					s = (s+" (");
				}
				pom=false;
				
				s = (s+"status.st_id=2 ");
				temp = true;
			}
			//if Done is selected
			if (selected3){
				if (pom){
					s = (s+"AND (");
				}
				if (temp){
					s = (s+"OR ");
				}
				else if (!pom){
					s = (s+" (");
				}
				pom=false;
				
				s = (s+"status.st_id=3 ");
				temp = true;
			}
			if (temp){
				s = (s+") ");
			}
			s = (s+";");
		}
		
		//sending the request
		Statement stmt = null;
		stmt = conn.createStatement();
		
		//System.out.print(s);
		
		ResultSet rs = stmt.executeQuery(s);

		String newS="";
		//editing new data
		while ( rs.next() ) {
			//System.out.print("ID:'"+rs.getInt("t_id")+"' NAME: '"+rs.getString("name")+"' CUSTOMER: '"+rs.getString("cn")+ " "+rs.getString("cnl")+"' STAFF: '"+rs.getString("sn")+" "+rs.getString("snl")+"' STATUS: "+rs.getString("stn")+"\n");
		     newS = (newS+"ID:'"+rs.getInt("t_id")+"' NAME: '"+rs.getString("name")+"' CUSTOMER: '"+rs.getString("cn")+ " "+rs.getString("cnl")+"' STAFF: '"+rs.getString("sn")+" "+rs.getString("snl")+"' DEPARTMENT: '"+rs.getString("dn")+"' STATUS: "+rs.getString("stn")+" \n");
		  }
		
		rs.close();
		stmt.close();
		
		//System.out.print(newS);
		return newS;
	}
}