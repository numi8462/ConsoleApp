/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.Scanner;
import java.util.Iterator;
import claims.Claim;
import claims.ClaimManager;
import customers.Customer;
import customers.CustomerManager;

public class Main {

    //prints out main menu
    public static void printMainMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. Add a claim");
        System.out.println("2. Update a claim");
        System.out.println("3. Delete a claim");
        System.out.println("4. Search a claim");
        System.out.println("5. Show all claims");
        System.out.println("6. Exit");
    }

    //prints add claim menu
    public static void printAddMenu(CustomerManager customerManager, ClaimManager claimManager){
        System.out.println("Customer List: ");
        int i = 1;
        for(Customer c : customerManager.getCustomers()){
            System.out.println(i + ". " +c.getFullName() + ", ID: " + c.getId());
            i++;
        }
        System.out.println("Type in the customer's ID  to add a new claim: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Customer c : customerManager.getCustomers()){
            if (c.getId().equals(input)){
                claimManager.add(c);
                isMatchFound = true;
                System.out.println("Added New claim!!");
            }
        }
        if (!isMatchFound) {
            System.out.println("Error!! No matching customer found");
        }

        claimManager.writeClaimsToFile("claims.txt");
    }
    
    // prints update menu
    public static void printUpdateMenu(CustomerManager customerManager, ClaimManager claimManager){
        System.out.println("Claim List: ");
        int i = 1;
        for(Claim c : claimManager.getClaims()){
            System.out.println(i + ". ID: " + c.getId());
            i++;
        }
        System.out.println("Type in the claim ID to update: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Customer cust : customerManager.getCustomers()){
            for(Claim claim : cust.getClaims()){
                if(claim.getId().equals(input)){
                    claimManager.update(claim);
                    isMatchFound=true;
                    System.out.println("Updated claim!!");
                }
            }
        }
        if (!isMatchFound) {
            System.out.println("Error!! No matching claim found");
        }

        claimManager.writeClaimsToFile("claims.txt");
    };

    // prints delete menu
    public static void printDeleteMenu(CustomerManager customerManager, ClaimManager claimManager){
        System.out.println("Claim List: ");
        int i = 1;
        for(Claim c : claimManager.getClaims()){
            System.out.println(i + ". ID: " + c.getId());
            i++;
        }
        System.out.println("Type in the claim ID to delete: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        Iterator<Customer> customerIterator = customerManager.getCustomers().iterator();
        while (customerIterator.hasNext()) {
            Customer cust = customerIterator.next();
            Iterator<Claim> claimIterator = cust.getClaims().iterator();
            while (claimIterator.hasNext()) {
                Claim claim = claimIterator.next();
                if (claim.getId().equals(input)) {
                    claimIterator.remove();
                    claimManager.delete(input, cust);
                    isMatchFound = true;
                    System.out.println("Deleted claim!!");
                }
            }
        }
        if (!isMatchFound) {
            System.out.println("Error!! No matching claim found");
        }

        claimManager.writeClaimsToFile("claims.txt");
    };

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        ClaimManager claimManager = new ClaimManager();

        //first read policyHolder then Depenedent then Claims. then adds claims to customers
        customerManager.readPolicyHolderFile("policyHolders.txt");
        customerManager.readDependentFile("dependents.txt");
        claimManager.readClaimsToFile("claims.txt", customerManager);
        customerManager.addClaimsToCustomer(claimManager);
        customerManager.readInsuranceFile("insuranceCards.txt");

        Scanner scanner = new Scanner(System.in);
        while(true){
            // Main menu
            printMainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Add a claim
                    printAddMenu(customerManager, claimManager);
                    break;
                case "2":
                    // Update a claim
                    printUpdateMenu(customerManager, claimManager);
                    break;
                case "3":
                    // Delete a claim
                    printDeleteMenu(customerManager, claimManager);
                    break;
                case "4":
                    // Search a claim
                    claimManager.printSearchMenu();
                    break;
                case "5":
                    // Show all claims
                    claimManager.printShowAllMenu();
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
