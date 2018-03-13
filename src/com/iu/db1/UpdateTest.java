package com.iu.db1;

import java.sql.*;
import java.util.*;

public class UpdateTest {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("수정할 도시명 입력");
		String loc=sc.next();
		System.out.println(loc);
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";

		String driver="oracle.jdbc.driver.OracleDriver";
		try {
			//1드라이버연결
			Class.forName(driver);
			
			//Connection 만들기
			Connection con= DriverManager.getConnection(url,user,password);
			
			//Connection 연결
			Statement st=con.createStatement();
			
			//sql만들기
			String sql="UPDATE DEPT SET LOC="+"'"+loc+"'" +" WHERE DEPTNO=50";
			System.out.println(sql);
			//sql날리기 
			
			int num=st.executeUpdate(sql);
			
			if(num>0){
				System.out.println(num+"개 row 변경");
			}
			else{
				System.out.println("실패 ");
			}
			
			
			
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
		
	}

}
