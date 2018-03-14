package com.iu.db2;

import java.util.*;

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

}
