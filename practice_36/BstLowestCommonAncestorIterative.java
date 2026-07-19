import java.util.*;

public class BstLowestCommonAncestorIterative {

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

    static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, input.nextInt());
        int p = input.nextInt();
        int q = input.nextInt();
        Node lca = lowestCommonAncestor(root, p, q);
        System.out.print(lca == null ? -1 : lca.val);
    }
}

