package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 83
//remove duplicates from a sorted linked list.

public class RemoveDuplicatesFromSortedList {
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
        System.out.print("Enter node values (sorted):");
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
        System.out.print("Original List: ");
        printList(head);
        //method calling
        head = deleteDuplicates(head);
        //print updated list
        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
    //method to delete duplicates
    static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next; 
            } else {
                temp = temp.next;
            }
        }

        return head;
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
