import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleClassesTesters {
	public static void main(String[] args) {
		Persons person1 = new Persons ("Person One", new Date()); //dob = current date and time; 
		System.out.println ("(Testing getDob()) " + person1.getDob());
		System.out.println (person1);
		
		Students student1 = new Students ("Student One", new Date(), "123456"); 
		System.out.println (student1);
		
		GraduateStudents grad1 = new GraduateStudents("Grad One", new Date(), "123457"); 
		grad1.setThesisSupervisor("Supervisor One");
		System.out.println ("(Testing getSupervisor()) " + grad1.getThesisSupervisor());
		System.out.println (grad1);
		
		//Employee employee = new Employee(); //this should be impossible 
		Employees employeeS = new SalariedEmployees("Employee Salaried", new Date(), "987");
		((SalariedEmployees) employeeS).setSalary(100000);
		System.out.println (employeeS);

		Employees employeeH = new HourlyEmployees("Employee Hourly", new Date(), "988"); 
		//employeeH.setHourlyRate(65.0); //this should be impossible 
		System.out.println (employeeH);
		
		List <Persons> list = new ArrayList<>();
		list.add(person1);
		list.add(student1);
		list.add(grad1);
		list.add(employeeS);
		list.add(employeeH);
		System.out.println ("List printing: polymorphism");
		System.out.println (list);
	}
}
