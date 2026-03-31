package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 21
//Merge two sorted linked lists and return the merged sorted list.

public class MergeTwoSortedLists {
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
        System.out.print("Enter number of nodes in List 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter List 1 values in sorted order:");
        ListNode list1 = createList(sc, n1);
        System.out.print("Enter number of nodes in List 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter List 2 values in sorted order:");
        ListNode list2 = createList(sc, n2);

        //print both lists
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);
        //method calling
        ListNode merged = mergeTwoLists(list1, list2);
        //print output
        System.out.print("Merged List: ");
        printList(merged);
    }

    //method to merge two sorted lists (recursive)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
        	return list2;
        return list1;
    }

    //method to create linked list
    public static ListNode createList(Scanner sc, int n) {
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
        return head;
    }

    //method to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
