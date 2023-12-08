package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	public static void main(String[] args) 
	{
		String query="Create database Product_app";
		Connection con=null;
		Statement st=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			st=con.createStatement();
			boolean res=st.execute(query);
			System.out.println("databse created");
			System.out.println(res);
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
