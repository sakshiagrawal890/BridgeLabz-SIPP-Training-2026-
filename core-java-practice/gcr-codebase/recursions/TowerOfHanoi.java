import java.util.Scanner;

public class TowerOfHanoi {
    static void solveHanoi(int disks, char source, char helper, char destination) {
        if (disks == 0) {
            return;
        }

        solveHanoi(disks - 1, source, destination, helper);
        System.out.println("Move disk " + disks + " from " + source + " to " + destination);
        solveHanoi(disks - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        solveHanoi(n, 'A', 'B', 'C');
        input.close();
    }
}
