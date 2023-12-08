package org.jsp.jdbcdemo;
//program to understand the Resultset()

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudents {

	public static void main(String[] args) {
		
		String dql="select * from Student";
		String dml="insert into Student values(5,'PQR',23,456,67.0)";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=root");
			st=con.createStatement();
			System.out.println(st.execute(dml));//false
			System.out.println(st.getResultSet());//null
			System.out.println(st.execute(dql));//true
			System.out.println(st.getResultSet());//object Reference
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
