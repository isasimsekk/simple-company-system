//İsa ŞİMŞEK 150122038
import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person{
	private ArrayList<Product> products;
	
	public Customer( int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus,String hasDriverLicence,
			ArrayList<Product>products){
		
		super( firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
	}
	
	public Customer(Person person, ArrayList<Product> products) {
		super( person.getFirstName(), person.getLastName(), person.getId(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.isHasDriverLicence());
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public String toString () {
		String s = "";
		for(int i = 0; i < products.size(); i++) {
			if (s.equals(""))
				s = products.get(i).toString();
			
			else
				s = s +", "+ products.get(i).toString(); 
		}
		
		return "Customer [id: "+getId() +" products=["+s+"]]";
	}
}
