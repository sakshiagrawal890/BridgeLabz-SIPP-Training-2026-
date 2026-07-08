class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String customerName, double balance, double interestRate) {
        super(accountNumber, customerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("------------------------------");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Customer Name : " + getCustomerName());
        System.out.println("Balance       : " + getBalance());
        System.out.println("Interest Rate : " + getInterestRate() + "%");
        System.out.println("------------------------------");
    }
}
