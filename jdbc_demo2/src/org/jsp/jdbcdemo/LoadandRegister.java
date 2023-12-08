package org.jsp.jdbcdemo;

public class LoadandRegister {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and register");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
