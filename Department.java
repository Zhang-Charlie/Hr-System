import java.util.ArrayList;

public class Department {

	private int departmentNumber;
	private String departmentName;
	private ArrayList<Employee> infoEmployees = new ArrayList<Employee>(); // Declare an global ArrayList of Employee objects called "infoEmployees".
		
	public Department() {
		
	}

	public Department(int departmentNumber, String departmentName) {
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
	}
	
	// Added getters and setters to get and set information
	public void addEmployee(Employee b) {
		infoEmployees.add(b); //Add a new Employee to the Department's list of published Employees
	}
	
	public void removeEmployee(Employee b) {
		infoEmployees.remove(b); 
	}
	
	public int getdDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public ArrayList<Employee> getInfoEmployees() {
		return infoEmployees;
	}

	public void setInfoEmployees(ArrayList<Employee> infoEmployees) {
		this.infoEmployees = infoEmployees;
	}
	
	
	
}
