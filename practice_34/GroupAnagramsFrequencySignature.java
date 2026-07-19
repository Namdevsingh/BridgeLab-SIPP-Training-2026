import java.util.*;

public class GroupAnagramsFrequencySignature {

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) strs[i] = input.next();

        List<List<String>> grouped = groupAnagrams(strs);
        for (int i = 0; i < grouped.size(); i++) {
            List<String> g = grouped.get(i);
            for (int j = 0; j < g.size(); j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(g.get(j));
            }
            if (i < grouped.size() - 1) System.out.println();
        }
    }
}

