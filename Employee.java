//İsa ŞİMŞEK 150122038
import java.util.Calendar;

public class Employee extends Person{
	private double salary;
	private Calendar hireDate;
	Department department;
	public static int numberOfEmployees = 0;
	
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department) {
		
		super( firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence);
		setSalary(salary);
		this.hireDate = hireDate;
		this.department = department;
		numberOfEmployees++;
	}
	
	public Employee(Person person, double salary, Calendar hireDate, Department department) {
		super( person.getFirstName(), person.getLastName(), person.getId(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.isHasDriverLicence());
		setSalary(salary);
		this.hireDate = hireDate;
		this.department = department;
		numberOfEmployees++;
	}
	
	public double raiseSalary(double percent) {
		salary = salary + salary * percent;
		return salary;
	}
	
	public double raiseSalary(int amount) {
		salary = salary + amount;
		return salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		try {
			if (salary < 1)
				throw new Exception();
			this.salary = salary;
		} 
		catch (Exception e) {
			System.out.println("salary cannot be a negative value!!!!");
			System.exit(1);
		}
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public String toString () {
		return "Employee Info [salary="+salary+", hireDate="+Test.clndrToString(hireDate)+"]";
	}
}
