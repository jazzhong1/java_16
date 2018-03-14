package com.iu.db3;

import java.sql.*;
import java.util.*;

import oracle.jdbc.driver.*;

public class DeptDAO {

	private String user;
	private String password;
	private String url;
	private String driver;
	//1.insert 추가	
	//input으로 입력받고 추가 
	//결과값을 boolean으로 주지말고 int로 준다.
	
	public DeptDAO() {
		user="scott";
		password="tiger";
		url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		driver="oracle.jdbc.driver.OracleDriver";

	}
	public int insert(DeptDTO deptDTO) throws Exception{
		
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url, user, password);
			
			String sql="insert into dept values(?,?,?)";
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			int result=st.executeUpdate();
		
			st.close();
			con.close();
			
		return result;
	}

	//2. 전체조회
	public ArrayList<DeptDTO> selectAll() throws Exception{
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql="select * from dept";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		ResultSet rs=st.executeQuery();		//DQL은 excuteQuery()
		//결과물
		
		
		ArrayList<DeptDTO> arrayList=new ArrayList<>();

		while(rs.next()){
			DeptDTO deptDTO=new DeptDTO();
			
			deptDTO.setDeptno(rs.getInt("deptno"));
			deptDTO.setDname(rs.getString("dname"));
			deptDTO.setLoc(rs.getString("loc"));
			arrayList.add(deptDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return arrayList;
		
	}
	
	
	
	
	
}
