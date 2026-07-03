import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class GenericInterfaceAndStreamsDemo {

    // 7) Favor Generic Interfaces for Common Behaviors
    interface Transformer<T, R> {
        R transform(T input);
    }

    // 9) Combine Generics with Functional Interfaces and Streams
    static class SquareTransformer implements Transformer<Integer, Integer> {
        @Override public Integer transform(Integer input) { return input * input; }
    }

    static class MultiplyTransformer implements Transformer<Integer, Integer> {
        private final int factor;
        MultiplyTransformer(int factor) { this.factor = factor; }
        @Override public Integer transform(Integer input) { return input * factor; }
    }

    // Avoid wildcard in return types (8)
    public static <T, R> List<R> map(List<T> input, Transformer<T, R> transformer) {
        // Using a loop keeps the demo simple (no extra imports); streams can be added similarly.
        List<R> out = new ArrayList<>();
        for (T t : input) {
            out.add(transformer.transform(t));
        }
        return out;
    }

    // Demonstrate use with a lambda as well
    public static <T, R> List<R> mapFn(List<T> input, Function<T, R> fn) {
        List<R> out = new ArrayList<>();
        for (T t : input) {
            out.add(fn.apply(t));
        }
        return out;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);

        List<Integer> squares = map(nums, new SquareTransformer());
        System.out.println("Squares: " + squares);

        List<Integer> times10 = map(nums, new MultiplyTransformer(10));
        System.out.println("Times10: " + times10);

        List<String> asStrings = mapFn(nums, n -> "n=" + n);
        System.out.println("As strings: " + asStrings);
    }
}

