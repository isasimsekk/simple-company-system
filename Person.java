//İsa ŞİMŞEK 150122038
import java.util.Calendar;
public class Person {
	private int id ;
	private String firstName;
	private String lastName;
	private byte gender;
	private Calendar birthDate;
	private byte maritalStatus ;
	private boolean hasDriverLicence;

	public Person(String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		if (gender.equals("Man"))
			this.gender = 1;
		else
			this.gender = 2;
		
		this.birthDate = birthDate;
		
		if (maritalStatus.equals("Single"))
			this.maritalStatus = 1;
		else
			this.maritalStatus = 2;
		
		if (hasDriverLicence.equals("Yes"))
			this.hasDriverLicence = true;
		else
			this.hasDriverLicence = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		try {
			if (id < 1)
				throw new Exception();
				this.id = id;
		} 
		catch (Exception e) {
			System.out.println("id must be a positive value!!!!");
			System.exit(1);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		try {
			if(firstName.length() < 3) {
				throw new Exception();
			}
				this.firstName = firstName;
		}
		catch(Exception e) {
			System.out.println("the first name is too short!!!!!");
			System.exit(1);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		try {
			if(lastName.length() < 3) {
				throw new Exception();
			}
				this.lastName = lastName;
		}
		catch(Exception e) {
			System.out.println("the first name is too short!!!!!");
			System.exit(1);
		}
	}

	public String getGender() {
		if (gender == 1)
			return "Man";
		else
			return "Woman";
	}

	public void setGender(String gender) {
		try {
		if(gender.length() < 3) {
			throw new Exception();
		}
		
		if (gender.equals("Man"))
			this.gender = 1;
		else
			this.gender = 2;
		}
		catch(Exception e) {
			
		}
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		if (maritalStatus == 1) 
			return "Single";
		else
			return "Married";
	}

	public void setMaritalStatus(String maritalStatus) {
		if (maritalStatus.equals("Single"))
			this.maritalStatus = 1;
		else
			this.maritalStatus = 2;
	}

	public String isHasDriverLicence() {
		if(hasDriverLicence == true)
			return "Yes";
		else
			return "No";
	}

	public void setHasDriverLicence(String hasDriverLicence) {
		if (hasDriverLicence.equals("Yes"))
			this.hasDriverLicence = true;
		else
			this.hasDriverLicence = false;
	}
	
	public String toString() {
		return "Person [id="+id+", firstName="+firstName+", lastName="+lastName+", gender="+getGender()+", birthDate="
				+Test.clndrToString(birthDate)+", maritalStatus="+getMaritalStatus()+", hasDriverLicence="+isHasDriverLicence()+"]";
	}
}
