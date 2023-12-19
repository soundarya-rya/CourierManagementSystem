package com.hexaware.entity;

public class Employee {
	private int empno;
	private String ename;
	private String role;
	private int salary;
	private String email;
	private String contactNo;
	
	public int getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}
	public String getrole() {
		return role;
	}
	public String getemail() {
		return email;
	}
	public int getSalary() {
		return salary;
	}
	public String getcontactNo() {
		return contactNo;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setemail(String email) {
		this.email = email;
	}

	public void setSal(int salary) {
		this.salary = salary;
	}
	public void setcontactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ",Role "+ role +"]";
	}


}
