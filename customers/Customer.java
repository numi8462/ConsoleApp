package customers;
/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import claims.Claim;
import claims.ClaimManager;
import claims.ClaimProcessManager;

public abstract class Customer implements ClaimProcessManager {
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claims; 

    public Customer(String customerId, String name) {
        this.id = customerId;
        this.fullName = name;
        this.insuranceCard = new InsuranceCard();
        this.claims = new ArrayList<Claim>();
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    //add a new claim
    public void add(ClaimManager claimManager){
        Claim newClaim = new Claim();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following details:");

        // creates unique uuid for claim
        String id;
        do {
            UUID uuid = UUID.randomUUID();
            long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
            id = "f-" + Long.toString(l).substring(0, 10);
        } while (claimManager.isDuplicate(id, this.claims));

        newClaim.setId(id);
        newClaim.setClaimDate(new Date());
        newClaim.setInsuredPerson(this);

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


        claims.add(newClaim);
        claimManager.add(newClaim);
    };

    //update a claim
    public void update(Claim claim, ClaimManager claimManager){
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

        
        claimManager.update(claim);
    };

    //delete a claim
    public void delete(Claim claim){

    };

    //get one claim
    public Claim getOne(String claimId){
        for(Claim c : claims){
            if(c.getId() == claimId){
                return c;
            }
        }
        return null;
    };

    //get all claims
    public List<Claim> getAll(){
        return this.claims;
    };

    public void printClaims(){

    };

    @Override
    public String toString(){
        return "Customer id: " + id +  ", Full Name: " + fullName + ", " + insuranceCard;
    }

}