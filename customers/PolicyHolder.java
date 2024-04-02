/** 
* @author <Youngho Kim - s3726115> 
*/ 

package customers;
import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Customer> dependents;

    public PolicyHolder(String id, String fullName){
        super(id, fullName);
        this.dependents = new ArrayList<Customer>();
    }

    public static PolicyHolder fromString(String str) {
        String[] parts = str.split(",");
        String id = parts[0];
        String fullName = parts[1];

        return new PolicyHolder(id, fullName);

    }

    public void addDependents(Dependent dependent){
        dependents.add(dependent);
    }

}
