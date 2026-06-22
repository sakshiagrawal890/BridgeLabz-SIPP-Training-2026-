import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSkillAssignment {
    public static void findTeams(int[] skills, int target, int index, List<Integer> team) {
        if (target == 0) {
            System.out.println(team);
            return;
        }

        if (index == skills.length || target < 0) {
            return;
        }

        team.add(skills[index]);
        findTeams(skills, target - skills[index], index + 1, team);

        team.remove(team.size() - 1);
        findTeams(skills, target, index + 1, team);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of employees: ");
            int n = scanner.nextInt();

            int[] skills = new int[n];
            System.out.println("Enter employee skill scores:");

            for (int i = 0; i < n; i++) {
                skills[i] = scanner.nextInt();
            }

            System.out.print("Enter target skill score: ");
            int target = scanner.nextInt();

            System.out.println("Possible project teams:");
            findTeams(skills, target, 0, new ArrayList<>());
        }
    }
}
