package com.iu.db1;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class InsertTest {
	public static void main(String[] args) {
		//1.접속정보
		String user="scott";
		String password="tiger";
		
		//SID 
		//Express Editon : sid는 xe
		//정품버전은 orcl;
		//http://developer-joe.tistory.com/82
		//데이터베이스 API java는 jdbc라고 한다.
		//mysql,mssql 다 따로있다.
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("deptno:");
		String deptno=sc.next();
		System.out.println("dname:");
		String dname=sc.next();
		System.out.println("loc:");
		String loc = sc.next();
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		
		try {
			//2.드라이버를 메모리에 로딩
			Class.forName(driver);	// String로 된 애를 객체로 만든다. 드라이버 객체생성?
									// 왜쓰는지..?
			
			//3.Connection 연결 DB연결시에는 Soket이 아니라 connection 객체를 ㅅ용한다.
			Connection con=DriverManager.getConnection(url, user, password);
			
			//4.sql문 생성
			String sql="INSERT INTO DEPT VALUES("+60+","+"'"+dname+"'"+","+"'"+loc+"'"+")";
			System.out.println(sql);
											//이클립스에선 쿼리문뒤에 세미클론 붙이지 않음
			//5.Statement 생성 및 준비
			Statement st=con.createStatement();
		
			//6.전송 
			int result=st.executeUpdate(sql);
			
			if(result>0){
				System.out.println(result+" row 생성");
			}
			else{
				System.out.println("업데이트 실패");
			}
			
		
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
		
	}

}
