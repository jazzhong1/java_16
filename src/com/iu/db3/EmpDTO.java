package com.iu.db3;

import java.sql.*;

public class EmpDTO {
							//데이이터베이스에서 들어오는 DTO클래스를 만들때
							//Reference 타입으로 만들어 주는것이 좋다.
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;	//TimeStamp 도 가능(밀리세컨까지)
	private int sal;
	private Integer comm;	//null이 들어갈수도 있기때문에 
	private int deptno;
	
	
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	
}
