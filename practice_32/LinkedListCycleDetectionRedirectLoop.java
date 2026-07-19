import java.util.*;

public class LinkedListCycleDetectionRedirectLoop {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    static Node buildListWithCycle(int[] arr, int pos) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node tail = head;
        Node cycleNode = (pos == 0) ? head : null;

        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
            if (i == pos) cycleNode = tail;
        }

        if (pos >= 0 && cycleNode != null) tail.next = cycleNode;
        return head;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        int pos = input.nextInt();

        Node head = buildListWithCycle(arr, pos);
        System.out.print(hasRedirectLoop(head));
    }
}

