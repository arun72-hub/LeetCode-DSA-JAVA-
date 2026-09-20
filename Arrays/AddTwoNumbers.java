import java.util.Scanner;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class AddTwoNumbers {

    // Add two linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }

    // Create linked list from user input
    public static ListNode createList(Scanner sc) {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.print("Enter elements:");

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

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First List");
        ListNode l1 = createList(sc);

        System.out.println("\nEnter Second List");
        ListNode l2 = createList(sc);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("\nFirst List:");
        printList(l1);

        System.out.println("Second List:");
        printList(l2);

        System.out.println("Sum:");
        printList(result);

        sc.close();
    }
}

//LeetCode Add Two Numbers ke logic par hai. Us problem mein list ko reverse digits maana jata hai

// Daily life addition is here
// import java.util.Scanner;

// class ListNode {

//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }

// public class AddTwoNumbers {

//     // Create linked list from user input
//     public static ListNode createList(Scanner sc) {

//         System.out.print("Enter number of elements: ");
//         int n = sc.nextInt();

//         ListNode head = null;
//         ListNode tail = null;

//         System.out.println("Enter elements:");

//         for (int i = 0; i < n; i++) {

//             int value = sc.nextInt();

//             ListNode newNode = new ListNode(value);

//             if (head == null) {
//                 head = newNode;
//                 tail = newNode;
//             } else {
//                 tail.next = newNode;
//                 tail = newNode;
//             }
//         }

//         return head;
//     }

//     // Normal left-to-right addition
//     public static ListNode addLists(ListNode l1, ListNode l2) {

//         // Convert first list to number
//         long num1 = 0;

//         while (l1 != null) {
//             num1 = num1 * 10 + l1.val;
//             l1 = l1.next;
//         }

//         // Convert second list to number
//         long num2 = 0;

//         while (l2 != null) {
//             num2 = num2 * 10 + l2.val;
//             l2 = l2.next;
//         }

//         // Add both numbers
//         long sum = num1 + num2;

//         // Convert sum back to linked list
//         String result = String.valueOf(sum);

//         ListNode head = null;
//         ListNode tail = null;

//         for (int i = 0; i < result.length(); i++) {

//             int digit = result.charAt(i) - '0';

//             ListNode newNode = new ListNode(digit);

//             if (head == null) {
//                 head = newNode;
//                 tail = newNode;
//             } else {
//                 tail.next = newNode;
//                 tail = newNode;
//             }
//         }

//         return head;
//     }

//     // Print linked list
//     public static void printList(ListNode head) {

//         while (head != null) {

//             System.out.print(head.val);

//             if (head.next != null) {
//                 System.out.print(" -> ");
//             }

//             head = head.next;
//         }

//         System.out.println();
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter First List:");
//         ListNode l1 = createList(sc);

//         System.out.println("\nEnter Second List:");
//         ListNode l2 = createList(sc);

//         ListNode result = addLists(l1, l2);

//         System.out.println("\nFirst List:");
//         printList(l1);

//         System.out.println("Second List:");
//         printList(l2);

//         System.out.println("Sum:");
//         printList(result);

//         sc.close();
//     }
// }