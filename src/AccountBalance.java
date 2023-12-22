import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class AccountBalance extends Authentication{
    void accountBalance() throws FileNotFoundException {
        File accountBalanceFile = new File(path);
        Scanner InputBufferAccountBalance = new Scanner(accountBalanceFile);
        
        try{
            while(InputBufferAccountBalance.hasNextLine()){
                String line = InputBufferAccountBalance.nextLine();
                String[] fetchDataForAccountBalance = line.split(" ");
                
                    if (fetchDataForAccountBalance[0].equals(accountNumber)) {
                        System.out.println(fetchDataForAccountBalance[2] + " Account Balance = " + fetchDataForAccountBalance[3]);
                        break;
                }
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
