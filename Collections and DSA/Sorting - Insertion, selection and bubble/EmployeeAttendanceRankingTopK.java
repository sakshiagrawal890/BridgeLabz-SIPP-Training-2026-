import java.util.ArrayList;// arraylist 
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeAttendanceRankingTopK {

    private static class Pair {
        int id;
        int attendance;

        Pair(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }
    }

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(employeeIds[i], attendance[i]));
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                // attendance desc
                if (b.attendance != a.attendance) return Integer.compare(b.attendance, a.attendance);
                // tie: smaller employeeId first
                return Integer.compare(a.id, b.id);
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).id;
        }
        return result;
    }

    public static void main(String[] args) {
        // Example from prompt
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] topK = topKEmployees(employeeIds, attendance, k);
        System.out.println("Top-" + k + " employee IDs: " + Arrays.toString(topK));
        // Expected: [103, 101, 104]
    }
}

