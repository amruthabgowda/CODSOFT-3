package codsoft;
import java.util.Scanner;

//Class to represent the user's Bank Account
class BankAccount {
 private double balance; // Account balance

 // Constructor to initialize account with starting balance
 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 // Method to deposit amount into the account
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited: $" + amount);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 // Method to withdraw amount from the account
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Successfully withdrawn: $" + amount);
     } else if (amount > balance) {
         System.out.println("Insufficient balance!");
     } else {
         System.out.println("Invalid withdrawal amount!");
     }
 }

 // Method to check the current balance
 public void checkBalance() {
     System.out.println("Current balance: $" + balance);
 }
}

//Class to represent the ATM machine
public class atminterface {
 private static BankAccount account;

 // Main method to run the ATM system
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Initialize the user's bank account with an initial balance
     System.out.print("Enter initial balance for your account: $");
     double initialBalance = scanner.nextDouble();
     account = new BankAccount(initialBalance);

     // Display ATM menu and options
     boolean exit = false;
     while (!exit) {
         System.out.println("\n--- ATM Menu ---");
         System.out.println("1. Deposit Money");
         System.out.println("2. Withdraw Money");
         System.out.println("3. Check Balance");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");
         int option = scanner.nextInt();

         // Process user's choice
         switch (option) {
             case 1:
                 System.out.print("Enter amount to deposit: $");
                 double depositAmount = scanner.nextDouble();
                 account.deposit(depositAmount);
                 break;
             case 2:
                 System.out.print("Enter amount to withdraw: $");
                 double withdrawAmount = scanner.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;
             case 3:
                 account.checkBalance();
                 break;
             case 4:
                 System.out.println("Exiting... Thank you for using the ATM!");
                 exit = true;
                 break;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }

     scanner.close();
 }
}

