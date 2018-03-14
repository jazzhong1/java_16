package com.iu.db3;

import java.sql.*;
import java.util.*;

public class EmpDAO {
	private String user;
	private String password;
	private String url;
	private String driver;
	//1.insert 추가	
	//input으로 입력받고 추가 
	//결과값을 boolean으로 주지말고 int로 준다.
	
	public EmpDAO() {
		user="scott";
		password="tiger";
		url="jdbc:oracle:thin:@192.168.20.58:1521:xe";
		driver="oracle.jdbc.driver.OracleDriver";

	}
	
	
	public ArrayList<EmpDTO>  selectALL() throws Exception{
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url,user,password);
		
		String sql="select * from emp";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		
		ResultSet rs=st.executeQuery();
		
		ArrayList<EmpDTO> arrayList=new ArrayList<>();
		while(rs.next()){
			EmpDTO dto=new EmpDTO();
			
			dto.setEmpno(rs.getInt("empno"));
			dto.setEname(rs.getString("ename"));
			dto.setJob(rs.getString("job"));
			dto.setMgr(rs.getInt("mgr"));
			dto.setHiredate(rs.getDate("hiredate"));
			dto.setSal(rs.getInt("sal"));
			dto.setComm(rs.getInt("comm"));
			dto.setDeptno(rs.getInt("deptno"));
			
			arrayList.add(dto);
		}
		
		return arrayList;
	}

}
