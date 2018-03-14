package com.iu.db3;

import java.util.*;

import oracle.net.aso.*;

public class View {
	
	public void view(ArrayList<DeptDTO> arrayList){
		
		for(DeptDTO dept :arrayList){
			this.view(dept);
		
		}
	}
	
	public void view(DeptDTO dept){
		
		System.out.println("==============================");
		System.out.println("DEPTNO: "+dept.getDeptno());
		System.out.println("DNAME: "+dept.getDname());
		System.out.println("LOC: "+dept.getLoc());
	
	}
	
	public void view(String str){
		System.out.println(str);
	}
	
	
	public void view1(ArrayList<EmpDTO> arrayList){
		
		for(EmpDTO emp:arrayList) {
		System.out.println("==============================");
		System.out.println("EMPNO: "+emp.getDeptno());
		System.out.println("ENAME: "+emp.getEname());
		System.out.println("JOB: "+emp.getJob());
		System.out.println("MGR: "+emp.getMgr());
		System.out.println("HIREDATE: "+emp.getHiredate());
		System.out.println("SAL: "+emp.getSal());
		System.out.println("COMM: "+emp.getComm());
		System.out.println("DEPTNO: "+emp.getDeptno());
		}
	}

}
