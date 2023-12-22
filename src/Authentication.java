import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Authentication {
    static String path = "C:/Users/Dell/IdeaProjects/atm_interface/src/TextFiles/UserDetailsDB.txt";
    File authenticationFile = new File(path);
    static String accountNumber,accountHolderName;
    String atmPin;

    void authenticationUser() throws FileNotFoundException {
        System.out.println("------WELCOME TO SBI ATM------");
        boolean authen = isValid();
        if (authen) {
            System.out.println("---Verifies---");
        } else {
            System.out.println("---Failed---");
        }
    }

    boolean isValid() throws FileNotFoundException {
        boolean isAuthentication = false;
        Scanner authenticationScanner = new Scanner(System.in);
        
        System.out.print("Enter Account Number : ");
        accountNumber = authenticationScanner.nextLine();
        
        System.out.print("Enter ATM Pin : ");
        atmPin = authenticationScanner.nextLine();
        
        Scanner InputBufferAuthentication = new Scanner(authenticationFile);
        
        try {
            while (InputBufferAuthentication.hasNextLine()) {
                String line = InputBufferAuthentication.nextLine();
                String[] values = line.split(" ");

                // Check if the array has at least 2 elements
                    if (values[0].equals(accountNumber) && values[1].equals(atmPin)) {
                        isAuthentication = true;
                        accountHolderName = values[2];
                    }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return isAuthentication;
    }
}

