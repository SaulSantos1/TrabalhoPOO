import q1_SaulMarinho.Company;
import q1_SaulMarinho.Employee;
import q1_SaulMarinho.Vehicle;

public class Sistema {

	 public static void main(String[] args) {

	        Company company = new Company("Unifor");
	
	        Employee employee = new Employee("Saul Santos", company);

	        Vehicle vehicle = new Vehicle("ABC-123");

	        employee.addVehicle(vehicle);

	        System.out.println("Nome do funcionário: " + employee.getName());
	        System.out.println("Empresa do funcionário: " + employee.getCompany().getName());
	        System.out.println("Veículos do funcionário: " + vehicle.getRegistrationNumber());
	    }
}
