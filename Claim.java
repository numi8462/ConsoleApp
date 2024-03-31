/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Claim {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private Double claimAmount;
    private String status;
    private String receiverBankingInfo;


    public Claim(){
        this.id = "";
        this.claimDate = new Date();
        this.insuredPerson = null;
        this.cardNumber = "";
        this.examDate = new Date();
        this.documents = null; //ClaimId_CardNumber_DocumentName.pdf
        this.claimAmount = 0.0;
        this.status="Pending";
        this.receiverBankingInfo = "Bank - Name - Number";
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setReciverBankingInfo(String reciverBankingInfo) {
        this.receiverBankingInfo = reciverBankingInfo;
    }

    @Override
    public String toString() {
        return id + "," + claimDate + "," + insuredPerson.getId() + "," + cardNumber + "," + examDate + "," + String.join(";", documents) + "," + claimAmount + "," + status + "," + receiverBankingInfo;
    }

    public static Claim fromString(String str, CustomerManager customerManager) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        String[] parts = str.split(",");
        Claim claim = new Claim();
        claim.id = parts[0];

        try {
            date = formatter.parse(parts[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        claim.claimDate = date; // You'll need to convert the string to a Date
        claim.insuredPerson = customerManager.findCustomerById(parts[2]); // You'll need to find the Customer with this ID
        claim.cardNumber = parts[3];

        try {
            date = formatter.parse(parts[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        claim.examDate = date; // You'll need to convert the string to a Date
        claim.documents = new ArrayList<>(Arrays.asList(parts[5].split(";")));
        claim.claimAmount = Double.parseDouble(parts[6]);
        claim.status = parts[7];
        claim.receiverBankingInfo = parts[8];
        return claim;
    }

    // public static List<Claim> listFromString(String str) {
    //     List<Claim> claims = new ArrayList<>();
    //     String[] parts = str.split(";"); // Assuming claims are separated by semicolons in the file
    //     for (String part : parts) {
    //         claims.add(Claim.fromString(part));
    //     }
    //     return claims;
    // }
}
