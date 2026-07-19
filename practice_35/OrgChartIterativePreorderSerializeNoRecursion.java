import java.util.*;

public class OrgChartIterativePreorderSerializeNoRecursion {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }

    static Node buildByLevelOrder(Scanner input, int n) {
        if (n <= 0) return null;
        Node root = null;
        Integer[] vals = new Integer[n];
        for (int i = 0; i < n; i++) vals[i] = input.nextInt();
        if (vals[0] == null) return null;
        root = new Node(vals[0]);

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < n) {
            Node cur = q.poll();

            if (i < n && vals[i] != null) {
                cur.left = new Node(vals[i]);
                q.offer(cur.left);
            }
            i++;

            if (i < n && vals[i] != null) {
                cur.right = new Node(vals[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node root = null;
        List<Integer> order;

        if (n <= 0) {
            System.out.print("");
            return;
        }

        Integer[] vals = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            vals[i] = x;
        }
        if (vals[0] == null) {
            System.out.print("");
            return;
        }

        root = new Node(vals[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < n) {
            Node cur = q.poll();

            if (i < n) {
                int x = vals[i];
                if (x != -1) {
                    cur.left = new Node(x);
                    q.offer(cur.left);
                }
                i++;
            }

            if (i < n) {
                int x = vals[i];
                if (x != -1) {
                    cur.right = new Node(x);
                    q.offer(cur.right);
                }
                i++;
            }
        }

        order = iterativePreorder(root);
        for (int j = 0; j < order.size(); j++) {
            if (j > 0) System.out.print(" ");
            System.out.print(order.get(j));
        }
    }
}

