package springBoot.Hibernate.Rest.CRUD.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;
import springBoot.Hibernate.Rest.CRUD.Employee.DAO.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier(value="employeeDaoJPAImpl")
	private EmployeeDAO employeeDAO;
	

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
		
		
	}

}
