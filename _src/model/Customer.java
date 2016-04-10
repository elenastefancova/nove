package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controller.EmptyException;

public class Customer {
	public JList<String> list;
	public Vector<String> listData;
	private Connection conn;

	/**
	 * Constructor, marking connection
	 * @param conn
	 */
	public Customer(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Adding a new customer
	 * @param name
	 * @param lastname
	 * @param index
	 * @throws EmptyException
	 * @throws SQLException
	 */
	public void add(String name, String lastname, int index) throws EmptyException, SQLException {
		//check received data
		if ((name.equals("")) || (lastname.equals(""))) {
			throw new EmptyException("Missing name/last name.");
		}
		
		//what is id of the department
		String item = new String(); 
		item = (String) listData.get(index);
		//System.out.println(item);
		item = item.replaceAll("\\D+","");
		//System.out.println(item);
		int id = Integer.parseInt(item);
		
		//add new customer
		Statement stmt = null;
		stmt = conn.createStatement();
		 
        String sql = "INSERT INTO customer (name,namelast,d_id)"
              + "VALUES ('"+name+"','"+lastname+"','"+id+"');";
        
        stmt.executeUpdate(sql);
        stmt.close();
        
        conn.commit();
	}
	
	/**
	 * Returning list of deparments
	 * @return
	 * @throws SQLException
	 */
	public JList<String> showDepartment () throws SQLException{
	
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM department;" );
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
	    list.setVisibleRowCount(-1);
	    
	    listData = new Vector<>();
	    
		while ( rs.next() ) {
			int id = rs.getInt("d_id");
            String  name = rs.getString("name");
            
            //System.out.println(id+" "+name);
            listData.add(id+" "+name+"\n");
    	}
    	//setting data
		list.setListData(listData);
		
		rs.close();
        stmt.close();
        
        return list;
	}
}
