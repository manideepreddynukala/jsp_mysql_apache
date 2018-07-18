package com.jdbc;
import java.sql.*; //step1
public class Demo {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3316/manideep";  //database name
		String uname = "root";
		String pass = "manipinku95";
		Class.forName("com.mysql.jdbc.Driver"); //step2
		Connection con = DriverManager.getConnection(url, uname, pass);//step3
		
		//Statement st = con.createStatement(); //step4
		
		/*ResultSet rs = st.executeQuery("select sname from student where rollno=15");//step5
		rs.next();
		String name = rs.getString(1); //rs.getString("sname") /step6
		System.out.println(name);*/
		
		/*int count = st.executeUpdate("insert into student values(56,'sudheer')");
		System.out.println(count+" number of rows affected");*/
		
		int rollno =5;
		String sname = "Ayyappa";
		String query = "insert into student values(?,?)";
		PreparedStatement pst = con.prepareStatement(query); //Prepared Statement
		pst.setInt(1,rollno);
		pst.setString(2,sname);
		int count = pst.executeUpdate();
		System.out.println(count+" number of rows affected");
		
		pst.close(); //step 7
		con.close();
	}

}
