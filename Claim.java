/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.Date;
import java.util.ArrayList;
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
    private String reciverBankingInfo;


    public Claim(){
        this.id = "";
        this.claimDate = new Date();
        this.insuredPerson = null;
        this.cardNumber = "";
        this.examDate = new Date();
        this.documents = null; //ClaimId_CardNumber_DocumentName.pdf
        this.claimAmount = 0.0;
        this.status="Pending";
        this.reciverBankingInfo = "Bank - Name - Number";
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

    public String getReciverBankingInfo() {
        return reciverBankingInfo;
    }

    public void setReciverBankingInfo(String reciverBankingInfo) {
        this.reciverBankingInfo = reciverBankingInfo;
    }

    @Override
    public String toString() {
        return "Claim{" +
            "id='" + id + '\'' +
            ", claimDate=" + claimDate +
            ", insuredPerson=" + insuredPerson +
            ", cardNumber='" + cardNumber + '\'' +
            ", examDate=" + examDate +
            ", documents=" + documents +
            ", claimAmount=" + claimAmount +
            ", status='" + status + '\'' +
            ", reciverBankingInfo='" + reciverBankingInfo + '\'' +
            '}';
    }
}
