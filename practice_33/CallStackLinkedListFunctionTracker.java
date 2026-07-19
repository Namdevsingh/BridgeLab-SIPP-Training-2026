import java.util.*;

public class CallStackLinkedListFunctionTracker {

    static class CallStack {
        private static class Frame {
            String functionName;
            Frame next;

            Frame(String name, Frame next) {
                this.functionName = name;
                this.next = next;
            }
        }

        private Frame top = null;

        void push(String functionName) {
            top = new Frame(functionName, top);
        }

        String pop() {
            if (isEmpty()) throw new RuntimeException("No active call to return from");
            String name = top.functionName;
            top = top.next;
            return name;
        }

        String peek() {
            if (isEmpty()) return null;
            return top.functionName;
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        CallStack cs = new CallStack();
        for (int i = 0; i < q; i++) {
            String op = input.next();
            if (op.equals("push")) {
                cs.push(input.next());
                System.out.print("ok");
            } else if (op.equals("pop")) {
                if (cs.isEmpty()) System.out.print("null");
                else System.out.print(cs.pop());
            } else if (op.equals("peek")) {
                System.out.print(cs.peek());
            }
            if (i < q - 1) System.out.print("\n");
        }
    }
}

