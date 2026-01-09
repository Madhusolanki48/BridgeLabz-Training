package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 206
//Reverse a singly linked list.

public class ReverseLinkedList {
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
        //before reverse
        System.out.print("Original List: ");
        printList(head);
        //method call
        head = reverseList(head);
        //after reverse
        System.out.print("Reversed List: ");
        printList(head);
    }

    //method to reverse linked list
    static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;  //store next node
            curr.next = prev;           //reverse link
            prev = curr;                //move previous
            curr = next;                //move current
        }

        return prev;
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
