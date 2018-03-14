package com.iu.db2;

import java.sql.*;

/**
 * 사원의 이름과,1년 연봉을 조회 +comm 포함된금액
 *
 */
public class SelectTest3 {

	public static void main(String[] args) {
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String dirver="oracle.jdbc.driver.OracleDriver";
		
		
		try {
			Class.forName(dirver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			String sql="select ename,(sal+NVL(comm,0))*12 as yearsal from emp";
			PreparedStatement st=con.prepareStatement(sql);
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()){
				System.out.println("=======================");
				System.out.println("ename: "+rs.getString("ename"));
				System.out.println("yearsal: "+rs.getInt("yearsal"));
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
