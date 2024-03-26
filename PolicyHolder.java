/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Customer> dependents;

    public PolicyHolder(){
        super();
        this.dependents = new ArrayList<Customer>();
    }

    public PolicyHolder(String id, String fullName){
        super(id, fullName);
        this.dependents = new ArrayList<Customer>();
    }
}
