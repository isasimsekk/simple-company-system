//İsa ŞİMŞEK 150122038
import java.util.Calendar;

public class Project {
	private String projectName;
	private Calendar startDate;
	private boolean state;
	public Project(String pName, Calendar startDate, String state) {
		setProjectName(pName);
		this.startDate = startDate;
		
		if(state.equals("Open"))
			this.state = true;
		else
			this.state = false;
	}
	
	public void setState (String state) {
		if(state.equals("Open"))
			this.state = true;
		else
			this.state = false;
	}
	
	public String getState () {
		if(state)
			return "Open";
		else
			return "Close";
	}
	
	public void close () {
		if(state)
			state = false;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		try {
			if(projectName.length() < 3) {
				throw new Exception();
			}
				this.projectName = projectName;
		}
		catch(Exception e) {
			System.out.println("the project name is too short!!!!!");
			System.exit(1);
		}
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	public String toString () {
		return "Project [projectName="+projectName+", startDate="+Test.clndrToString(startDate)+", state="+state+"]";
	}
	
}
