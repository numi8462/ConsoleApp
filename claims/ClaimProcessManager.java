package claims;
/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.List;

import customers.CustomerManager;

public interface ClaimProcessManager {

    //add a claim
    public void add(Claim claim);

    //update a claim
    public void update(Claim claim);

    //delete a claim
    public void delete(Claim claim);

    //get one claim
    public Claim getOne(String id);

    //get all claims
    public List<Claim> getAll();

    // public void readClaimsFromFile(String filename, CustomerManager customerManager);

    public void printClaims();
}

