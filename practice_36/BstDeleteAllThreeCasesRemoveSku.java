import java.util.*;

public class BstDeleteAllThreeCasesRemoveSku {

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

    static Node delete(Node node, int sku) {
        if (node == null) return null;
        if (sku < node.val) node.left = delete(node.left, sku);
        else if (sku > node.val) node.right = delete(node.right, sku);
        else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    static void inorder(Node node, List<Integer> out) {
        if (node == null) return;
        inorder(node.left, out);
        out.add(node.val);
        inorder(node.right, out);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, input.nextInt());
        int sku = input.nextInt();
        root = delete(root, sku);

        List<Integer> out = new ArrayList<>();
        inorder(root, out);
        for (int i = 0; i < out.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(out.get(i));
        }
    }
}

