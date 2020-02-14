package ind.gopinnath.example.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {

	@Id
	@Column(name="employee_id")
	private BigInteger employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="desingation")
	private String desingation;

	public BigInteger getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(BigInteger employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesingation() {
		return desingation;
	}

	public void setDesingation(String desingation) {
		this.desingation = desingation;
	}
	
}
