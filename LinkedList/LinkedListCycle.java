import java.util.Scanner;

public class LinkedListCycle {

    // Node of Linked List
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Floyd's Cycle Detection Algorithm
    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

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

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Cycle: false");
            sc.close();
            return;
        }

        // Create nodes
        ListNode[] nodes = new ListNode[n];

        System.out.print("Enter node values:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            nodes[i] = new ListNode(value);
        }

        // Connect nodes normally
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Enter position where tail should connect
        System.out.print("Enter pos (-1 for no cycle): ");
        int pos = sc.nextInt();

        // Create cycle
        if (pos >= 0 && pos < n) {
            nodes[n - 1].next = nodes[pos];
        }

        // Check cycle
        boolean result = hasCycle(nodes[0]);

        System.out.println("Cycle: " + result);

        sc.close();
    }
}
