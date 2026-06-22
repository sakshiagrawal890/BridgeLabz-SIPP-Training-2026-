import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        String fileName = "employee.ser";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter employee id: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(employeeId, name, department, salary);

            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
                output.writeObject(employee);
                System.out.println("Employee object serialized");
            } catch (IOException e) {
                System.out.println("Error serializing employee object");
            }

            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
                Employee recoveredEmployee = (Employee) input.readObject();

                System.out.println("Recovered employee information:");
                recoveredEmployee.display();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error recovering employee object");
            }
        }
    }
}
