package org.restJersyClint.JersyRestClient.modal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee 
{
	private String empNo;
	private String empName;
	private String position;
	
	public Employee()
	{
		
	}
	
	//right click->Source-> Generate constructor using fields
	public Employee(String empNo, String empName, String position) 
	{
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
	}

	/*
	 * public Employee(String string, String string2, String string3) { // TODO
	 * Auto-generated constructor stub }
	 */

	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
