package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 237
// Delete a node (not tail) from a linked list when only that node is given.
public class DeleteNodeInLinkedList {
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

        //input index of node to delete (not last node)
        System.out.print("Enter index of node to delete (0-based): ");
        int index = sc.nextInt();
        //find node at index
        ListNode nodeToDelete = head;
        for (int i = 0; i < index; i++) {
            nodeToDelete = nodeToDelete.next;
        }
        //print original list
        System.out.print("Original List: ");
        printList(head);

        //method calling
        deleteNode(nodeToDelete);

        //print updated list
        System.out.print("After Deletion: ");
        printList(head);
    }
    //method to delete a node (shift values to left)
    static void deleteNode(ListNode node) {

        if (node.next == null) {
            return; // not possible if tail
        }

        ListNode current = node;
        ListNode prev = null;

        while (current.next != null) {
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }

        prev.next = null;
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
