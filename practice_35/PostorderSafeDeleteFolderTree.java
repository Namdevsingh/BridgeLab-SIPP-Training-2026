import java.util.*;

public class PostorderSafeDeleteFolderTree {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void deleteFolderTree(Node node, List<Integer> output) {
        if (node == null) return;
        deleteFolderTree(node.left, output);
        deleteFolderTree(node.right, output);
        output.add(node.val);
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
        List<Integer> out = new ArrayList<>();
        deleteFolderTree(root, out);
        for (int i = 0; i < out.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(out.get(i));
        }
    }
}

