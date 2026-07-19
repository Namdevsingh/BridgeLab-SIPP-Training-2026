import java.util.*;

public class BstValidateCorruptionBounds {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node root, int x) {
        if (root == null) return new Node(x);
        if (x < root.val) root.left = insert(root.left, x);
        else if (x > root.val) root.right = insert(root.right, x);
        return root;
    }

    static Node build(Scanner input) {
        int n = input.nextInt();
        if (n <= 0) return null;
        int idx = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] != Integer.MIN_VALUE) nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null) continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n) nodes[i].left = nodes[left];
            if (right < n) nodes[i].right = nodes[right];
        }
        return nodes[0];
    }

    static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n <= 0) {
            System.out.print(true);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] != Integer.MIN_VALUE) nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null) continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n) nodes[i].left = nodes[left];
            if (right < n) nodes[i].right = nodes[right];
        }

        System.out.print(isValidBST(nodes[0]));
    }
}

