import java.util.Arrays;
import java.util.List;


public class GenericMethodOverloadingDemo {

    // 2) Prefer Generic Methods Over Overloading
    // One method can work for any Comparable type.
    public static <T extends Comparable<? super T>> T maxOf(List<T> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("values must not be null/empty");
        }
        T best = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            T cur = values.get(i);
            if (cur.compareTo(best) > 0) {
                best = cur;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(3, 9, 1, 7);
        List<String> strings = Arrays.asList("apple", "pear", "banana");

        System.out.println("Max int: " + maxOf(ints));
        System.out.println("Max string: " + maxOf(strings));
    }
}

