package springBoot.Hibernate.Rest.CRUD.Employee.DAO;

import java.util.List;


import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import springBoot.Hibernate.Rest.CRUD.Employee.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	// defined field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
		// EntityManager automatically created by spring boot and we can simply injected
		// here into our application
	}

	@Override
	//@Transactional // handles transaction management so we don't have to manually start and commit
					// transaction
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employee = theQuery.getResultList();

		// return the result

		return employee;
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, id);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save Employee
		//Employee x =currentSession.load(Employee.class, employeeId);
		
		currentSession.saveOrUpdate(theEmployee);		
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id = :employeeid");
		theQuery.setParameter("employeeid", theId);
		theQuery.executeUpdate();
		
		
	}

}
