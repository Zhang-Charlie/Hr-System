import java.text.DecimalFormat;

public class Employee {

	private int employeeNumber;
	private String firstName;
	private String lastName;
	private Department departmentName;
	private double employeeSalary;
	

	public Employee() {
		
	}

	public Employee(int employeeNumber, String lastName, String firstName, Department departmentName, double employeeSalary) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentName = departmentName;
		this.employeeSalary = employeeSalary;
	}
	
	public void printByLine() { //Prints all info on employee
		DecimalFormat currency = new DecimalFormat("###,###,###.##"); //This formats the numbers into currency, It allows commas to be formatted to read the numbers easier
		System.out.print("Employee Number: " + employeeNumber);
		System.out.print("\t Surname: " + lastName);
		System.out.print("\t   First-Name: " + firstName);
		System.out.print("\t Department: " + departmentName.getDepartmentName());
		System.out.println("\t \t Annual Salary: €" + currency.format(employeeSalary));
	}
	// Added getters and setters to get and set information
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Department getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(Department departmentName) {
		this.departmentName = departmentName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	
	
}
