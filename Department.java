//İsa ŞİMŞEK 150122038
public class Department {
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) {
		setDepartmentId(departmentId) ;
		setDepartmentName(departmentName);
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		try {
			if (departmentId < 1)
				throw new Exception();
				this.departmentId = departmentId;
		} 
		catch (Exception e) {
			System.out.println("department id must be a positive value!!!!");
			System.exit(1);
		}
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		try {
			if(departmentName.length() < 3) {
				throw new Exception();
			}
				this.departmentName = departmentName;
		}
		catch(Exception e) {
			System.out.println("the department name is too short!!!!!");
			System.exit(1);
		}
	}
	
	public String toString () {
		return "Department [departmentId="+departmentId+", departmentName="+departmentName+"]\n";
	}
}
