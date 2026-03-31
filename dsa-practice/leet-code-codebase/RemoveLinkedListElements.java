package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 203
//Remove all nodes from the linked list that have value = val.
public class RemoveLinkedListElements {
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
        //value to remove
        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();
        //print original list
        System.out.print("Original List: ");
        printList(head);
        //method calling
        head = removeElements(head, val);
        //print updated list
        System.out.print("Updated List: ");
        printList(head);
    }

    //method to remove nodes with given value
    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        //dummy node 
        ListNode prev = new ListNode(-1);
        ListNode start = prev;
        //connect dummy to head
        prev.next = head;
        while (curr != null) {
            if (curr.val == val) {
                //remove current node
                prev.next = curr.next;
                curr = curr.next;
            } else {
                //move forward 
                prev = curr;
                curr = curr.next;
            }
        }

        return start.next;
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
