public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== University System ===");
        GradStudent gradStudent = new GradStudent("Aman", 24, "S12345", 3.9, "AI in Healthcare");
        System.out.println(gradStudent);
        System.out.println("Is-a checks: GradStudent instanceof Student = " + (gradStudent instanceof Student));
        System.out.println("Is-a checks: GradStudent instanceof Person = " + (gradStudent instanceof Person));

        System.out.println("\n=== Library Management ===");
        Author author = new Author("Java Patterns", 2024, "Sneha Rao", "Software engineer and author.");
        author.displayInfo();

        System.out.println("\n=== Order Management ===");
        Order order = new Order("ORD001", "2026-06-24");
        ShippedOrder shippedOrder = new ShippedOrder("ORD002", "2026-06-22", "TRACK123");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", "2026-06-20", "TRACK789", "2026-06-23");
        System.out.println(order);
        System.out.println(shippedOrder);
        System.out.println(deliveredOrder);

        System.out.println("\n=== Vehicle Management ===");
        ElectricVehicle electricVehicle = new ElectricVehicle("Model E", 180, 75);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Model P", 200, 55);
        System.out.println(electricVehicle);
        electricVehicle.charge();
        System.out.println(petrolVehicle);
        petrolVehicle.refuel();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    private final String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + ", studentId='" + studentId + "', gpa=" + gpa + "}";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return "GradStudent{" + super.toString() + ", thesis='" + thesis + "'}";
    }
}

class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Details:");
        System.out.println("  Title: " + title);
        System.out.println("  Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Details:");
        System.out.println("  Name: " + name);
        System.out.println("  Bio: " + bio);
    }
}

class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', orderDate='" + orderDate + "', status='" + getOrderStatus() + "'}";
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public String toString() {
        return "ShippedOrder{" + super.toString() + ", trackingNumber='" + trackingNumber + "'}";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public String toString() {
        return "DeliveredOrder{" + super.toString() + ", deliveryDate='" + deliveryDate + "'}";
    }
}

interface Refuelable {
    void refuel();
}

class Vehicle {
    private String model;
    private int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle{model='" + model + "', maxSpeed=" + maxSpeed + "}";
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging " + getClass().getSimpleName() + " with " + batteryCapacity + " kWh battery.");
    }

    @Override
    public String toString() {
        return "ElectricVehicle{" + super.toString() + ", batteryCapacity=" + batteryCapacity + "}";
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + getClass().getSimpleName() + " with " + fuelCapacity + " liters.");
    }

    @Override
    public String toString() {
        return "PetrolVehicle{" + super.toString() + ", fuelCapacity=" + fuelCapacity + "}";
    }
}
