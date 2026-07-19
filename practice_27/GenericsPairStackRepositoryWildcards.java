import java.util.*;

public class GenericsPairStackRepositoryWildcards {

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        T getFirst() {
            return first;
        }

        U getSecond() {
            return second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static class GenericStack<T> {
        private ArrayList<T> data = new ArrayList<>();

        void push(T item) {
            data.add(item);
        }

        T pop() {
            if (data.isEmpty()) return null;
            return data.remove(data.size() - 1);
        }

        T peek() {
            if (data.isEmpty()) return null;
            return data.get(data.size() - 1);
        }

        boolean isEmpty() {
            return data.isEmpty();
        }

        int size() {
            return data.size();
        }

        public String toString() {
            return data.toString();
        }
    }

    static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) max = arr[i];
        }
        return max;
    }

    static class Repository<T> {
        private ArrayList<T> items = new ArrayList<>();

        void add(T item) {
            items.add(item);
        }

        T get(int index) {
            return items.get(index);
        }

        int size() {
            return items.size();
        }

        List<T> getAll() {
            return items;
        }
    }

    static void printAll(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("Age", 21);
        System.out.println(p);

        GenericStack<Integer> st = new GenericStack<>();
        st.push(10);
        st.push(20);
        st.push(15);
        System.out.println("Stack peek: " + st.peek());
        System.out.println("Stack pop: " + st.pop());
        System.out.println("Stack after pop: " + st);

        Integer[] nums = {3, 8, 2, 9, 5};
        System.out.println("Max: " + findMax(nums));

        Repository<String> repo = new Repository<>();
        repo.add("A");
        repo.add("B");
        repo.add("C");
        System.out.println("Repo size: " + repo.size());
        printAll(repo.getAll());
    }
}

