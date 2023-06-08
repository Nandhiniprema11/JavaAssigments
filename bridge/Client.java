package bridge;

//Client code
public class Client {
	public static void main(String[] args) {
		Employee regularEmployee = new RegularEmployee("Shiva", 30, 5000);
		EmployeeDetails regularEmployeeDetails = new RegularEmployeeDetails(regularEmployee);
		regularEmployeeDetails.displayDetails();

		Employee contractEmployee = new ContractEmployee("Priya", 25, 100, 40);
		EmployeeDetails contractEmployeeDetails = new ContractEmployeeDetails(contractEmployee);
		contractEmployeeDetails.displayDetails();
	}
}

/*

In this example, EmployeeDetails is the Abstraction interface, which defines the interface for 
displaying the details of an employee. RegularEmployeeDetails and ContractEmployeeDetails are the 
Refined Abstraction classes, which provide different ways of displaying the details of a regular employee 
and a contract employee, respectively. 
Employee is the Implementor interface, which defines the interface for accessing the attributes of an employee. `

*/