/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.Date;
import claims.Claim;
import claims.ClaimManager;
import claims.ClaimProcessManager;
import customers.CustomerManager;
import customers.Customer;


public class Menu {

    // Method to check if a Claim ID is duplicate
    private boolean isDuplicate(String id, List<Claim> claims) {
        for (Claim claim : claims) {
            if (claim.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // prints main menu
    public void printMainMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. Add a claim");
        System.out.println("2. Update a claim");
        System.out.println("3. Delete a claim");
        System.out.println("4. Search a claim");
        System.out.println("5. Show all claims");
        System.out.println("6. Exit");
    }

    // Prints and returns new claim
    public Claim newClaim(Customer customer, List<Claim> claims){
        Claim newClaim = new Claim();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following details:");

        // creates unique uuid for claim
        String id;
        do {
            UUID uuid = UUID.randomUUID();
            long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
            id = "f-" + Long.toString(l).substring(0, 10);
        } while (isDuplicate(id, claims));

        newClaim.setId(id);
        newClaim.setClaimDate(new Date());
        newClaim.setInsuredPerson(customer);

        System.out.println("Enter card number:");
        newClaim.setCardNumber(scanner.nextLine());

        System.out.println("Enter exam date (yyyy-MM-dd):");
        try {
            newClaim.setExamDate(new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Enter number of documents:");
        int numDocs = scanner.nextInt();
        List<String> documents = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
            System.out.println("Enter document " + (i+1) + " name:");
            documents.add(newClaim.getId()+"_"+newClaim.getCardNumber()+"_"+scanner.next()+".pdf");
        }
        newClaim.setDocuments(documents);

        System.out.println("Enter claim amount:");
        newClaim.setClaimAmount(scanner.nextDouble());

        newClaim.setStatus("New");

        System.out.println("Enter receiver banking info (Bank - Name - Number):");
        newClaim.setReceiverBankingInfo(scanner.next());

        return newClaim;
    }

    // Prints add claim menu
    public void printAddMenu(CustomerManager customerManager,ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();
        List<Customer> customers = customerManager.getCustomers();
        
        System.out.println("Customer List: ");
        int i = 1;
        for(Customer c : customers){
            System.out.println(i + ". " +c.getFullName() + ", ID: " + c.getId());
            i++;
        }
        System.out.println("Type in the customer's ID  to add a new claim: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Customer c : customers){
            if (c.getId().equals(input)){
                Claim claim = newClaim(c, claims);
                customerManager.findCustomerById(input).add(claim);
                claimManager.add(claim);
                isMatchFound = true;
                System.out.println("Added New claim!!");
            }
            
        }

        if (!isMatchFound) {
            System.out.println("Error!! No matching customer found");
        }

        
    }

    public void printUpdateMenu(){

    }

    // Print search menu. search by claim or user's id
    public void printSearchMenu(ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();

        System.out.println("Type the claim ID or user's ID: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Claim c : claims){
            if (c.getId().equals(input) || c.getInsuredPerson().getId().equals(input)) {
                System.out.println(c.toString());
            }
        }

        if (!isMatchFound) {
            System.out.println("Error!! No matching claim found");
        }
    }

    // Show all clainms
    public void printShowAllMenu(ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();
        System.out.println("[ List of all Claims ]");
        for(Claim c : claims){
            System.out.println(c.toString());
        }
    }
    
}