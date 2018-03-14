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
		
		String ename="WARD";
		
		try {
			Class.forName(dirver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			String sql="select ename,(sal+NVL(comm,0))*12 from emp where ename=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, ename);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()){
				System.out.println("ename:"+rs.getString(1));
				System.out.println("sal:"+rs.getInt(2));
			}
			else{
				System.out.println("정보없습니다.");
			}
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
