/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Customer> dependents;

    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard){
        super(id, fullName);
        this.dependents = new ArrayList<Customer>();
    }
}
