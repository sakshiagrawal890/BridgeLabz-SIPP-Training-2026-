import java.util.Arrays;
import java.util.List;


public class GenericNoOverloadingDemo {

    // Extra demo for concept: one method handles many types.
    // Generic bounds keep it safe.
    public static <T extends Number> double average(List<T> nums) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("nums must not be null/empty");
        }
        double sum = 0;
        for (T n : nums) {
            sum += n.doubleValue();
        }
        return sum / nums.size();
    }

    public static void main(String[] args) {
        System.out.println("Avg ints: " + average(Arrays.asList(1, 2, 3, 4)));
        System.out.println("Avg doubles: " + average(Arrays.asList(1.5, 2.5, 3.5)));
    }
}

