package com.iu.db2;

import java.sql.*;
import java.util.*;

public class SelectTest2 {


	public static void main(String[] args) {
		//부서 번호를 입력받아서 해당부서 정보를 출력
		
		
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		Scanner sc=new Scanner(System.in);
		System.out.println("부서번호:");
		int deptno=sc.nextInt();
		
		try {
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			String sql="select * from dept where deptno=?";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setInt(1, deptno);	//물음표에 넣어주기 
			
			ResultSet rs=st.executeQuery();

			while(rs.next()){
				System.out.println("==============================");
				System.out.println("DEPTNO: "+rs.getInt("DEPTNO"));
				System.out.println("DNAME: "+rs.getString("DNAME"));
				System.out.println("LOC: "+rs.getString("LOC"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
