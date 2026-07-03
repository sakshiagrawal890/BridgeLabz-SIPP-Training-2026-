import java.util.ArrayList;
import java.util.List;


public class NoRawTypesDemo {

    // 5) Avoid Using Raw Types (List instead of List<T>)
    // Raw types bypass compile-time checks and can cause ClassCastException.

    public static void main(String[] args) {
        // Correct: parameterized type
        List<String> safe = new ArrayList<>();
        safe.add("hello");
        safe.add("world");

        System.out.println("Safe list: " + safe);

        // Wrong (do not do): raw type
        // List raw = new ArrayList();
        // raw.add("text");
        // raw.add(123); // compiler warning

        // Uncommenting the next block may lead to runtime ClassCastException
        // String s = (String) raw.get(1); // could fail
    }
}

