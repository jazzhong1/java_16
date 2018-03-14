package com.iu.db2;

import java.sql.*;
import java.util.*;

public class SelectTest2 {

	public static void main(String[] args) {
		// 부서 번호를 입력받아서 해당부서 정보를 출력

		String user = "scott";
		String password = "tiger";
		View view = new View();

		String url = "jdbc:oracle:thin:@192.168.20.58:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호:");
		int deptno = sc.nextInt();
		ArrayList<DeptDTO> arrayList = new ArrayList<>();

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			// =========세트
			String sql = "select * from dept where deptno=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, deptno); // 물음표에 넣어주기
									// 물음표에 넣어주기 안하면 excuteQuery에서 걸림

			// =========세트

			ResultSet rs = st.executeQuery();// DQL은 executeQuery 로 받는다.

			// Cursor 한줄씩 꺼내서 읽으려 한다.

			if (rs.next()) { // 여기서 where문에 따라 true,false 여부를 판단함.
								// PK가 아닌걸로 검색할경우 여러개가 올수도있다.
				DeptDTO dbDTO=new DeptDTO();
				
				dbDTO.setDeptno(rs.getInt("deptno"));
				dbDTO.setDname(rs.getString("dname"));
				dbDTO.setLoc(rs.getString("loc"));
				
				
				view.view(dbDTO);
			} else {
				System.out.println("해당 부서의 번호가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
