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
}