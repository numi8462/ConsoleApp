/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
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


}