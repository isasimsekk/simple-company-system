//İsa ŞİMŞEK 150122038
import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee{
	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;
	
	public Manager(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence, double
			salary, Calendar hireDate, Department department,double bonusBudget) {
		
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setBonusBudget(bonusBudget);
	}
	
	public Manager(Employee employee, double bonusBudget) {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.isHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setBonusBudget(bonusBudget);
	}
	
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	public void distrubuteBonusBudget() {
		double sum = 0;
		for (int i = 0; i < regularEmployees.size(); i++) {
			sum += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
		}
		double unit = bonusBudget / sum;
		
		for (int i = 0; i < regularEmployees.size(); i++) {
			regularEmployees.get(i).setBonus(unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());
		}
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) {
		try {
			if (bonusBudget < 1)
				throw new Exception();
			this.bonusBudget = bonusBudget;
		} 
		catch (Exception e) {
			System.out.println("bonus budget must be a positive value!!!!");
			System.exit(1);
		}
	}
	
	public String toString() {
		return "	Manager [id: "+getId()+", "+getFirstName()+" "+getLastName()+"\r\n"
				+ "		# of Employees: "+regularEmployees.size()+"]\n";
	}
}
