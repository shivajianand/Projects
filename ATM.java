import java.util.ArrayList; import java.util.Scanner;

public class ATM { private int balance = 0; private String pin = "1234"; private ArrayList<String> transactionHistory = new ArrayList<>(); private Scanner scanner = new Scanner(System.in);

public void checkBalance() {
    System.out.println("Current Balance: $" + balance);
    transactionHistory.add("Checked Balance: $" + balance);
}

public void deposit() {
    System.out.print("Enter amount to deposit: $");
    int amount = scanner.nextInt();
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        transactionHistory.add("Deposited: $" + amount);
    } else {
        System.out.println("Invalid amount. Try again.");
    }
}

public void withdraw() {
    System.out.print("Enter amount to withdraw: $");
    int amount = scanner.nextInt();
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
        transactionHistory.add("Withdrawn: $" + amount);
    } else {
        System.out.println("Invalid amount or insufficient balance.");
    }
}

public void changePin() {
    System.out.print("Enter current PIN: ");
    String currentPin = scanner.next();
    if (currentPin.equals(pin)) {
        System.out.print("Enter new PIN: ");
        String newPin = scanner.next();
        if (newPin.length() == 4) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
            transactionHistory.add("Changed PIN.");
        } else {
            System.out.println("PIN must be 4 digits.");
        }
    } else {
        System.out.println("Incorrect PIN.");
    }
}

public void viewTransactionHistory() {
    if (transactionHistory.isEmpty()) {
        System.out.println("No transactions found.");
    } else {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public void menu() {
    while (true) {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                changePin();
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                System.out.println("Thank you for using the ATM.");
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}

public static void main(String[] args) {
    ATM atm = new ATM();
    atm.menu();
}

}
