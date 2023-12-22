import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionHistory extends  TransferAmount{
    void transactionHistory() throws FileNotFoundException {
        System.out.println("------Account History------");
        Scanner InputBufferTransactionHistory = new Scanner(transactionFile);

        while(InputBufferTransactionHistory.hasNextLine()){
            String line = InputBufferTransactionHistory.nextLine();
            String[] fetchDataForTransactionHistory = line.split(" ");

            if(fetchDataForTransactionHistory[0].equals(accountNumber) || fetchDataForTransactionHistory[6].equals(accountNumber)){
                System.out.println(line);
            }
        }
    }
}
