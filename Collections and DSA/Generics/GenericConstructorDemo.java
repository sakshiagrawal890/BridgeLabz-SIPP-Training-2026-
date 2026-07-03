import java.util.List;


public class GenericConstructorDemo {

    // 10) Use Generic Constructors Where Necessary
    static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        // Generic constructor (type inference friendly)
        public static <X> Pair<X, X> ofSame(List<X> values) {
            if (values == null || values.size() < 2) {
                throw new IllegalArgumentException("Need at least 2 items");
            }
            return new Pair<>(values.get(0), values.get(1));
        }

        @Override
        public String toString() {
            return "Pair{" + first + ", " + second + '}';
        }
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> p = Pair.ofSame(List.of(10, 20, 30));
        System.out.println(p);
    }
}

