package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query="insert into Student values(3,'MNO',29,999,75.0)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=root");
			st=con.createStatement();
			int r=st.executeUpdate(query);
			System.out.println(r + "rows inserted");
		} 
		catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
					System.out.println("connection closed");
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(st!=null)
			{
				try 
				{
					st.close();
					System.out.println("statement closed");
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
