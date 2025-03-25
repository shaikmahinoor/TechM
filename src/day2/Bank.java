package day2;
public class Bank {
    private double balance;
    private String owner;

    // Default constructor
    Bank() {
        this(0, "Unknown"); // Calls the third constructor with default values
    }

    // Constructor with balance
    Bank(double balance) {
        this(balance, "Unknown"); // Calls the third constructor with default owner name
    }

    // Constructor with balance and owner name
    Bank(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    void displayAccountInfo() {
        System.out.println("Balance: " + balance + ", Owner: " + owner);
    }

    public static void main(String[] args) {
        Bank acc1 = new Bank();
        Bank acc2 = new Bank(6000);
        Bank acc3 = new Bank(6000, "John");

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}

