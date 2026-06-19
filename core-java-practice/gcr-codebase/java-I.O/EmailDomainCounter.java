import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String fileName = "emails.txt";
        String[] domains = new String[100];
        int[] counts = new int[100];
        int domainCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String email;

            while ((email = reader.readLine()) != null) {
                int atIndex = email.indexOf('@');

                if (atIndex == -1 || atIndex == email.length() - 1) {
                    continue;
                }

                String domain = email.substring(atIndex + 1).trim().toLowerCase();
                int foundIndex = -1;

                for (int i = 0; i < domainCount; i++) {
                    if (domains[i].equals(domain)) {
                        foundIndex = i;
                        break;
                    }
                }

                if (foundIndex == -1) {
                    domains[domainCount] = domain;
                    counts[domainCount] = 1;
                    domainCount++;
                } else {
                    counts[foundIndex]++;
                }
            }

            for (int i = 0; i < domainCount; i++) {
                System.out.println(domains[i] + " = " + counts[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading email file");
        }
    }
}
