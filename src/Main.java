// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal of $" + amount + " successful.");
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Please check the amount and your balance.");
        }
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit of $" + amount + " successful.");
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Deposit failed. Please enter a valid amount.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount userAccount = new BankAccount(500.00);

        // Connect the ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        // Display the ATM menu to the user
        atm.showMenu();
    }
}
