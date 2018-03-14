package com.iu.db3;

import java.util.*;

public class Input {

	private Scanner sc;
	public Input() {
		sc = new Scanner(System.in);

	}

	public DeptDTO inputDept() {
		DeptDTO deptDTO=new DeptDTO();

		System.out.println("deptno:");
		deptDTO.setDeptno(sc.nextInt());
		System.out.println("dname:");
		deptDTO.setDname(sc.next());
		System.out.println("loc");
		deptDTO.setLoc(sc.next());
				
		return deptDTO;
	}

}
