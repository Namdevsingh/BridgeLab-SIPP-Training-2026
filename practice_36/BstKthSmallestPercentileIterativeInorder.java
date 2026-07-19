import java.util.*;

public class BstKthSmallestPercentileIterativeInorder {

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

    static int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, input.nextInt());
        int k = input.nextInt();
        System.out.print(kthSmallest(root, k));
    }
}

