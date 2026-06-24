class Student {
    String name;
    int rollNumber;
    double marks;

    // Constructor
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method tdisplay student details
    void displayDetails() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("", 101, 89.5);
        student.displayDetails();  // Output: Name: Alice, Roll Number: 101, Marks: 89.5
    }
}
