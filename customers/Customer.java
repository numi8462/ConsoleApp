package customers;
/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.ArrayList;
import java.util.List;

import claims.Claim;
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

    //add a claim
    public void add(Claim claim){
        claims.add(claim);
    };

    //update a claim
    public void update(Claim claim){

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