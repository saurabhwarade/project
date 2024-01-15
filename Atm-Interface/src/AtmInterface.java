import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ATM {
    private final String accountId;
    private String pin;
    private double balance;
    private final ArrayList<String> transactionHistory;

    public ATM(String accountId, String pin, double initialBalance) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +$" + amount);
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -$" + amount);
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void transfer(double amount, ATM recipient) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transfer: -$" + amount + " to Account " + recipient.getAccountId());
            System.out.println("Transferred $" + amount + " to Account " + recipient.getAccountId() + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }
public void getBalanceAmount(){
    System.out.println("Balance: $" + balance);
}
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public double getBalance() {
        return balance;
    }


    public String getAccountId() {
        return accountId;
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Map<String, ATM> accounts = new HashMap<>();
        accounts.put("123456", new ATM("123456", "1234", 1000.0));
        accounts.put("567890", new ATM("567890", "5678", 500.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter account ID: ");
            String accountId = scanner.next();

            if (!accounts.containsKey(accountId)) {
                System.out.println("Invalid account ID. Please try again.");
                continue;
            }

            ATM currentAccount = accounts.get(accountId);

            System.out.print("Enter PIN: ");
            String enteredPin = scanner.next();

            if (!currentAccount.authenticate(enteredPin)) {
                System.out.println("Invalid PIN. Please try again.");
                continue;
            }

            while (true) {
                System.out.println("1. Deposit\n2. Withdraw\n3. Transfer\n4. Balance\n5. Transaction History\n6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        currentAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        currentAccount.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter the transfer amount: $");
                        double transferAmount = scanner.nextDouble();
                        System.out.print("Enter recipient account ID: ");
                        String recipientId = scanner.next();

                        if (!accounts.containsKey(recipientId)) {
                            System.out.println("Invalid recipient account ID. Please try again.");
                            continue;
                        }

                        ATM recipientAccount = accounts.get(recipientId);
                        currentAccount.transfer(transferAmount, recipientAccount);
                        break;
                    case 4:
                        currentAccount.getBalanceAmount();
                        break;
                    case 5:
                        currentAccount.displayTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
