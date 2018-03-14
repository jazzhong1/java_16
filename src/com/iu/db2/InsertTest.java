package com.iu.db2;

import java.sql.*;

public class InsertTest {
	public static void main(String[] args) {
		int deptno=70;
		String dname="SALES";
		String loc="HAWAI";
		
		
		
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
														//서비스 아이디
									 //localhost 자기컴퓨터 
									//자기 컴퓨터이기때문에 ip를 적어주는것이 좋다.
									//DB서버가 다른컴퓨터에 있기때문에 DBip를 적어주는것이 좋음
		
		String driver="oracle.jdbc.driver.OracleDriver";
	
	
	
		try {
			
			//1.드라이버 메모리에 로딩
			Class.forName(driver);
			
			//2.커넥션 연결,
			Connection con=DriverManager.getConnection(url, user, password);
			
			//3.sql문 작성
			String sql="insert into dept values(?,?,?)";
			//필드명이없을경우 하나라도 빠지면 에러
			
			//4.PreparedStatement 객체생성
			PreparedStatement st=con.prepareStatement(sql);	//미리 넣어준다. 
			//데이터베이스 로 미리보낸다. 
			//데이터베이스는 작업을 준비한다. 
			
			//5.?에 대한 값을 전송 준비
			st.setInt(1, deptno);	//몇번째 ?에 대한 값에 넣을거냐 
									//오라클에서는 시작이 0이 아니라 1이다.
			st.setString(2, dname);
			st.setString(3, loc);
			
			int result=st.executeUpdate();
			
			if(result>0){
				System.out.println(result+"개 테이블 삽입");
			}
			else{
				System.out.println("실패 ");
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
