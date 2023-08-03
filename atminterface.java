import java.util.ArrayList;
import java.util.Scanner;

public class atminterface{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        int choice;

        while(true) {
            System.out.println("Choose an option:");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Transfer");
            System.out.println("4: Print transaction history");
            System.out.println("5: Quit");
            choice = scanner.nextInt();
            double amount;

            switch(choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter amount to transfer:");
                    amount = scanner.nextDouble();
                    // For simplicity, we're not transferring to a specific account
                    account.transfer(amount);
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

class Account {
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public void transfer(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred: " + amount);
        } else {
            System.out.println("Invalid transfer amount");
        }
    }

    public void printTransactionHistory() {
        for(String s : transactionHistory) {
            System.out.println(s);
        }
    }
}
