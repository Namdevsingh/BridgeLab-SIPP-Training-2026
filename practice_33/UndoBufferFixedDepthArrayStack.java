import java.util.*;

public class UndoBufferFixedDepthArrayStack {

    static class UndoBuffer {
        private String[] data;
        private int top;

        UndoBuffer(int maxDepth) {
            data = new String[maxDepth];
            top = -1;
        }

        boolean push(String edit) {
            if (top == data.length - 1) return false;
            data[++top] = edit;
            return true;
        }

        String pop() {
            if (isEmpty()) throw new RuntimeException("Nothing to undo");
            return data[top--];
        }

        String peek() {
            if (isEmpty()) return null;
            return data[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxDepth = input.nextInt();
        int q = input.nextInt();

        UndoBuffer ub = new UndoBuffer(maxDepth);
        for (int i = 0; i < q; i++) {
            String op = input.next();
            if (op.equals("push")) {
                String edit = input.next();
                System.out.print(ub.push(edit) ? "true" : "false");
            } else if (op.equals("pop")) {
                if (ub.isEmpty()) System.out.print("null");
                else System.out.print(ub.pop());
            } else if (op.equals("peek")) {
                System.out.print(ub.peek());
            }
            if (i < q - 1) System.out.print("\n");
        }
    }
}

