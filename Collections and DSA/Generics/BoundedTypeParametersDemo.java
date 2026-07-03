import java.util.ArrayList;
import java.util.List;


public class BoundedTypeParametersDemo {

    // 6) Use Bounded Type Parameters for Restriction (<T extends SomeClass>)
    public static <T extends Number> double sumAsDouble(List<T> nums) {
        double sum = 0;
        for (T n : nums) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.5);

        System.out.println("Sum ints: " + sumAsDouble(ints));
        System.out.println("Sum doubles: " + sumAsDouble(doubles));

        // Uncommenting the next lines will fail compile time:
        // List<String> bad = List.of("a", "b");
        // sumAsDouble(bad);
    }
}

