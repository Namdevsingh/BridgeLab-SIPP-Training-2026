import java.util.*;

public class CategoryTreeHeightThreshold {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    static Node build(Scanner input) {
        int n = input.nextInt();
        if (n <= 0) return null;
        int first = input.nextInt();
        if (first == -1) return null;
        Node root = new Node(first);

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < n; ) {
            Node cur = q.poll();

            int leftVal = input.nextInt();
            if (leftVal != -1) {
                cur.left = new Node(leftVal);
                q.offer(cur.left);
            }
            i++;
            if (i >= n) break;

            int rightVal = input.nextInt();
            if (rightVal != -1) {
                cur.right = new Node(rightVal);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Node root = build(input);
        int threshold = input.nextInt();
        System.out.print(isTooDeep(root, threshold));
    }
}

