package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 876
//Find the middle node of a singly linked list,if there are two middle nodes, return the second middle node.

public class MiddleOfLinkedList {
    //node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        //print original list
        System.out.print("Linked List: ");
        printList(head);
        //method call
        ListNode mid = middleNode(head);
        //print output
        System.out.println("Middle Node Value: " + mid.val);
    }

    //method to find middle node using slow and fast pointers
    static ListNode middleNode(ListNode head) {

        ListNode fast = head;  //moves 2 steps
        ListNode slow = head;  //moves 1 step

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //method to print linked list
    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
