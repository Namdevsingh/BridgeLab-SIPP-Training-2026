import java.util.*;

public class BstSearchUsernameIterative {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static boolean search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.val) return true;
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }

    static Node insert(Node root, int x) {
        if (root == null) return new Node(x);
        if (x < root.val) root.left = insert(root.left, x);
        else if (x > root.val) root.right = insert(root.right, x);
        return root;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, input.nextInt());
        int target = input.nextInt();
        System.out.print(search(root, target));
    }
}

