public class MiddleDemo {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node servers = new Node(1);
        servers.next = new Node(2);
        servers.next.next = new Node(3);
        servers.next.next.next = new Node(4);
        servers.next.next.next.next = new Node(5);

        Node middle = findMiddleServer(servers);
        System.out.println("Middle server value: " + middle.val);
    }
}
