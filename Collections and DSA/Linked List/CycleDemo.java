public class CycleDemo {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node cycleHead = new Node(1);
        Node cycleSecond = new Node(2);
        Node cycleThird = new Node(3);
        cycleHead.next = cycleSecond;
        cycleSecond.next = cycleThird;
        cycleThird.next = cycleSecond;

        System.out.println("Contains cycle: " + hasRedirectLoop(cycleHead));
    }
}
