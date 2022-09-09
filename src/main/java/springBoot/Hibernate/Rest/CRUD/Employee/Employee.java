package springBoot.Hibernate.Rest.CRUD.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Emp_id")
	private int id;

	@Column(name = "Emp_fname")
	private String fname;

	@Column(name = "Emp_lname")
	private String lname;

	@Column(name = "Emp_email")
	private String email;
	
//define constructor 
	public Employee() {

	}
  public Employee(String fname, String lname, String email) {
        this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
  //create getter and setter
public int getId() {
	return id;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
}
public void setId(int id2) {
	// TODO Auto-generated method stub
	
}

}
