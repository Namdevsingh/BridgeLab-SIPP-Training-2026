import java.util.*;

public class GenerateAllSubsetsRecursive {
    static void generate(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        generate(arr, index + 1, current);
        current.add(arr[index]);
        generate(arr, index + 1, current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        generate(arr, 0, new ArrayList<Integer>());
    }
}

