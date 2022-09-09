package springBoot.Hibernate.Rest.CRUD.Service;

import java.util.List;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;

public interface EmployeeService
{
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	

}
