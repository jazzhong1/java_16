package com.iu.db2;

import java.sql.*;

public class SelectTest {

	public static void main(String[] args) {
		//1.
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String dirver="oracle.jdbc.driver.OracleDriver";
		
		try {
			
			Class.forName(dirver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			String sql="select * from dept";
			
			PreparedStatement st=con.prepareStatement(sql);
			
			//select문을 결과물을 ResultSet으로 받는다.
			ResultSet rs=st.executeQuery();	//DQL은 executeQuery 로 받는다.
	
			//Cursor 한줄씩 꺼내서 읽으려 한다. 
			while (rs.next()) {		//한줄씩 꺼내온다 리턴타입 boolean
				System.out.println("============================");
				System.out.println("DEPTNO	:"+rs.getInt("DEPTNO")); //대소문자 구별하지않는다. 
				System.out.println("DNAME	:"+rs.getString("DNAME"));	//해당 컬럼명으로 꺼내오기때문에 순서 상관없다.
				System.out.println("LOC	:"+rs.getString("LOC"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
