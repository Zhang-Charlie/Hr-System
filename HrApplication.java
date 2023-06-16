import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Charlie Zhang
 * DATE: 03/03/2023
 *
 */
public class HrApplication {
	
	
	static ArrayList<Employee> allEmployees = new ArrayList<Employee>(); // Declare an global ArrayList of Employee objects called "allEmployees".
	static ArrayList<Department> allDepartments = new ArrayList<Department>(); //Declare an ArrayList of Department objects called "allDepartments".
	static int centralEmployeeID = 1005; // centralEmployeeID set to 1005  for sorting employee numbers.
	static int centralDepartmentNumber = 105; // centralDepartmentNumber set it to 105 for sorting department numbers 
	// I used id and number interchangeable
	
	static Scanner input = new Scanner(System.in);
	static InputStreamReader textInput = new InputStreamReader(System.in); // Used to read text from an input stream by converting bytes into characters using a specified character encoding.
	static BufferedReader reader = new BufferedReader(textInput); // Reads text from a character-input stream, buffering characters for the efficient reading of characters, arrays, and lines.
	
	/**
	 * 
	 * The main method of the program that initialises the system with prePopulated data and starts the main menu.	
	 *  */
	public static void main(String[] args) {
		prePopulate();
		mainMenu();
	}

	/**
	 * This method displays the main menu for an HR system and prompts the user to enter their choice of action.
	 * The menu displays three options: accessing the employee menu, accessing the department menu, or exiting the system.
	 * If the user enters a valid option, the corresponding menu is displayed by calling the appropriate method.
	 * If the user enters an invalid option, an error message is displayed and the menu is displayed again.
	 * This method uses a switch statement to perform different actions based on the user's input.
	 * If the user chooses to exit the system, the program will terminate.
	 */
	private static void mainMenu() { // User friendly UI 
		System.out.println("-------------------------------HR System Main Menu---------------------------------------------"); // For cleaner UI
		System.out.println("Press 1 for Employee Menu");
		System.out.println("Press 2 for Department Menu");
		System.out.println("Press X to Exit");
		System.out.println("-----------------------------------------------------------------------------------------------"); // For cleaner UI

		String choice = input.next();
		choice = choice.toLowerCase(); // Read user input from the console and convert it to lower case

		// Use a switch statement to perform different actions based on the user's input
		switch(choice) {
			case"1":{
				employeeMenu();
				break; // Breaks out of switch method
			}
			case "2":{
				departmentMenu();
				break;
			}
			case "x":{ // Allows user to exit system.
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Shutting Down...");
				System.out.println("Goodbye...");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.exit(0);
				break;
			}
			// If the user input is anything else, print an error message to the console and break out of the switch statement
			default:{ 
				System.out.println("Invalid Choice. Try again");
				break;
			}
		}
		mainMenu();	//loops Back to main menu
	}
	
	/**
	 * This method displays the employee menu for an HR system and prompts the user to enter their choice of action.
	 * The menu displays five options: creating a new employee, editing an existing employee, dismissing an employee,
	 * viewing a list of all employees, or viewing the total cost of annual salaries for all employees in the organisation.
	 * If the user enters a valid option, the corresponding action is performed by calling the appropriate method.
	 * If an error occurs during the execution of an option, an error message is displayed and the menu is displayed again.
	 * If the user chooses to return to the main menu, the main menu is displayed.
	 * This method uses a switch statement to perform different actions based on the user's input.
	 * This method has no return value.
	 */
	
