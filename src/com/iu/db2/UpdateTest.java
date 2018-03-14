package com.iu.db2;

import java.sql.*;
import java.util.*;

public class UpdateTest {
	//부서번호,지역명을 입력받아 수정하라 

	public static void main(String[] args) {
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("loc:");
		String loc=sc.next();
		System.out.println("deptno:");
		int deptno=sc.nextInt();
		
		try {
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			
			String sql="update dept set loc=? where deptno=?";
			//테이블 명을 ?로 할수 는 없다.
			//필드명을 ?로 할수는 없다. 
			//삽입할수 있는 값만 ?할수있다.
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, loc);
			st.setInt(2, deptno);
			
			int result=st.executeUpdate();
			
			if(result>0){
				System.out.println("성공");
			}
			else{
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
