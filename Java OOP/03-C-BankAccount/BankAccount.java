import java.util.Random;

public class BankAccount {

    // MENMBER VARIABLES
    private String name;
    private int accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    private double totalAmount = 0;

    // CONSTRACTOR
    // No arguments, sets the checkingBalance savingsBalance to 0.0
    public BankAccount() {
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        numberOfAccounts++;
        this.accountNumber = this.randomAccountNumber();
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a checking balance and savings balance as arguments,
    // and sets them to their custom variables
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        this.totalAmount = checkingBalance + savingsBalance;
        this.accountNumber = this.randomAccountNumber();
    }

    // public static int numberOfAccountsCreated() {
    // return numberOfAccounts;
    // }

    public void deposit(double checking, double saving) {
        totalAmount += checking + saving;
        System.out.println("You Have Deposit: Cheking $" + checking + " and saving: $" + saving + " to the account: "
                + this.getName());
        System.out.println("The New Total Amount is: $" + totalAmount);
    }

    public void withdraw(double amount) {
        if (totalAmount >= amount) {
            totalAmount -= amount;
            System.out.println("You Have Withdraw the amount of: $" + amount + " from the account: " + this.getName());
            System.out.println("The New Total Amount of the account: " + this.getName() + " is: $" + totalAmount);
        } else {
            System.out.println("insufficient funds");
        }
    }

    // Generate Random Ten Digit Number

    private int randomAccountNumber() {
        Random random = new Random();
        return random.nextInt(1000000000) + 999999999;
    }

    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    // public void setCheckingBalance(double checkingBalance) {
    // this.checkingBalance = checkingBalance;
    // }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public double gettotalAmount() {
        return this.totalAmount;
    }

    // public void setSavingsBalance(double savingsBalance) {
    // this.savingsBalance = savingsBalance;
    // }
}