import java.util.*;

public class LinkedListRemoveTaskById {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static Node removeTask(Node head, int taskId) {
        if (head == null) return null;
        if (head.val == taskId) return head.next;

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) prev.next = curr.next;
        return head;
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
        int taskId = input.nextInt();

        Node head = buildList(arr);
        head = removeTask(head, taskId);
        printList(head);
    }
}

