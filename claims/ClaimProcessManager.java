package claims;
/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.List;

import customers.Customer;

public interface ClaimProcessManager {

    //add a new claim
    public void add(Customer customer);

    //update a claim
    public void update(Claim claim);

    //delete a claim
    public void delete(String id, Customer customer);

    //get one claim
    public Claim getOne(String id);

    //get all claims
    public List<Claim> getAll();

    public void printClaims();
}

