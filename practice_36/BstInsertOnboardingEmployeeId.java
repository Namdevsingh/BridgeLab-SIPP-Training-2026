import java.util.*;

public class BstInsertOnboardingEmployeeId {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node node, int id) {
        if (node == null) return new Node(id);
        if (id < node.val) node.left = insert(node.left, id);
        else if (id > node.val) node.right = insert(node.right, id);
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
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            root = insert(root, x);
        }
        int id = input.nextInt();
        root = insert(root, id);

        List<Integer> out = new ArrayList<>();
        inorder(root, out);
        for (int i = 0; i < out.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(out.get(i));
        }
    }
}

