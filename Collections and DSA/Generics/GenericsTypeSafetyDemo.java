import java.util.ArrayList;
import java.util.List;


public class GenericsTypeSafetyDemo {

    // 1) Use Generics to Ensure Type Safety
    // Prevents ClassCastException by enforcing element type at compile time.
    public static void addNumbers(List<Integer> target, Integer value) {
        target.add(value);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        addNumbers(numbers, 10);
        addNumbers(numbers, 20);

        System.out.println("Numbers: " + numbers);

        // Uncommenting the next lines would fail at compile time:
        // List<Integer> wrong = new ArrayList<>();
        // addNumbers(wrong, (Integer) (Object) "hello"); // type mismatch
    }
}

