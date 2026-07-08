package programming_fundamentals;

public class BankAccountDemo {
    // Inner class representing a bank account
    static class BankAccount {
        private String accountNumber;
        private String holder;
        private double balance;
        private StringBuilder statement = new StringBuilder();

        // static couter for total accounts created
        private static int totalAccountsCreated = 0;

        public BankAccount(String accountNumber, String holder, double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
            statement.append("Account created with opening balance: Rs. ").append(balance).append("\n");
            totalAccountsCreated++;
        }

        public void deposit(double amount) {

            if (amount <= 0) {
                statement.append("Deposit failed: Amount must be positive\n");
                return;
            }
            balance += amount;
            statement.append("Deposited Rs. ").append(amount).append(", Current Balance: Rs. ").append(balance)
                    .append("\n");
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                statement.append("Withdrawal failed: Amount must be positive\n");
                return;
            }
            if (amount > balance) {
                statement.append("Withdrawal failed: Insufficient balance for Rs. ").append(amount).append("\n");
                return;
            }
            balance -= amount;
            statement.append("Withdrawn Rs. ").append(amount).append(", Current Balance: Rs. ").append(balance)
                    .append("\n");
        }

        public String getStatement() {
            return "Account Number: " + accountNumber + "\n"
                    + "Holder Name: " + holder + "\n"
                    + "Final Balance: Rs. " + balance + "\n"
                    + "Transactions:\n" + statement.toString();
        }

        public static int getTotalAccountsCreated() {
            return totalAccountsCreated;
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("A001", "Shakshi", 5000);
        BankAccount a2 = new BankAccount("A002", "Aman", 8000);
        BankAccount a3 = new BankAccount("A003", "Priya", 3000);

        // 5 transactions per account
        a1.deposit(1500);
        a1.withdraw(700);
        a1.deposit(1200);
        a1.withdraw(3000);
        a1.withdraw(2000);

        a2.withdraw(2000);
        a2.deposit(2500);
        a2.withdraw(1000);
        a2.deposit(500);
        a2.withdraw(6000);

        a3.deposit(1200);
        a3.withdraw(500);
        a3.deposit(800);
        a3.withdraw(1000);
        a3.withdraw(2500);

        // Print statements
        System.out.println(a1.getStatement());
        System.out.println("--------------------------------");
        System.out.println(a2.getStatement());
        System.out.println("--------------------------------");
        System.out.println(a3.getStatement());
        System.out.println("--------------------------------");
        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccountsCreated());
    }
}
