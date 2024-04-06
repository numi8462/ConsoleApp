/** 
* @author <Youngho Kim - s3726115> 
*/ 

package customers;
import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Customer> dependents;

    // Constructor
    public PolicyHolder(String id, String fullName){
        super(id, fullName);
        this.dependents = new ArrayList<Customer>();
    }

    //Getter and Setter
    public List<Customer> getDependents() {return dependents;}
    public void setDependents(List<Customer> dependents) {this.dependents = dependents;}
    
    // fromString method for creation of object from file
    public static PolicyHolder fromString(String str) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];
        return new PolicyHolder(id, fullName);
    }
}
