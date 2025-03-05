//İsa ŞİMŞEK 150122038
import java.util.Calendar;

public class RegularEmployee extends Employee{
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence, double
			salary, Calendar hireDate, Department department, double
			performanceScore) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setPerformanceScore(performanceScore);
	}
	public RegularEmployee (Employee employee, double perfScore) {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.isHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(perfScore);
	}
	
	public double getPerformanceScore() {
		return performanceScore;
	}
	
	public void setPerformanceScore(double performanceScore) {
		try {
			if (performanceScore < 1)
				throw new Exception();
				this.performanceScore = performanceScore;
		} 
		catch (Exception e) {
			System.out.println("performance score must be a positive value!!!!");
			System.exit(1);
		}
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = ((int)(bonus *100)) / 100.0 ;
	}
	
	public String toString () {
		return  	"RegularEmployee\n"
					+"			        " + "Person Info [id=" +getId()+", firstName="+getFirstName()+", lastName="+getLastName()+", gender="+getGender()+"]\n"
					+ "			        " + "Employee Info [salary="+getSalary()+", hireDate="+Test.clndrToString(getHireDate())+"]\n"
			    	 + "		 	      " + "  RegularEmployee Info [performanceScore="+performanceScore+", bonus="+bonus+"]\n";
	}
}
