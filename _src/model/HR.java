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

public class HR {
	
	public JList<String> list;
	public Vector<String> listData;
	public Connection conn;
	
	/**
	 * marking the connection
	 * @param conn
	 */
	public HR(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Adding a new member of staff
	 * @param name
	 * @param namel
	 * @throws EmptyException
	 * @throws SQLException
	 */
	public void add(String name, String namel) throws EmptyException, SQLException {
		//check received data
		if ((name.equals("")) || (namel.equals(""))) {
			throw new EmptyException("Missing name/last name.");
		}
		
		 Statement stmt = null;
		 stmt = conn.createStatement();
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();
		 
         String sql = "INSERT INTO staff (name,namelast,since) "
               + "VALUES ('"+name+"','"+namel+"','"+dateFormat.format(cal.getTime())+"');";
         
         stmt.executeUpdate(sql);
         stmt.close();
         
         conn.commit();
	}
	
	public void delete(int index) throws SQLException {
		//System.out.println(index);
		String item = new String(); 
		item = (String) listData.get(index);
		//System.out.println(item);
		item = item.replaceAll("\\D+","");
		//System.out.println(item);
		int id = Integer.parseInt(item);
		
		Statement stmt = null;
		stmt = conn.createStatement();
		
		String sql = "BEGIN; DELETE from staff where s_id="+id+"; COMMIT;";
        stmt.executeUpdate(sql);
        
        //conn.commit();
        stmt.close();
        //listData.remove(index);
	}
	
	/**
	 * Returng the list of members of staff
	 * @return
	 * @throws SQLException
	 */
	public JList<String> update() throws SQLException
	{
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM staff;" );
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
	    list.setVisibleRowCount(-1);
	    
	    listData = new Vector<>();
	    
		while ( rs.next() ) {
			int id = rs.getInt("s_id");
            String  name = rs.getString("name");
            String  namel = rs.getString("namelast");
            
            //System.out.println(id+" "+name+" "+namel);
            listData.add(id+" "+name+" "+namel+ "\n");
    	}
    	//nastavenie udajov do tabulky
		list.setListData(listData);
		
		rs.close();
        stmt.close();
        
        return list;
	}
}
