import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Withdraw extends Authentication{
    void withdrawAmount() throws IOException {
        System.out.println("------WITHDRAWAL------");
        int amountToWithdraw;
        AccountBalance accountBalanceObj = new AccountBalance();
        Scanner withdrawScanner = new Scanner(System.in);
        System.out.print("Withdrawal Amount : ");
        amountToWithdraw = withdrawScanner.nextInt();
        File withdrawAmountFile = new File(path);
        Scanner InputBufferWithdraw = new Scanner(withdrawAmountFile);
        StringBuilder updatedData = new StringBuilder();
        while(InputBufferWithdraw.hasNext()){
            String line = InputBufferWithdraw.nextLine();
            String[] fetchDataForWithdraw = line.split(" ");
            if(fetchDataForWithdraw[0].equals(accountNumber)){
                int balance = Integer.parseInt(fetchDataForWithdraw[3]);
                balance = balance - amountToWithdraw ;
                if(balance < 0){
                    System.out.println("Insufficient balance");
                }
                else {
                    String updatedBalance = String.valueOf(balance);
                    fetchDataForWithdraw[3] = updatedBalance;
                    System.out.println("Withdrawn successfully ");
                }
            }
            updatedData.append(String.join(" ", fetchDataForWithdraw)).append("\n");
        }
        FileWriter writer = new FileWriter(withdrawAmountFile);
        writer.write(updatedData.toString());
        writer.close();
        accountBalanceObj.accountBalance();
    }
}
