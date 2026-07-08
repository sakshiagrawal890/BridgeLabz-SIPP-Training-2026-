package interfaces;

public interface Trackable {
    void logActivity(String activity);
    default void resetData() {
        System.out.println("Data reset.");
    }
}
