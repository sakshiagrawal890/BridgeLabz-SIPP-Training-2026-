import java.util.ArrayList;
import java.util.List;


public class MinimizeWildcardUsageDemo {

    static class Box<T> {
        private T value;
        Box(T value) { this.value = value; }
        public T get() { return value; }
        public void set(T value) { this.value = value; }
    }

    // 8) Minimize Wildcard Usage in Public APIs
    // Return type does NOT use wildcards; it stays type-stable for callers.
    public static <T> T first(Box<T> box) {
        return box.get();
    }

    // Wildcards are used only where it helps (read-only).
    public static <T> int sizeOf(List<? extends T> items) {
        return items.size();
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(42);
        System.out.println("First: " + first(intBox));

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        System.out.println("Size: " + sizeOf(nums));
    }
}

