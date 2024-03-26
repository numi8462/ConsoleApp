/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claims; 

    public Customer() {
        this.id = "Default";
        this.fullName = "Default";
        this.insuranceCard = new InsuranceCard();
        this.claims = new ArrayList<Claim>();
    }

    public Customer(String customerId, String name) {
        this.id = customerId;
        this.fullName = name;
        this.insuranceCard = new InsuranceCard();
        this.claims = new ArrayList<Claim>();
    }
}