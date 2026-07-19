import java.util.*;

public class BstInorderSortedLeaderboardRecursive {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    static List<Integer> getSortedLeaderboard(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    static Node insert(Node root, int x) {
        if (root == null) return new Node(x);
        if (x < root.val) root.left = insert(root.left, x);
        else root.right = insert(root.right, x);
        return root;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, input.nextInt());
        List<Integer> res = getSortedLeaderboard(root);
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
    }
}

