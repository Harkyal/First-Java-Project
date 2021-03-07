package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Client;




public class ClientDao {
	public Connection getConnection()

	{
	String url="jdbc:mysql://localhost:3306/shippingrecords";

	String user = "root";

	String pwd = "";

	Connection con = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(url,user,pwd);

	System.out.println("connection successfull");

	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return con;

	}


	public List<Client> displayAllRecords()
	{
	List<Client> shippingrecords = new ArrayList<>();

	String sql = "select * from clients";

	Connection con = getConnection();

	try {
	Statement st = con.createStatement();
	       
	ResultSet rs = st.executeQuery(sql);


	while(rs.next())
	{
	Client c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));

	shippingrecords.add(c);

	}

	System.out.println(shippingrecords);
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return shippingrecords;



	}

public Client getRecordById(int Client_ID)
{

Connection con = getConnection();

String sql = "select * from clients where ClientID=?";

Client c = null;

try {

PreparedStatement pstmt = con.prepareStatement(sql);

pstmt.setInt(1, Client_ID);

ResultSet rs = pstmt.executeQuery();

if(rs.next())
{
c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));



}

System.out.println(c);

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return c;
}
public void updateRecord(Client updated_client, int old_id) {
	Connection con=getConnection();
	String sql="update clients set ClientID=?,Contact=?,ItemShipped=?,Date_Recieved=?,Date_Shipped=? where ClientID=?";
	int status=0;
	try {
		
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, updated_client.getClientID());
		pstmt.setString(2, updated_client.getContact());
		pstmt.setString(3, updated_client.getItemShipped());
		pstmt.setString(4, updated_client.getDate_Recieved());
		pstmt.setString(5, updated_client.getDate_Shipped());
		pstmt.setInt(6, old_id);
		status=pstmt.executeUpdate();
		
		if(status>0) {
			System.out.println("Record Updated");
			
		}
		else {
			System.out.println("Try Again");
		}
		
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
public void deleteRecord(int Client_ID) {
	Connection con=getConnection();
	String sql="delete from clients where ClientID=?";
	int status=0;
	try {
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, Client_ID);
		
		status=pstmt.executeUpdate();
		if(status>0) {
			System.out.println("Record Deleted");
		}
		else {
			System.out.println("Try again please");}
		
		
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public void insert(int c_ClientID,String c_Contact,String c_ItemShipped,String c_Date_Recieved, String c_Date_Shipped) {
		Connection con=getConnection();
		String sql="insert into clients (ClientID,Contact,ItemShipped,Date_Recieved,Date_Shipped)Values(?,?,?,?,?)";
		int status=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, c_ClientID);
			pstmt.setString(2, c_Contact);
			pstmt.setString(3, c_ItemShipped);
			pstmt.setString(4, c_Date_Recieved);
			pstmt.setString(5, c_Date_Shipped);
			status=pstmt.executeUpdate();
			
			if(status>0) {
				System.out.println("Record Inserted");
			}
			else {
				System.out.println("Try again please");}
			
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
