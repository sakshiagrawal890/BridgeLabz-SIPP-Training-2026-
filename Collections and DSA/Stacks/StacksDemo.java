import java.util.Arrays;

public class StacksDemo {
    public static void main(String[] args) {
        demoUndoBuffer();
        demoCallStack();
        demoValidConfig();
        demoNextBusierDay();
        demoLoadSpan();
    }

    private static void demoUndoBuffer() {
        System.out.println("--- UndoBuffer Demo ---");
        UndoBuffer undoBuffer = new UndoBuffer(3);
        System.out.println(undoBuffer.push("Edit1") + " -> pushed Edit1");
        System.out.println(undoBuffer.push("Edit2") + " -> pushed Edit2");
        System.out.println(undoBuffer.push("Edit3") + " -> pushed Edit3");
        System.out.println(undoBuffer.push("Edit4") + " -> rejected Edit4");
        System.out.println("peek: " + undoBuffer.peek());
        System.out.println("pop: " + undoBuffer.pop());
        System.out.println("pop: " + undoBuffer.pop());
        System.out.println();
    }

    private static void demoCallStack() {
        System.out.println("--- CallStack Demo ---");
        CallStack callStack = new CallStack();
        callStack.push("main");
        callStack.push("processData");
        callStack.push("computeMetrics");
        System.out.println("current: " + callStack.peek());
        System.out.println("returning from: " + callStack.pop());
        System.out.println("current after pop: " + callStack.peek());
        System.out.println();
    }

    private static void demoValidConfig() {
        System.out.println("--- ValidConfig Demo ---");
        String[] examples = {"()[]{}", "([{}])", "([)]", "{[}", ""};
        for (String example : examples) {
            System.out.printf("%s -> %b%n", example, ValidConfig.isValidConfig(example));
        }
        System.out.println();
    }

    private static void demoNextBusierDay() {
        System.out.println("--- NextBusierDay Demo ---");
        int[] visitors = {10, 13, 12, 14, 9, 15, 11};
        int[] next = NextBusierDay.nextBusierDay(visitors);
        System.out.println("visitors: " + Arrays.toString(visitors));
        System.out.println("next indexes: " + Arrays.toString(next));
        System.out.println();
    }

    private static void demoLoadSpan() {
        System.out.println("--- LoadSpan Demo ---");
        int[] load = {10, 4, 5, 90, 120, 80, 90};
        int[] span = LoadSpan.loadSpan(load);
        System.out.println("load: " + Arrays.toString(load));
        System.out.println("span: " + Arrays.toString(span));
        System.out.println();
    }
}
