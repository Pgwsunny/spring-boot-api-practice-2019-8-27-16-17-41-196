package com.tw.apistackbase.model;

import java.util.List;

public class Company {
	private int companyId;
	private String companyName;
	private String companyInfo;
	private List<Employees> employeeList;
	
	public Company() {
		
	}
	public Company(int companyId, String companyName, String companyInfo, List<Employees> employeeList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyInfo = companyInfo;
		this.employeeList = employeeList;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public List<Employees> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employees> employeeList) {
		this.employeeList = employeeList;
	}
	
}
