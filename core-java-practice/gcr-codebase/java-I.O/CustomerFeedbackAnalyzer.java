import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        int goodFeedbackCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter 5 feedback messages:");

            for (int i = 1; i <= 5; i++) {
                String feedback = reader.readLine();

                if (feedback != null && feedback.toLowerCase().contains("good")) {
                    goodFeedbackCount++;
                }
            }

            System.out.println("Good Feedback Count = " + goodFeedbackCount);
        } catch (IOException e) {
            System.out.println("Error reading feedback");
        }
    }
}
