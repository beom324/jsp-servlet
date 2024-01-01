package com.sist.vo;

public class DeptVO {
	private int dno;
	private String dName;
	private String dLoc;
	public int getDno() {
		return dno;
	}
	public void setDept(int dept) {
		this.dno = dept;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdLoc() {
		return dLoc;
	}
	public void setdLoc(String dLoc) {
		this.dLoc = dLoc;
	}
	public DeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeptVO(int dno, String dName, String dLoc) {
		super();
		this.dno = dno;
		this.dName = dName;
		this.dLoc = dLoc;
	}
	
	
}
