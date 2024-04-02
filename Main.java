/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import claims.Claim;
import claims.ClaimManager;
import claims.ClaimProcessManager;
import customers.CustomerManager;

public class Main {

    
    public static void main(String[] args) {
        
        CustomerManager customerManager = new CustomerManager();
        ClaimManager claimManager = new ClaimManager();

        //first read policyHolder then Depenedent then Claims. then adds claims to customers
        customerManager.readPolicyHolderFile("policyHolders.txt");
        customerManager.readDependentFile("dependents.txt");
        claimManager.readClaimsFromFile("claims.txt", customerManager);
        customerManager.addClaimsToCustomer(claimManager);
        customerManager.readInsuranceFile("insuranceCards.txt");
        customerManager.printCustomersInfo();
        // claimManager.printClaims();

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        while(true){
            menu.printMainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Add a claim
                    break;
                case "2":
                    // Update a claim
                    break;
                case "3":
                    // Delete a claim
                    break;
                case "4":
                    // Search a claim
                    break;
                case "5":
                    // Show all claims
                    break;
                case "6":
                    System.out.println("Exiting System...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
