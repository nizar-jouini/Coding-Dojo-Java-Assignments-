public class TestBankAccount {
    public static void main(String[] args) {
        // Creating 3 instances of BankAccount
        BankAccount account1 = new BankAccount();
        account1.setName("account1");
        BankAccount account2 = new BankAccount(120, 150);
        account2.setName("account2");
        BankAccount account3 = new BankAccount(70, 320);
        account3.setName("account3");

        /* ============ App Test Cases ============= */

        // Display number of accounts
        System.out.println("\n----- Number of Accounts Test -----");
        System.out.println("Number of accounts: " + BankAccount.numberOfAccounts);

        // Get checking & savings balance of each account
        System.out.println("\n----- Checking & Savings Balance of each Account Test -----");
        System.out.println("account1 Number: " + account1.getAccountNumber());
        System.out.println("account1 checking balance: " + account1.getCheckingBalance());
        System.out.println("account1 savings balance: " + account1.getSavingsBalance());
        System.out.println("account1 Total Amount: " + account1.gettotalAmount());

        System.out.println("\naccount2 Number: " + account2.getAccountNumber());
        System.out.println("account2 checking balance: " + account2.getCheckingBalance());
        System.out.println("account2 savings balance: " + account2.getSavingsBalance());
        System.out.println("account2 Total Amount: " + account2.gettotalAmount());

        System.out.println("\naccount3 Number: " + account3.getAccountNumber());
        System.out.println("account3 checking balance: " + account3.getCheckingBalance());
        System.out.println("account3 savings balance: " + account3.getSavingsBalance());
        System.out.println("account3 Total Amount: " + account3.gettotalAmount());

        // Deposit Money
        System.out.println("\n----- Deposit Test -----");
        account1.deposit(100, 200);
        account3.deposit(30, 50);

        // Withdraw Money
        System.out.println("\n----- Withdraw Test -----");
        account1.withdraw(60);
        account2.withdraw(200);
        account3.withdraw(600);
    }

}
