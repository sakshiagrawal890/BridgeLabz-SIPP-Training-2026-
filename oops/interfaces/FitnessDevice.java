package interfaces;

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    private java.util.List<String> activities = new java.util.ArrayList<>();

    @Override
    public void logActivity(String activity) {
        activities.add(activity);
        System.out.println("Logged activity: " + activity);
    }

    @Override
    public void generateReport() {
        System.out.println("--- Fitness Report ---");
        if (activities.isEmpty()) {
            System.out.println("No activities recorded.");
        } else {
            activities.forEach(a -> System.out.println("* " + a));
        }
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("[ALERT] " + message);
    }

    // Demonstrates that a class can implement multiple interfaces
    // but cannot extend multiple classes (see comment below).
    // public class Demo extends ClassA, ClassB {} // illegal in Java
}
