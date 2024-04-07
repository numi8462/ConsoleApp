/** 
* @author <Youngho Kim - s3726115> 
*/ 
package claims;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import java.util.Iterator;

import customers.Customer;
import customers.CustomerManager;

public class ClaimManager implements ClaimProcessManager{
    List<Claim> claims = new ArrayList<>();
   
    // Constructor
    public ClaimManager(){
        this.claims = new ArrayList<>();
    }

    // Getter and Setter
    public List<Claim>  getClaims() { return this.claims;}
    public void setClaims(List<Claim> claims){this.claims = claims;}

    // Method to check if a Claim ID is duplicate
    public boolean isDuplicate(String id, List<Claim> claims) {
        for (Claim claim : claims) {
            if (claim.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Sort claims according to date oldest to newest (Bubble sort)
    public void sortClaims(List<Claim> claims) {
        int n = claims.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (claims.get(j).getClaimDate().after(claims.get(j+1).getClaimDate())) {
                    // Swap claims.get(j) and claims.get(j+1)
                    Claim temp = claims.get(j);
                    claims.set(j, claims.get(j+1));
                    claims.set(j+1, temp);
                }
            }
        }
    }

    //Adds new claim
    public void add(Customer customer){
        Claim newClaim = new Claim();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following details:");

        // creates unique uuid for claim
        String id;
        do {
            UUID uuid = UUID.randomUUID();
            long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
            id = "f-" + Long.toString(l).substring(0, 10);
        } while (isDuplicate(id, this.claims));

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

        double claimAmount;
        while (true) {
            System.out.println("Enter claim amount:");
            if (scanner.hasNextDouble()) {
                claimAmount = scanner.nextDouble();
                newClaim.setClaimAmount(claimAmount);
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // discard the invalid input
            }
        }

        newClaim.setStatus("New");

        System.out.println("Enter receiver banking info (Bank - Name - Number):");
        newClaim.setReceiverBankingInfo(scanner.next());

        claims.add(newClaim);
        customer.getClaims().add(newClaim);
    };

    //update a claim
    public void update(Claim claim){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new card number:");
        claim.setCardNumber(scanner.nextLine());

        System.out.println("Enter exam date (yyyy-MM-dd):");
        try {
            claim.setExamDate(new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));
        } catch (ParseException e) {
            System.out.println("Wrong format");
            e.printStackTrace();
        }

        System.out.println("Enter number of documents:");
        int numDocs = scanner.nextInt();
        List<String> documents = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
            System.out.println("Enter document " + (i+1) + " name:");
            documents.add(claim.getId()+"_"+claim.getCardNumber()+"_"+scanner.next()+".pdf");
        }
        claim.setDocuments(documents);

        System.out.println("Enter new claim amount:");
        claim.setClaimAmount(scanner.nextDouble());

        System.out.println("Enter new status amount:");
        claim.setStatus(scanner.next());

        System.out.println("Enter receiver banking info (Bank - Name - Number):");
        claim.setReceiverBankingInfo(scanner.next());

        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claim.getId())) {
                claims.set(i, claim);
                break;
            }
        }
    };

    //delete a claim
    public void delete(String id, Customer customer){
        // Uss iterator to iterate through each claim list
        Iterator<Claim> iterator = claims.iterator();
        while (iterator.hasNext()) {
            Claim c = iterator.next();
            if (c.getId().equals(id)) {
                iterator.remove();
            }
        }
    
        iterator = customer.getClaims().iterator();
        while (iterator.hasNext()) {
            Claim c = iterator.next();
            if (c.getId().equals(id)) {
                iterator.remove();
            }
        }
    };

    //get one claim
    public Claim getOne(String id){
        for(Claim c : claims) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    };

    //get all claims
    public List<Claim> getAll(){
        return this.claims;
    };

    // Reads claims from claim text files
    public void readClaimsToFile(String filename, CustomerManager customerManager){

        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(Claim.fromString(line,customerManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sortClaims(claims);
    };

    // Write claims data to a file
    public void writeClaimsToFile(String filename) {
        sortClaims(claims);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/"+filename))) {
            for (Claim claim : claims) {
                writer.write(claim.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // prints claims
    public void printClaims(){
        List<Claim> claims = this.getClaims();
        System.out.println("[ List of all Claims ] (Old to New)");
        int i = 1;
        for(Claim c : claims){
            System.out.println(i+". "+c.toString()+"\n");
            i++;
        }
    }
}
