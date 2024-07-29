package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.entities.Department;
import com.entities.Employee1;



public class Controller {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate_config.xml").buildSessionFactory();
		Session s=factory.openSession();
		Transaction tx= s.beginTransaction();
		System.out.println("hii I am change");
		/*
		Department dep=new Department(1003,"wireless","phq lalkothi jaipur");
		
		
		Employee1 emp1 =new Employee1(11,"mukesh sharma","bassi",dep);
		Employee1 emp2 =new Employee1(12,"ram singh","phulera",dep);
		Employee1 emp3 =new Employee1(13,"dinesh meena","ninder",dep);
		Employee1 emp4 =new Employee1(14,"nanu saini","chomu",dep);
		Employee1 emp5 =new Employee1(15,"mahesh choudhary","ghatgate",dep);
		
		List<Employee1> empList=new ArrayList<Employee1>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		dep.setEmployees(empList);
		
		s.save(dep);
		*/
		//HQL query
		//Data Fetch
		String query1="from Employee1";
		String query2="from Employee1 where employee_address='ninder'";
		String query3="from Employee1 where employee_address=:x";
		String query4="from Employee1 as s where s.employee_address=:x";
		String query5="from Employee1 as s where s.employee_name=:x and s.employee_address=:y";
		Query q= s.createQuery(query5);
		q.setParameter("x", "shankar");
		q.setParameter("y", "chomu");
		//single result-unique result
		//mullti result
		List<Employee1> emplist1= q.list();
		for(Employee1 emp6:emplist1) {
			System.out.println(emp6.getEmployee_name()+" : "+emp6.getDepartment().getDepartment_name());
		}
		
		//Data Delete
		/*String query6="delete from Employee1 as s where s.employee_address=:a";
		Query q2= s.createQuery(query6);
		q2.setParameter("a", "ghatgate");
		int r= q2.executeUpdate();
		System.out.println(r);
		tx.commit();
		s.close();
		factory.close();*/
		
		//Update Data
		/*
		String update="update  Employee1 as s set s.employee_name=:n where s.employee_address=:i and s.employee_address=:j";
		Query q3= s.createQuery(update);
		q3.setParameter("n", "shankar lal jat");
		q3.setParameter("i", "chomu");
		q3.setParameter("j", "ninder");
		int r1=q3.executeUpdate();
		System.out.println(r1);
		*/
		
		//join Table
		String joinQuery="select d.department_id,d.department_name, e.employee_name from Department as d INNER JOIN d.employees as e";
	    Query q4= s.createQuery(joinQuery);
	    List<Object[]> list=q4.getResultList(); 
	    for(Object[] arr:list) {
	    	System.out.println(Arrays.toString(arr));
	    }
	    
	    //pagination 1 to 3 or  0 to 10
	    
	    String joinQuery1="select d.department_id,d.department_name, e.employee_name from Department as d INNER JOIN d.employees as e";
	    Query q5= s.createQuery(joinQuery1);
	    /*
	     list of 0 index to 3 th index
	    q5.setFirstResult(0);
	    q5.setMaxResults(4);
	    */
	    /*
	    list of 3 index to 6 th index
	    q5.setFirstResult(3);
	    q5.setMaxResults(4);
	    */
	    /*
	    list of 5 index to 6 th index
	    q5.setFirstResult(5);
	    q5.setMaxResults(2);
	    */
	    List<Object[]> list2=q5.getResultList(); 
	    for(Object[] arr:list2) {
	    	System.out.println(Arrays.toString(arr));
	    }
	    
	    //SQJ query
	    
	    String sqlQuery="select * from Employee1";
	    NativeQuery sql= s.createSQLQuery(sqlQuery);
	    List<Employee1> list3= sql.list();
	    for(Employee1 emp:list3) {
	    	System.out.println(emp.getEmployee_address());
	    }
	  
	    
	    tx.commit();
		s.close();
		factory.close();
	    
	}
}
