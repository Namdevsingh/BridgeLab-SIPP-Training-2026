import java.util.*;

public class EmployeeSkillTeamsSumToTargetRecursive {
    static void findTeams(int[] skills, int index, int target, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (index >= skills.length) return;
        if (target < 0) return;

        findTeams(skills, index + 1, target, current);

        current.add(skills[index]);
        findTeams(skills, index + 1, target - skills[index], current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] skills = new int[n];
        for (int i = 0; i < n; i++) skills[i] = input.nextInt();
        int target = input.nextInt();

        findTeams(skills, 0, target, new ArrayList<Integer>());
    }
}

