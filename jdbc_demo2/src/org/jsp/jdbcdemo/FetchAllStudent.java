package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllStudent {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query="Select * from Student";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			//st.execute(query);
			//rs=st.getResultSet();
			while(rs.next())
			{
				System.out.println("Student Id:"+rs.getInt("id"));//rs.getInt(1)
				System.out.println("Student Name:"+rs.getString("name"));//rs.getString(2)
				System.out.println("Student age:"+rs.getInt("age"));//rs.getInt(3)
				System.out.println("Student phone:"+rs.getLong("phone"));//rs.getLong(4)
				System.out.println("Student perc:"+rs.getDouble("perc"));//rs.getDouble(5)
				System.out.println("---------------------------");
			}
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
			if(rs!=null)
			{
				try 
				{
					rs.close();
					System.out.println("Resultset closed");
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
