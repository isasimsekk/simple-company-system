//İsa ŞİMŞEK 150122038
import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee{
	private ArrayList<Project> projects;
	private static int numberOfDevelopers;
	
	public Developer(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence, double
			salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Project> p) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		this.projects = p;
		numberOfDevelopers++;
	}
	public Developer(RegularEmployee re, ArrayList<Project> p) {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.isHasDriverLicence(),
				re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		this.projects = p;
		numberOfDevelopers++;
	}
	
	public boolean addProject(Project s) {
		projects.add(s);
		return true;
	}
	
	public boolean removeProject(Project s) {
		projects.remove(s);
		return false;
	}
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}
	
	public String toString () {
		String s = "";
		for(int i = 0; i < projects.size(); i++) {
			if (s.equals(""))
				s = projects.get(i).toString();
			
			else
				s = s +", "+ projects.get(i).toString(); 
		}
		
		return "Developer\n"
			 + "			        " + "Person Info [id=" +getId()+", firstName="+getFirstName()+", lastName="+getLastName()+", gender="+getGender()+"]\n"
		     + "			        " + "Employee Info [salary="+getSalary()+", hireDate="+Test.clndrToString(getHireDate())+"]\n"
		     + "    		           " + "     RegularEmployee Info [performanceScore="+getPerformanceScore()+", bonus="+getBonus()+"]\n"
		     + "  	                    " + "    ["+s+"]\n";
	}
}