	private static void employeeMenu() { // Employee Menu
		
		System.out.println("-------------------------------Employee Menu---------------------------------------------------");
		System.out.println("Press 1 to Create New Employee");
		System.out.println("Press 2 to Edit an Employee");
		System.out.println("Press 3 to Dismiss an Employee");
		System.out.println("Press 4 to View Employees");
		System.out.println("Press 5 to View Cost of all Annual Salaries per Organization");
		System.out.println("Press M to Return to Main Menu");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		String choice = input.next();
		choice = choice.toLowerCase(); 
		
		switch(choice) {
			case "1":{
				try { // try-catch block - If an exception occurs it print an error message and return to the Employee Menu. Or will continue with the rest of the code.
					createEmployee();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was Logged.");
					System.out.println("Returning to Employee Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				break;
			}
			case "2":{
				try {
					editEmployee();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was Logged.");
					System.out.println("Returning to Employee Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				break;
			}
			case "3":{
				try {
					removeEmployee();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was Logged.");
					System.out.println("Returning to Employee Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				break;
			}
			case "4":{
				viewEmployees();
				break;
			}
			case "5":{
				combinedSalarys();
				break;
			}
			
			case "m":{
				mainMenu();
				break;
			}
			default:{
				System.out.println("Invalid Choice.");
				System.out.println("Returning to Employee Menu ...");
				break;
			}
		}
		employeeMenu(); // Loops back to employee menu
	}
	
	/**
	 * Method To create each employee this includes creating another number for the employee, logs the surname , first name, annual salary, and department.
	 * Prints new employee was added to the department it was put in
	 * If it does not work error message appears
	 */
	
	private static void createEmployee() throws Exception { // throws Exception in a method declaration indicates that the method can throw an exception, and the calling method or the runtime environment must handle the exception.
		Employee b = new Employee(); //Call Null Constructor to create object
		b.setEmployeeNumber(centralEmployeeID);  // Set the employee number for the new employee as the value of centralEmployeeID
		centralEmployeeID++; //increment value by 1, so unique value is given
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Enter Surename");
		System.out.println("-----------------------------------------------------------------------------------------------");
		b.setLastName(reader.readLine()); // Sets the last name of an employee. The readLine() method of the BufferedReader object reads a line of text from the console. 
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Enter First Name");
		System.out.println("-----------------------------------------------------------------------------------------------");
		b.setFirstName(reader.readLine());
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("What is the Employees Annual Salary?");
		System.out.println("-----------------------------------------------------------------------------------------------");
		b.setEmployeeSalary(input.nextDouble());
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		viewAllDepartments(); // Displays all Departments 
		System.out.println();
		System.out.println("Choose Department by Department Number");
		System.out.println("-----------------------------------------------------------------------------------------------");
		int chosenDepartment = input.nextInt(); //capture id value
		
		boolean isFound = false;
		
		for(Department currentDepartment: allDepartments) {
			if(currentDepartment.getdDepartmentNumber()==chosenDepartment) {
				isFound=true;
				b.setDepartmentName(currentDepartment);
				currentDepartment.addEmployee(b);
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("New Employee added to " + currentDepartment.getDepartmentName());
			}
		}
		if(isFound==false) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No Department with the Number " + chosenDepartment + " was Found.");
			System.out.println("All Employee Data has been lost.");
			System.out.println("Please Try Again.");
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		else {
			allEmployees.add(b);
		}
	}
	/**
	 * This method allows the user to edit an existing employee's information.
	 * It displays all the employees' numbers and names, and the user selects an employee to edit by entering the employee number.
	 * Then, it calls the editEmployeeMenu method to display the options available for editing and makes changes accordingly.
	 * Exception if there is an error editing the employee information.
	 */
	private static void editEmployee() throws Exception{
		System.out.println("-----------------------------------------------------------------------------------------------");
			for(Employee b: allEmployees) {
				System.out.println(b.getEmployeeNumber() + " " + b.getFirstName() + " " + b.getLastName());
			}
		System.out.println();
		System.out.println("Choose Employee by Number");
		System.out.println("-----------------------------------------------------------------------------------------------");
		int chosenEmployee = input.nextInt();
		boolean isFound = false;
		
		for(Employee currentEmployee: allEmployees) {
			if(currentEmployee.getEmployeeNumber() == chosenEmployee) {
				isFound=true;
				try {
					editEmployeeMenu(currentEmployee);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("Error Editing Employees");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}				
			}	
		}
		
		if(isFound==false) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No Employees with Numbers " + chosenEmployee + " was Found.");			
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	/**
	 *  Displays Employee Edit Menu Which allows you to edit the surname,first name,salary,department
	 *  Allows editing of an existing employee's details, such as surname, first name, salary, and department.
	 *  Displays a menu of options for the user to select from, then prompts for input to update the selected field.
	 *  If the user chooses to change the department, it calls the changeDepartment() method to update the employee's department.
	 *  
	 *  Exception If an error occurs during the input of the new employee data.
	 */
	private static void editEmployeeMenu(Employee currentEmployee) throws Exception {
		System.out.println("-------------------------------Edit Employee---------------------------------------------------");
		System.out.println("Press 1 to Change Surname");
		System.out.println("Press 2 to Change First Name");
		System.out.println("Press 3 to Change Employees Salary");
		System.out.println("Press 4 to Change Employees Department");
		System.out.println("Press M to Return to Employee Menu");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		String choice = input.next();
		choice=choice.toLowerCase();
		
		switch(choice) {
			case "1":{
				System.out.println("-------------------------------Edit Employee---------------------------------------------------");
				System.out.println("Enter New Surname");
				System.out.println("-----------------------------------------------------------------------------------------------");
				currentEmployee.setLastName(reader.readLine());
				break;
			}
			case "2":{
				System.out.println("-------------------------------Edit Employee---------------------------------------------------");
				System.out.println("Enter New First Name");
				System.out.println("-----------------------------------------------------------------------------------------------");
				currentEmployee.setFirstName(reader.readLine());
				break;
			}
			
			case "3":{
				System.out.println("-------------------------------Edit Employee---------------------------------------------------");
				System.out.println("Enter New Annual Salary");
				System.out.println("-----------------------------------------------------------------------------------------------");
				currentEmployee.setEmployeeSalary(input.nextDouble());
				break;
			}
			case "4":{
				changeDepartment(currentEmployee);
				break;
			}
			case "m":{
				employeeMenu();
				break;
			}
		}
		editEmployeeMenu(currentEmployee); //Loop in this method until ready to leave 
	}

	/**
	 * This method allows the user to change the department of an employee.
	 * It first displays all departments to the user to choose from.
	 * Then it prompts the user to select the new department number and replaces the employee's current department with the new one.
	 * 
	 * currentEmployee the employee whose department will be changed
	 */
	private static void changeDepartment(Employee currentEmployee) {
		viewAllDepartments();
		System.out.println();
		System.out.println("Please Choose Number of New Department to Replace " + currentEmployee.getDepartmentName().getDepartmentName());
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		int chosenDepartment= input.nextInt();
		currentEmployee.getDepartmentName().removeEmployee(currentEmployee);//removes current Department
		boolean isFound = false;
		
		for(Department currentDepartment: allDepartments) {
			if(chosenDepartment==currentDepartment.getdDepartmentNumber()) {
				isFound=true;
				currentEmployee.setDepartmentName(currentDepartment);
				currentDepartment.addEmployee(currentEmployee);
			}
		}
		
		if(isFound==false) {
			System.out.println("-------------------------------Edit Employee---------------------------------------------------");
			System.out.println("No Department with Numbers " + chosenDepartment + " was Found." );
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	/**
	 * Removes employee from system
	 * This method displays a list of all employees and prompts the user to choose an employee by number to remove from the system.
	 * 
	 * If the chosen employee is found in the system, the method removes the employee from their current department and from the allEmployees list.
	 * Otherwise, it displays an error message indicating that no employee was found with the chosen number.
	 */
	private static void removeEmployee() {
		System.out.println("-----------------------------------------------------------------------------------------------");
			for(Employee b: allEmployees) {
				System.out.println(b.getEmployeeNumber() + " " + b.getFirstName() + " " + b.getLastName());
			}
		System.out.println();
		System.out.println("Choose Employee by Number");
		System.out.println("-----------------------------------------------------------------------------------------------");
		int chosenEmployee = input.nextInt();
		boolean isFound = false;
		
		for(Employee currentEmployee: allEmployees) {
			if(currentEmployee.getEmployeeNumber()==chosenEmployee) {
				isFound=true;
				//the below command removes Employee from Department
				currentEmployee.getDepartmentName().removeEmployee(currentEmployee);
				//remove Employee from all Employees
				allEmployees.remove(currentEmployee);
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println(currentEmployee.getFirstName() + " " + currentEmployee.getLastName() + " Has Been Removed.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				break;
			}
		}
		if(isFound==false) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No Employee with Number " + chosenEmployee + " Was Found.");			
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
	/**
	 * Displays all Employee Information 
	 * Displays information about all employees, including their employee number, full name, department, and annual salary.
	 * The information is printed in a table format, with each employee on a separate row.
	 */
	private static void viewEmployees() {			
		System.out.println("-------------------------------Employee Information----------------------------------------------------------------------------------------");
		for(Employee b: allEmployees) {		
			b.printByLine();
		}				
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	}
	/**
	 * Displays combined salary of all Employee
	 * 
	 * Pseudo Code for adding all combined salaries in company.
	 * 
	 *  1. Set up a DecimalFormat object with a currency and formated pattern.
	 * 
	 *  2. Initialise a double variable named "totalSalary" to 0.
	 * 
	 *	3. For each employee in the Employee Object in the collection "allEmployees":
	 *		   a. Retrieve the employee's salary using the "getEmployeeSalary" method.
	 *		   b. Add all the employee's salary to the totalSalary variable
	 *
	 * 	4. Print a line in console to for a allow a cleaner UI.
	 *
	 * 	5. Using "currency.format" method print the totalSalary variable
	 * 
	 * 	6. Print a line in console to for a allow a cleaner UI.
	 */
	private static void combinedSalarys() {
		
		 DecimalFormat currency = new DecimalFormat("###,###,###.##"); //This formats the numbers into currency, It allows commas to be formatted to read the numbers easier

			double totalSalary = 0;
			    for(Employee employee : allEmployees) {
			        totalSalary += employee.getEmployeeSalary();
			    }
				System.out.println("-----------------------------------------------------------------------------------------------");
			    System.out.println("Cost of all Annual Salaries per Organization: €" + currency.format(totalSalary));
				System.out.println("-----------------------------------------------------------------------------------------------");
			}
/**
 * Displays the department menu and performs various department-related actions based on user input.
 * Options include creating, editing, removing, and viewing departments, as well as viewing total employees annual salaries by department.
 * Users can  return to the main menu.
 */
	
	private static void departmentMenu() {
		System.out.println("-------------------------------Department Menu-------------------------------------------------");
		System.out.println("Press 1 to Create New Department");
		System.out.println("Press 2 to Edit a Department");
		System.out.println("Press 3 to Remove a Department");
		System.out.println("Press 4 to View All Departments");
		System.out.println("Press 5 to View Total Employees Annual Salaries by Department");
		System.out.println("Press M to Return to Main Menu");
		System.out.println("-----------------------------------------------------------------------------------------------");

		String choice = input.next();
		choice = choice.toLowerCase();
		
		switch(choice) {
			case "1":{
				try {
					createDepartment();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was logged creating an Department.");
					System.out.println("Returning to Department Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
					}
				break;
			}
			case "2":{
				try {
					editDepartment();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was logged creating an Department.");
					System.out.println("Returning to Department Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				break;
			}
			case "3":{
				try {
					removeDepartment();
				} catch (Exception e) {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("An Error was logged creating an Department.");
					System.out.println("Returning to Department Menu ...");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				break;
			}
			case "4":{
				viewAllDepartments();
				break;
			}
			case "5":{
				employeesTotalSalaryPerDepartment();
				break;
			}
			case "m":{
					mainMenu();
					break;
				}
		}
		departmentMenu();
	}
	/**
	 * Allows the user to edit an existing department by selecting a department from the list of all departments,
	 * and then accessing the edit department menu to update the department's name and/or location.
	 * If the user inputs an invalid department number, a message is displayed and the method returns to the department menu.
	 */
	private static void editDepartment() {
		viewAllDepartments(); //Show user list of all Departments
		System.out.println();
		System.out.println("Choose Department by Number");
		System.out.println("-----------------------------------------------------------------------------------------------");
		int chosenDepartment = input.nextInt(); //capture user selection in variable chosenDepartment
		boolean isFound = false;
		
		for(Department currentDepartment: allDepartments) {
			if(chosenDepartment==currentDepartment.getdDepartmentNumber()) {
				//if the number of the current object matches user input
				isFound=true;
				//Send the object to a new method to edit
				editDepartmentMenu(currentDepartment);
			}
		}
		
		if(isFound==false) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No Department with Number " + chosenDepartment + " was Found.");
			System.out.println("Returning to Department Menu...");
		}
	}
	/**
	 * A method to edit a selected department's name.
	 */
	private static void editDepartmentMenu(Department toEdit) {
		
		try {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Please Enter New Name to Replace "
					+ toEdit.getDepartmentName());
			System.out.println("-----------------------------------------------------------------------------------------------");

			toEdit.setDepartmentName(reader.readLine());
		} catch (Exception e) {
			System.out.println("Error was Logged Editing an Department");
			System.out.println("Returning to Department Menu ...");
		}
		
	}
	/**
	 *Removes a department from the company's department list if no employees are associated with it.
	 *Displays a message if a department cannot be deleted because employees are associated with it.
	 */
	private static void removeDepartment() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		viewAllDepartments(); //Show user list of all Departments
		System.out.println();// For a gap
		System.out.println("Choose Department by Number");
		System.out.println("-----------------------------------------------------------------------------------------------");
		int chosenDepartment = input.nextInt(); //capture user selection in variable chosenDepartment
		boolean isFound = false;
		
		for(Department currentDepartment: allDepartments) {
			if(currentDepartment.getdDepartmentNumber()==chosenDepartment) {
				isFound=true;
				if(currentDepartment.getInfoEmployees().isEmpty()) {
					allDepartments.remove(currentDepartment);
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println(currentDepartment.getDepartmentName() + " has been Deleted.");
					System.out.println("-----------------------------------------------------------------------------------------------");
					break;
				}
				else {
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("Unable to Delete " + currentDepartment.getDepartmentName());
					System.out.println("Employees are Associated with this Department. Please Delete Employees First");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
				
			}
			
		}
		
	}
	/**
	 * Calculates and displays the total salary per department.
	 * It displays  all departments and for each department it adds the salary of all employees associated with that department. 
	 * The total salary per department is displayed in currency format.
	 * It uses the DecimalFormat class to format numbers into currency.
	 */
	private static void employeesTotalSalaryPerDepartment() {
		 DecimalFormat currency = new DecimalFormat("###,###,###.##"); //This formats the numbers into currency, It allows commas to be formatted to read the numbers easier
		System.out.println("-------------------------------Total Salary Per Department-------------------------------------");
		    for (Department department : allDepartments) {
		        double totalSalary = 0; // Sets totalSalary to 0
		        for (Employee employee : department.getInfoEmployees()) {
		            totalSalary += employee.getEmployeeSalary(); // Add all salary per department
		        }
		        System.out.println(department.getDepartmentName() + " Total Salary: €" + currency.format(totalSalary));
		    } 
			System.out.println("-----------------------------------------------------------------------------------------------");
		
	}
	/**
	 * This method creates a new department by asking the user for input of the department name and assigning a unique department number.
	 * It then adds the new department to the list of all departments.	 
	 * */
	private static void createDepartment() throws Exception {
		System.out.println("-----------------------------------------------------------------------------------------------");
		Department a = new Department();
		a.setDepartmentNumber(centralDepartmentNumber);
		centralDepartmentNumber++;
		System.out.println("Enter Department name");
		System.out.println("-----------------------------------------------------------------------------------------------");
		a.setDepartmentName(reader.readLine());
		allDepartments.add(a);
	}
  
	/**
	 * Displays a list of all departments and their department numbers in the system.
	 */
	private static void viewAllDepartments() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(Department a: allDepartments) {
			System.out.println(a.getdDepartmentNumber() + "\t" + a.getDepartmentName());
		}
		
	}
	/**
	 * This method pre-populates the system with default departments and employees.
	 * It creates instances of the Department and Employee classes with preset values for department number, department name, employee number, surname, first name, department and salary.
	 * It then adds employees to their corresponding departments, and adds all employees and departments to the system.
	 */
	private static void prePopulate() {
		Department sales = new Department(101,"Sales"); // presets departments number and name
		Department production = new Department(102,"Production");
		Department finance = new Department(103,"Finance");
		Department marketing = new Department(104,"Markteting");
		
				// int employeeNumber, String firstName, String firstName, Department departmentName, double employeeSalary
		Employee johnSmith = new Employee(1001,"Smith","John", sales,12345.99); // presets Employee number, surname, first name, departments and salary
		Employee roseTyler = new Employee(1002,"Tyler","Rose", production,80000);
		Employee amyPond = new Employee(1003,"Pond","Amy", finance,70000.87);
		Employee donnaNoble = new Employee(1004,"Noble","Donna",marketing,50000);
		
		sales.addEmployee(johnSmith); //adds employees into departments
		production.addEmployee(roseTyler);
		finance.addEmployee(amyPond);
		marketing.addEmployee(donnaNoble);
		
		allEmployees.add(johnSmith); //adds employees into system
		allEmployees.add(roseTyler);
		allEmployees.add(amyPond);
		allEmployees.add(donnaNoble);
		
		allDepartments.add(sales); //adds departments into system
		allDepartments.add(production);
		allDepartments.add(finance);
		allDepartments.add(marketing);
		
	}
	
}

