import java.util.*;

public class LinkedListInsertAfterNodeTrackQueue {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insertAfter(Node current, int trackId) {
        if (current == null) return null;
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
        return current;
    }

    static Node buildList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    static void printList(Node head) {
        Node cur = head;
        boolean first = true;
        while (cur != null) {
            if (!first) System.out.print(" ");
            System.out.print(cur.val);
            first = false;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        int currentIndex = input.nextInt();
        int trackId = input.nextInt();

        Node head = buildList(arr);
        Node cur = head;
        for (int i = 0; i < currentIndex && cur != null; i++) cur = cur.next;

        insertAfter(cur, trackId);
        printList(head);
    }
}

