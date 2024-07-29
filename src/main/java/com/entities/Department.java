package com.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="department_id")
	private int department_id;
	private String department_name;
	private String department_address;
	//cascade means relative data automatic save,dalete,update ALL TYPE
	@OneToMany(mappedBy="department" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Employee1> employees;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(int department_id) {
		super();
		this.department_id = department_id;
	}


	public Department(int department_id, String department_name, String department_address) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_address = department_address;
	}
	
	public Department(int department_id, String department_name, String department_address, List<Employee1> employees) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_address = department_address;
		this.employees = employees;
	}

	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_address() {
		return department_address;
	}
	public void setDepartment_address(String department_address) {
		this.department_address = department_address;
	}

	
	public List<Employee1> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee1> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_address=" + department_address + ", employees=" + employees + "]";
	}


	
	

	
}
