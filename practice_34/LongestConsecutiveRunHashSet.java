import java.util.*;

public class LongestConsecutiveRunHashSet {

    static int longestConsecutiveRun(int[] ids) {
        Set<Integer> idSet = new HashSet<>();
        for (int id : ids) idSet.add(id);

        int longest = 0;
        for (int id : idSet) {
            if (!idSet.contains(id - 1)) {
                int length = 1;
                int current = id;
                while (idSet.contains(current + 1)) {
                    current++;
                    length++;
                }
                if (length > longest) longest = length;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = input.nextInt();
        System.out.print(longestConsecutiveRun(ids));
    }
}

