package springBoot.Hibernate.Rest.CRUD.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;
import springBoot.Hibernate.Rest.CRUD.Employee.DAO.EmployeeDAO;
import springBoot.Hibernate.Rest.CRUD.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
  private EmployeeService employeeService;
  
  //inject employee dao(use constructor injection)
  @Autowired
  public EmployeeRestController(EmployeeService theEmployeeService) {
	  employeeService = theEmployeeService;
  }
  //expose "/employees" and return list of employees
  @GetMapping("/employees")
  public List<Employee> findAll(){
	return employeeService.findAll();
	  
  }
  //add mapping for GET/employees/{employeeId}
  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable int employeeId) {
	  Employee theEmployee = employeeService.findById(employeeId);
	  if(theEmployee == null) {
		  throw new RuntimeException("Employee id not found -" + employeeId);
	  }
	  
	return theEmployee;
 }
  //add mapping for POST/employees - add new employee
  @PostMapping("/save")
  public void addEmployee(@RequestBody Employee theEmployee) {
	
	  employeeService.save(theEmployee);
}
  //add mapping for put/employees - update existing employee
  @PutMapping("/updateEmployee/{employeeId}")
  public void updateEmployee(@RequestBody Employee theEmployee) {
	  employeeService.save(theEmployee);
	}
  
  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
	Employee temp = employeeService.findById(employeeId);
	 if(temp == null) {
		  throw new RuntimeException("Employee id not found -" + employeeId);
	  }
	 employeeService.deleteById(employeeId);
	 return "Deleted employee id - " +employeeId;
	 
	  
  }
  
}
  
  
	

