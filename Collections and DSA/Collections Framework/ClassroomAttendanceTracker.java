import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Smart Classroom Attendance Tracker
 * 
 * Uses a HashMap<String, ArrayList<String>>:
 * - Key: Subject Name
 * - Value: ArrayList of student names present in that subject
 * 
 * Operations:
 * 1. Mark attendance for students in different subjects.
 * 2. Prevent duplicate attendance for the same student in a subject.
 * 3. Display the list of students present in each subject.
 * 4. Show the total number of students present in every subject.
 */
public class ClassroomAttendanceTracker {

    // HashMap to store subject-wise student attendance
    static HashMap<String, ArrayList<String>> attendanceMap = new HashMap<>();

    // ---- Mark Attendance ----
    static void markAttendance(Scanner sc) {
        System.out.print("Enter Subject Name: ");
        String subject = sc.nextLine().trim();
        System.out.print("Enter Student Name: ");
        String student = sc.nextLine().trim();

        // Retrieve or initialize the student list for this subject
        ArrayList<String> studentList = attendanceMap.get(subject);
        if (studentList == null) {
            studentList = new ArrayList<>();
            attendanceMap.put(subject, studentList);
        }

        // Prevent duplicate attendance for the same student in the subject
        // We compare case-insensitively for student names to be robust
        boolean isDuplicate = false;
        for (String existingStudent : studentList) {
            if (existingStudent.equalsIgnoreCase(student)) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            System.out.println("REJECTED: Attendance for '" + student + "' in '" + subject + "' is already marked.");
        } else {
            studentList.add(student);
            System.out.println("Attendance marked successfully for '" + student + "' in '" + subject + "'.");
        }
    }

    // ---- Display Student List for Each Subject ----
    static void displayAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        System.out.println("\n===== Subject-wise Attendance Lists =====");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();

            System.out.println("Subject: " + subject);
            if (students.isEmpty()) {
                System.out.println("  No students present.");
            } else {
                for (int i = 0; i < students.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + students.get(i));
                }
            }
        }
        System.out.println("=========================================");
    }

    // ---- Show Total Students Present in Every Subject ----
    static void showTotalAttendanceCount() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        System.out.println("\n===== Attendance Summary (Headcount) =====");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();
            System.out.println("Subject: " + subject + " | Total Present: " + students.size());
        }
        System.out.println("===========================================");
    }

    // ---- Main method with menu-driven interface ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("==================================================");
        System.out.println("       SMART CLASSROOM ATTENDANCE TRACKER        ");
        System.out.println("==================================================");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance List for Each Subject");
            System.out.println("3. Show Total Attendance Count per Subject");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    markAttendance(sc);
                    break;
                case 2:
                    displayAttendance();
                    break;
                case 3:
                    showTotalAttendanceCount();
                    break;
                case 4:
                    System.out.println("Exiting Attendance Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
