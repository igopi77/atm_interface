import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Authentication authenticationObj = new Authentication();
        authenticationObj.authenticationUser();
        while (true) {
            System.out.println("1.WITHDRAW" + "                  " + "2.TRANSFER AMOUNT\n" +
                    "3.BALANCE" + "                  " + "4.TRANSACTION HISTORY\n" +
                    "                  " + "5.EXIT");
            int choice;
            Scanner mainScanner = new Scanner(System.in);
            System.out.print("Click Any From This: ");
            choice = mainScanner.nextInt();
            switch (choice) {
                case 1:
                    Withdraw withdrawObj = new Withdraw();
                    withdrawObj.withdrawAmount();
                    break;
                case 2:
                    TransferAmount transferAmountObj = new TransferAmount();
                    transferAmountObj.transferAmount();
                    break;
                case 3:
                    AccountBalance accountBalanceObj = new AccountBalance();
                    accountBalanceObj.accountBalance();
                    break;
                case 4:
                    TransactionHistory transactionHistoryObj = new TransactionHistory();
                    transactionHistoryObj.transactionHistory();
                    break;
                case 5:
                    System.out.println("Please take your card \n Hava a nice day :)");
                    break;
                default:
                    System.out.println("Please take your card \n Hava a nice day :)");
                    break;
            }
        }
    }
}