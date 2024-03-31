/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.ArrayList;
import java.util.List;



public class Dependent extends Customer{
    private PolicyHolder policyHolder;

    public Dependent(String id, String fullName, PolicyHolder policyHolder) {
        super(id, fullName);
        this.policyHolder = policyHolder;
    }

    // Getter for policyHolder
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public static Dependent fromString(String str, CustomerManager customerManager) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];

        PolicyHolder policyHolder = (PolicyHolder) customerManager.findCustomerById(parts[2]);
    
        return new Dependent(id, fullName, policyHolder);
    }
}