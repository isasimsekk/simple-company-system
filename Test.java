//İsa ŞİMŞEK 150122038
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws FileNotFoundException   {
		
		File file = new File("input.txt");
		
		ArrayList<Department> department = new ArrayList<Department>();
		ArrayList<Person> person = new ArrayList<Person>(); 
		ArrayList<Product> product = new ArrayList<Product>();
		ArrayList<Project> project = new ArrayList<Project>();
		ArrayList<Customer> customer = new ArrayList<Customer>();
		
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
		switch(input.next()) {
		case "Department":  department.add(new Department (input.nextInt(), input.next()));
			break;
			
		case "Person": person.add(new Person(input.next(), input.next(),input.nextInt(), 
				input.next(), clndr(input.next()), input.next(), input.next()));
			break;
			
		case "Product": product.add(new Product(input.next(), clndr(input.next()), input.nextDouble()));
			break;
			
		case "Project": project.add(new Project(input.next(), clndr(input.next()), input.next()));
			break;
			
		case "Employee":int idNumb = input.nextInt();
						int index = 0;	
						for(int i = 0; i < person.size(); i++) {
							if(idNumb == person.get(i).getId())
								index = i;
				}
				person.set(index,new Employee(getPersonWithId(idNumb, person), 
				input.nextDouble(),clndr(input.next()), getDp(input.next(), department)));
			break;
			
		case "Customer":int idNumb1 = input.nextInt();
						int index1 = 0;	
						for(int i = 0; i < person.size(); i++) {
							if(idNumb1 == person.get(i).getId())
								index1 = i;
				 } 
			     person.set(index1,new Customer(getPersonWithId(idNumb1, person), productList(input.nextLine(), product)));
			     customer.add((Customer) person.get(index1));
			break;
			
		case "Manager": int idNumb2 = input.nextInt();
						int index2 = 0;	
						for(int i = 0; i < person.size(); i++) {
							if(idNumb2 == person.get(i).getId())
								index2 = i;
			     }
			     person.set(index2,new Manager((Employee)(getPersonWithId(idNumb2, person)), input.nextDouble()));
			break;
			
		case "RegularEmployee":int idNumb3 = input.nextInt();
							   int index3 = 0;	
							   for(int i = 0; i < person.size(); i++) {
								   if(idNumb3 == person.get(i).getId())
									   index3 = i;
				}
			    person.set(index3,new RegularEmployee((Employee)(getPersonWithId(idNumb3, person)), input.nextDouble()));
			break;
			
		case "SalesEmployee":int idNumb4 = input.nextInt();
							 int index4 = 0;	
							 for(int i = 0; i < person.size(); i++) {
								 if(idNumb4 == person.get(i).getId())
									 index4 = i;
				}
			    person.set(index4,new SalesEmployee((RegularEmployee)(getPersonWithId(idNumb4, person)),
								productList(input.nextLine(), product)));
			break;
			
		case "Developer":int idNumb5 = input.nextInt();
						 int index5 = 0;	
						 for(int i = 0; i < person.size(); i++) {
							 if(idNumb5 == person.get(i).getId())
								 index5 = i;
			    } 
			    person.set(index5,new Developer((RegularEmployee)(getPersonWithId(idNumb5, person)), 
								projectList(input.nextLine(), project)));
			break;
			}
		}
			input.close();
	
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof Manager) {
				((Manager)person.get(i)).setRegularEmployees(setManager(person, 
				          ((Manager)person.get(i)).getDepartment().getDepartmentName()));
			}
		}
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof Manager) {
				((Manager)person.get(i)).distrubuteBonusBudget();
				((Manager)person.get(i)).raiseSalary(0.2);
			}
		}
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof RegularEmployee && !(person.get(i) instanceof SalesEmployee) 
					&& !(person.get(i) instanceof Developer)) {
				((RegularEmployee)person.get(i)).raiseSalary(0.3);
			}
		}
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof Developer) {
				((Developer)person.get(i)).raiseSalary(0.23);
			}
		}
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof SalesEmployee) {
				((SalesEmployee)person.get(i)).raiseSalary(0.18);
			}
		}
		calculateMaxSalesEmployee(person).raiseSalary(10000);
		
		
		//Printing to the console..
		File outputFile = new File("output.txt");
		PrintWriter output = new PrintWriter(outputFile);
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof Manager) {
				int a = 0;
				output.print("************************************************\n");
				output.print(((Manager)person.get(i)).getDepartment().toString());
				output.print(((Manager)person.get(i)).toString());
				for (int j = 0; j < ((Manager)person.get(i)).getRegularEmployees().size(); j++) {
					if(((Manager)person.get(i)).getRegularEmployees().get(j) instanceof Developer) {
						a++;
						output.print("                        "+a+". "+((Developer)((Manager)person.get(i)).getRegularEmployees().get(j)).toString());
					}
				}
				for (int j = 0; j < ((Manager)person.get(i)).getRegularEmployees().size(); j++) {
					if(((Manager)person.get(i)).getRegularEmployees().get(j) instanceof SalesEmployee) {
						a++;
						output.print("                        "+a+". "+((SalesEmployee)((Manager)person.get(i)).getRegularEmployees().get(j)).toString());
					}
				}
				for (int j = 0; j < ((Manager)person.get(i)).getRegularEmployees().size(); j++) {
					if(((Manager)person.get(i)).getRegularEmployees().get(j) instanceof RegularEmployee 
							&& !(((Manager)person.get(i)).getRegularEmployees().get(j) instanceof SalesEmployee) 
							&& !(((Manager)person.get(i)).getRegularEmployees().get(j) instanceof Developer)) {
						a++;
						output.print("                        "+a+". "+((RegularEmployee)((Manager)person.get(i)).getRegularEmployees().get(j)).toString());
					}
				}
				output.print("\n");
			}
		}
		
		output.print("\n");
		output.print("\n");
		output.print("**********************CUSTOMERS************************\n");
		for(int i = 0; i < customer.size(); i++) {
			output.print((customer.get(i)).toString() + "\n");
			
		}
		
		output.print("\n");
		output.print("\n");
		output.print("**********************PEOPLE************************\n");
		for(int i = 0; i < person.size(); i++) {
			if(!(person.get(i) instanceof Employee) && !(person.get(i) instanceof Customer)) {
				output.print(((Person)person.get(i)).toString() + "\n");
			}
		}
		output.close();
	}
	
	
	public static Calendar clndr (String s) {
		String[] clndr = new String[3];
		clndr = s.split("[/]");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(clndr[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(clndr[1])-1);
        calendar.set(Calendar.DATE, Integer.parseInt(clndr[0]));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
		
		return calendar;
	}	
	
	public static Person getPersonWithId(int a, ArrayList<Person> person) {
		int numb = -1;
		for (int i = 0; i < person.size(); i++ ) {
			if(person.get(i).getId() == a) 
				numb = i;
		}
		if(numb >= 0 && numb < person.size())
		return person.get(numb);
		
		else
			return null;
	}
	
	public static Department getDp(String s, ArrayList<Department> department) {
		int numb = -1;
		for (int i = 0; i < department.size(); i++ ) {
			if(department.get(i).getDepartmentName().equals(s))
				numb = i;
		}	
		if(numb >= 0 && numb < department.size())
			return department.get(numb);
			
		else
			return null;
	}
	
	public static ArrayList<Product> productList(String s, ArrayList<Product> product){
		ArrayList<String> str = new ArrayList<String>(Arrays.asList(s.split("[ ]")));
		for (int i = 0; i< str.size(); i++)
			if(str.get(i).equals(""))
				str.remove(i);
		
		ArrayList<Product> list = new ArrayList<Product>();
		for(int j = 0; j < str.size(); j++) 
		for (int i  = 0; i < product.size(); i++)
				if(product.get(i).getProductName().equals(str.get(j)))
					list.add(product.get(i));
			
		return list;
	}
	
	public static ArrayList<Project> projectList(String s, ArrayList<Project> project){
		ArrayList<String> str = new ArrayList<String>(Arrays.asList(s.split("[ ]")));
		for (int i = 0; i< str.size(); i++)
			if(str.get(i).equals(""))
				str.remove(i);
		
		ArrayList<Project> list = new ArrayList<Project>();
		for(int j = 0; j < str.size(); j++)
		for (int i  = 0; i < project.size(); i++) 
				if(project.get(i).getProjectName().equals(str.get(j)))
					list.add(project.get(i));
			
		return list;
	}
	
	public static ArrayList<RegularEmployee> setManager(ArrayList<Person> person, String department){
		ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
		
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof Developer) {
				if (((Developer)person.get(i)).getDepartment().getDepartmentName().equals(department)) {
					regularEmployees.add((Developer)person.get(i));
				}
			}
			if(person.get(i) instanceof SalesEmployee) {
				if (((SalesEmployee)person.get(i)).getDepartment().getDepartmentName().equals(department)) {
					regularEmployees.add((SalesEmployee)person.get(i));
				}
			}
			if(person.get(i) instanceof RegularEmployee && !(person.get(i) instanceof Developer) && !(person.get(i) instanceof SalesEmployee)) {
				if (((RegularEmployee)person.get(i)).getDepartment().getDepartmentName().equals(department)) {
					regularEmployees.add((RegularEmployee)person.get(i));
				}
			}
		}
		return regularEmployees;
	}
	
	public static SalesEmployee calculateMaxSalesEmployee (ArrayList<Person> person) {
		int numb = 0;
		double temp = 0;
		for(int i = 0; i < person.size(); i++) {
			if(person.get(i) instanceof SalesEmployee) {
				double s = 0;
				for (int j = 0; j < ((SalesEmployee)person.get(i)).getSales().size(); j++) {
					s += ((SalesEmployee)person.get(i)).getSales().get(j).getPrice();
				}
				if (s > temp){
					numb = i;
				}
				temp = s;
			}
		}
		return (SalesEmployee)(person.get(numb));
	}
	
	public static String clndrToString(Calendar c) {
		return c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
	}
}