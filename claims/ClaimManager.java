/** 
* @author <Youngho Kim - s3726115> 
*/ 
package claims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import customers.Customer;
import customers.CustomerManager;

public class ClaimManager {
    List<Claim> claims = new ArrayList<>();
   
    public ClaimManager(){
        this.claims = new ArrayList<>();
    }

    public List<Claim>  getClaims() { return this.claims;}

    // Method to check if a Claim ID is duplicate
    public boolean isDuplicate(String id, List<Claim> claims) {
        for (Claim claim : claims) {
            if (claim.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //find claim by id
    public Claim findClaimById(String id) {
        for (Claim c : claims) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null; // or throw an exception
    }

    //Adds new claim
    public void add(Claim claim){
        claims.add(claim);
    };

    //update a claim
    public void update(Claim updatedClaim){
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(updatedClaim.getId())) {
                claims.set(i, updatedClaim);
                break;
            }
        }
    };

    //delete a claim
    public void delete(Claim claim){

    };

    public void readClaimsFromFile(String filename, CustomerManager customerManager){

        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(Claim.fromString(line,customerManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public void printClaims(){
        for(Claim  c : claims){
            System.out.println(c.toString());
        }
    }

    // Print search menu. search by claim or user's id
    public void printSearchMenu(){
        List<Claim> claims = this.getClaims();

        System.out.println("Type the claim ID or user's ID: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Claim c : claims){
            if (c.getId().equals(input) || c.getInsuredPerson().getId().equals(input)) {
                System.out.println(c.toString());
                isMatchFound=true;
            }
        }

        if (!isMatchFound) {
            System.out.println("Error!! No matching claim found");
        }
    }

    // Show all clainms
    public void printShowAllMenu(){
        List<Claim> claims = this.getClaims();
        System.out.println("[ List of all Claims ]");
        int i = 1;
        for(Claim c : claims){
            System.out.println(i+". "+c.toString());
            i++;
        }
    }

}
