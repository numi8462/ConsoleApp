/** 
* @author <Youngho Kim - s3726115> 
*/ 
package customers;

public class Dependent extends Customer{
    private PolicyHolder policyHolder;

    // Constructor
    public Dependent(String id, String fullName, PolicyHolder policyHolder) {
        super(id, fullName);
        this.policyHolder = policyHolder;
    }

    // Getter and Setter for policyHolder
    public PolicyHolder getPolicyHolder() {return policyHolder;}
    public void setPolicyHolder(PolicyHolder policyHolder) {this.policyHolder=policyHolder;}

    // fromString method for creation of object from file
    public static Dependent fromString(String str, CustomerManager customerManager) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];
        PolicyHolder policyHolder = (PolicyHolder) customerManager.findCustomerById(parts[2]);
        return new Dependent(id, fullName, policyHolder);
    }
}