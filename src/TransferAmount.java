import java.io.*;
import java.util.Scanner;

public class TransferAmount extends Authentication {
    static String transactionFilePath = "C:/Users/Dell/IdeaProjects/atm_interface/src/TextFiles/Transferring_history.txt";
    static File transactionFile = new File(transactionFilePath);
    static String receiverAccountHolderName;
    void transferAmount() throws IOException {
        System.out.println("------ACCOUNT TRANSFER------");
        String accountToTransfer;
        int amount;
        Scanner transferAmountScanner = new Scanner(System.in);


        System.out.print("Enter the Account Number to transfer to: ");
        accountToTransfer = transferAmountScanner.nextLine();

        System.out.print("Enter the amount to transfer: ");
        amount = transferAmountScanner.nextInt();

        String authenticationFilePath = "C:/Users/Dell/IdeaProjects/atm_interface/src/TextFiles/AuthenticationController.txt";
        String transactionFilePath = "C:/Users/Dell/IdeaProjects/atm_interface/src/TextFiles/Transferring_history.txt";

        File authenticationFile = new File(authenticationFilePath);
        File transactionFile = new File(transactionFilePath);

        Scanner InputBufferTranferAmount = new Scanner(authenticationFile);
        StringBuilder updatedData = new StringBuilder();

        while (InputBufferTranferAmount.hasNextLine()) {
            String line = InputBufferTranferAmount.nextLine();
            String[] fetchDataForTranferAmount = line.split(" ");

            if (fetchDataForTranferAmount[0].equals(accountNumber))
            {
                int balance = Integer.parseInt(fetchDataForTranferAmount[3]);
                if (balance >= amount)
                {
                    balance -= amount;
                    fetchDataForTranferAmount[3] = String.valueOf(balance);

                }
                else
                {
                    System.out.println("Insufficient funds for the transfer.");
                    return;
                }
            }

            if (fetchDataForTranferAmount[0].equals(accountToTransfer))
            {
                receiverAccountHolderName = fetchDataForTranferAmount[2];
                int balance = Integer.parseInt(fetchDataForTranferAmount[3]);
                balance += amount;
                fetchDataForTranferAmount[3] = String.valueOf(balance);
            }

            updatedData.append(String.join(" ", fetchDataForTranferAmount)).append("\n");
        }

        BufferedWriter authenticationWriter = new BufferedWriter(new FileWriter(authenticationFile));
        authenticationWriter.write(updatedData.toString());
        authenticationWriter.close();

        // Append transaction details to the transaction file
        BufferedWriter transactionWriter = new BufferedWriter(new FileWriter(transactionFile, true));
        String transactionDetails = accountNumber + " " + accountHolderName + " Transfers " + amount + " To " + receiverAccountHolderName+" "+ accountToTransfer;

        transactionWriter.write(transactionDetails + "\n");
        transactionWriter.close();

        System.out.println("Transfer successful. Transaction recorded.");
    }
}
