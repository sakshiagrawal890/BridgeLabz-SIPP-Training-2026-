public abstract class BankAccount {
    private int accountNumber;
    private String customerName;
    private double balance;

    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public abstract void displayAccountDetails();
    public abstract void calculateInterest();
    public void printAccountSummary() {
        System.out.println("Account Summary");
        System.out.println("------------------------------");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Customer Name : " + getCustomerName());
        System.out.println("Balance       : " + getBalance());
        System.out.println("------------------------------");
    }
    public void printTransactionHistory() {
        System.out.println("Transaction History");
        System.out.println("------------------------------");
        // Placeholder for transaction history logic
        System.out.println("No transactions available.");
        System.out.println("------------------------------");
    }
    
}
