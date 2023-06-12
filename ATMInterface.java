import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }
    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount));
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
        }
        System.out.println();
    }
}
public class ATMInterface {
    private static Account currentAccount;
    private static Scanner scanner;
     public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initializeAccounts();

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (login(userId, pin)) {
            showMenu();
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
    }

    private static void initializeAccounts() {

        Account account1 = new Account("user1", "1234");
        Account account2 = new Account("user2", "5678");

        account1.deposit(1000.0);
        account2.deposit(500.0);

        currentAccount = account1;
    }

    private static boolean login(String userId, String pin) {

        if (currentAccount.getUserId().equals(userId) && currentAccount.validatePin(pin)) {
            return true;
        }
        return false;
    }

    private static void showMenu() {
        int choice;
        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            //switch case
            switch (choice) {
                case 1:
                    currentAccount.printTransactionHistory();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void performWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        currentAccount.withdraw(amount);
    }

    private static void performDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
    }
    private static void performTransfer() {
        System.out.print("Enter the recipient's User ID: ");
        String recipientId = scanner.next();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        // Find the recipient's account
        Account recipient = getAccountById(recipientId);

        if (recipient != null) {
            currentAccount.transfer(recipient, amount);
        } else {
            System.out.println("Recipient not found!");
        }
    }
    private static Account getAccountById(String userId) {
        if (currentAccount.getUserId().equals(userId)) {
            return currentAccount;
        }
        return null;
    }
}
