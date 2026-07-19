import java.util.*;

public class BroadcastByLevelBfsListOfLevels {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<List<Integer>> broadcastByLevel(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
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
        List<List<Integer>> res = broadcastByLevel(root);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> level = res.get(i);
            for (int j = 0; j < level.size(); j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(level.get(j));
            }
            if (i < res.size() - 1) System.out.println();
        }
    }
}

