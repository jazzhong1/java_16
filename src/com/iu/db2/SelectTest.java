package com.iu.db2;

import java.sql.*;
import java.util.*;

public class SelectTest {

	public static void main(String[] args) {
		
		View v=new View();
		
		
		
		//1.
		String user="scott";
		String password="tiger";
		
		String url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String dirver="oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs= null;
		ArrayList<DeptDTO> arrayList=new ArrayList<>();
		try {
			
			Class.forName(dirver);
			
			con=DriverManager.getConnection(url, user, password);
			
			String sql="select * from dept";
			
			st=con.prepareStatement(sql);
			
			//select문을 결과물을 ResultSet으로 받는다.
			rs=st.executeQuery();	//DQL은 executeQuery 로 받는다.
	
			//Cursor 한줄씩 꺼내서 읽으려 한다. 
			while (rs.next()) {		//한줄씩 꺼내온다 리턴타입 boolean
		
				
				DeptDTO deptDTO=new DeptDTO();
				deptDTO.setDeptno(rs.getInt("DEPTNO"));//대소문자 구별하지않는다.
				deptDTO.setDname(rs.getString("DNAME"));//해당 컬럼명으로 꺼내오기때문에 순서 상관없다.
				deptDTO.setLoc(rs.getString("LOC"));
				arrayList.add(deptDTO);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		v.view(arrayList);
		
	}
}
