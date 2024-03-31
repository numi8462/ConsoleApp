import java.util.ArrayList;
import java.util.List;

/** 
* @author <Youngho Kim - s3726115> 
*/ 

public class Dependent extends Customer{
    private PolicyHolder policyHolder;

    public Dependent(String id, String fullName, InsuranceCard insuranceCard, PolicyHolder policyHolder) {
        super(id, fullName);
        this.policyHolder = policyHolder;
    }

    // Getter for policyHolder
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public static Dependent fromString(String str) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];
        InsuranceCard insuranceCard = InsuranceCard.fromString(parts[2]);
        List<Claim> claims = new ArrayList<>();
        PolicyHolder policyHolder = PolicyHolder.fromString(parts[4]);
    
        return new Dependent(id, fullName, insuranceCard, policyHolder, claims);
    }
}