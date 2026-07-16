import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidConfig {
    private static final Map<Character, Character> MATCHING_OPEN = createMatchingOpenMap();

    private static Map<Character, Character> createMatchingOpenMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        return map;
    }

    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (MATCHING_OPEN.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != MATCHING_OPEN.get(c)) {
                    return false;
                }
            } else {
                // If the parser only expects bracket characters, invalid content is rejected.
                return false;
            }
        }
        return stack.isEmpty();
    }
}
