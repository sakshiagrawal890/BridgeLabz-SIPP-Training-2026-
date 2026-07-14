public class LinkedListScenarios {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static void insertAfter(Node current, int trackId) {
        if (current == null) {
            return;
        }

        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }

        if (head.val == taskId) {
            return head.next;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node playlist = new Node(10);
        playlist.next = new Node(20);
        playlist.next.next = new Node(30);
        insertAfter(playlist.next, 25);
        System.out.println("Scenario 1 - Playlist queue:");
        printList(playlist);

        Node tasks = new Node(101);
        tasks.next = new Node(102);
        tasks.next.next = new Node(103);
        tasks.next.next.next = new Node(104);
        tasks = removeTask(tasks, 102);
        System.out.println("Scenario 2 - Task queue after removal:");
        printList(tasks);

        Node history = new Node(1);
        history.next = new Node(2);
        history.next.next = new Node(3);
        history = reverseHistory(history);
        System.out.println("Scenario 3 - Reversed history:");
        printList(history);

        Node servers = new Node(1);
        servers.next = new Node(2);
        servers.next.next = new Node(3);
        servers.next.next.next = new Node(4);
        servers.next.next.next.next = new Node(5);
        Node middle = findMiddleServer(servers);
        System.out.println("Scenario 4 - Middle server value: " + middle.val);

        Node cycleHead = new Node(1);
        Node cycleSecond = new Node(2);
        Node cycleThird = new Node(3);
        cycleHead.next = cycleSecond;
        cycleSecond.next = cycleThird;
        cycleThird.next = cycleSecond;
        System.out.println("Scenario 5 - Contains cycle: " + hasRedirectLoop(cycleHead));
    }
}
