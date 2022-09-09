package springBoot.Hibernate.Rest.CRUD.Employee.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;
@Repository
public class EmployeeDaoJPAImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		//create a query
		Query theQuery = (Query) entityManager.createQuery("from Employee");
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		//get employee
		Employee theEmployee = entityManager.find(Employee.class, id);
		//return employee
		
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update the employee
		Employee theEmployee1 = entityManager.merge(theEmployee);
		// update with id from theEmployee1 ....so we can get generated id for save/insert
		theEmployee.setId(theEmployee.getId());
	}

	
	@Override
	public void deleteById(int theId) {
		Query theQuery = (Query) entityManager.createQuery("delete from Employee where id = :employeeId ");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
