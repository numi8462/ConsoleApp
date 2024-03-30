import java.util.List;

/** 
* @author <Youngho Kim - s3726115> 
*/ 

public class Dependent extends Customer{
    private String policyHolderId;

    public Dependent(String id, String fullName, InsuranceCard insuranceCard, String policyHolderId) {
        super(id, fullName);
        this.policyHolderId = policyHolderId;
    }

    // Getter for policyHolder
    public String getPolicyHolder() {
        return policyHolderId;
    }

    public static Dependent fromString(String str) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];
        InsuranceCard insuranceCard = null;
        List<Claim> claims = null;
        String policyHolderId = parts[4];

        return new Dependent(id, fullName, insuranceCard, policyHolderId);

    }
}