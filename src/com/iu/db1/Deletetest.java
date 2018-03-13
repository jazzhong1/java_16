package com.iu.db1;

import java.sql.*;

public class Deletetest {


	public static void main(String[] args) {
		
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		
	
		
		try {
			//1. 드라이버 객체생성
			Class.forName(driver);
			
			//2.커넥션 객체로 연결
			Connection con=DriverManager.getConnection(url, user, password);

			//3.쿼리문작성
			String sql="DELETE DEPT WHERE DEPTNO=60";

			//4.Statement 생성 및 준비
			Statement st=con.createStatement();
			
			//5.sql문 전송
			int result=st.executeUpdate(sql);
			
			if(result!=0){
				System.out.println(result+"row 삭제");
			}
			else{
				System.out.println("실패");
			}
		
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

}
