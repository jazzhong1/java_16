package com.iu.db3;

import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
	
//		new DeptController().start();
		
		EmpDAO dao=new EmpDAO();
		
		ArrayList<EmpDTO> arrayList=dao.selectALL();
		new View().view1(arrayList);
		
			
			
		
		
	}

}
