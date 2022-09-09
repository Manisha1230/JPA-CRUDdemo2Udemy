package springBoot.Hibernate.Rest.CRUD.Employee.DAO;

import java.util.List;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;

public interface EmployeeDAO 
{
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
