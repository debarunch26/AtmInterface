import java.util.ArrayList;
import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double iniitialBalance){
        this.balance = iniitialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM{
    private BankAccount userAccount;

    public ATM(BankAccount account){
        this.userAccount = account;
    }

    public void displayMenu(){
        System.out.println("ATM Menu: ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start(){
        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                displayMenu();
                System.out.println("Enter your choice");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:

                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    boolean withdraw = userAccount.withdraw(withdrawAmount);
                    if(withdraw){
                        System.out.println("withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    } else {
                        System.out.println("Insufficient balance for this withdrawal.");
                    }
                    break;

                    case 2:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                    break;

                    case 3:
                    System.out.println("Your current balance is: " + userAccount.getBalance());
                    break;

                    case 4:
                    System.out.println("Thankyou for using the ATM.");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Invalid choice.please try again.");
                }
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
