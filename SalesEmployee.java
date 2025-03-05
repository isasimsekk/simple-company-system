//İsa ŞİMŞEK 150122038
import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee{
	private ArrayList<Product> sales;
	private static int numberOfSalesEmployee;
	
	public SalesEmployee(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence, double
			salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Product> s) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		this.sales = s;
		numberOfSalesEmployee++;
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.isHasDriverLicence(),
				re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		this.sales = s;
		numberOfSalesEmployee++;
	}
	
	public boolean addSale(Product s) {
		sales.add(s);
		return true;
	}
	public boolean removeSale(Product s) {
		sales.remove(s);
		return false;
	}

	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployee() {
		return numberOfSalesEmployee;
	}
	
	public String toString () {
		String s = "";
		for(int i = 0; i < sales.size(); i++) {
			if (s.equals(""))
				s = sales.get(i).toString();
			
			else
				s = s +", "+ sales.get(i).toString(); 
		}
		
		return "SalesEmployee\n"
				 + "			        " + "Person Info [id=" +getId()+", firstName="+getFirstName()+", lastName="+getLastName()+", gender="+getGender()+"]\n"
			     + "			        " + "Employee Info [salary="+getSalary()+", hireDate="+Test.clndrToString(getHireDate())+"]\n"
			     + "    		           " + "     RegularEmployee Info [performanceScore="+getPerformanceScore()+", bonus="+getBonus()+"]\n"
			     + "  	                    " + "    ["+s+"]\n";
	}
}
