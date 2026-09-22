import java.util.Scanner;

public class MiddleLL {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to find middle node
    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Slow moves 1 step, fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("List must contain at least one node.");
            sc.close();
            return;
        }

        // Create linked list
        System.out.print("Enter " + n + " elements:");

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle
        ListNode middle = middleNode(head);

        // Print result
        System.out.println("Middle node: " + middle.val);

        // Print list starting from middle
        System.out.print("List from middle: ");

        while (middle != null) {
            System.out.print(middle.val);

            if (middle.next != null) {
                System.out.print(" -> ");
            }

            middle = middle.next;
        }

        System.out.println(" -> null");

        sc.close();
    }
}