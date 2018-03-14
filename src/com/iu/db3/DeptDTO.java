package com.iu.db3;

public class DeptDTO {
	//테이블이라고 생각해야함
	//멤버 변수를 Colum 이라고 보면됨
	
	private int deptno;
	private String dname;
	private String loc;
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
