public class DeletionDemo {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
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
        Node tasks = new Node(101);
        tasks.next = new Node(102);
        tasks.next.next = new Node(103);
        tasks.next.next.next = new Node(104);

        tasks = removeTask(tasks, 102);
        printList(tasks);
    }
}
