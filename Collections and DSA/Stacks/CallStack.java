public class CallStack {
    private static class Frame {
        String functionName;
        Frame next;

        Frame(String name, Frame next) {
            this.functionName = name;
            this.next = next;
        }
    }

    private Frame top = null;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to return from");
        }
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to inspect");
        }
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
