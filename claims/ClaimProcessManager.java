package claims;
/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.List;

import customers.CustomerManager;

public interface ClaimProcessManager {

    //add a new claim
    public void add(ClaimManager claimManager);

    //update a claim
    public void update(Claim claim, ClaimManager claimManager);

    //delete a claim
    public void delete(Claim claim);

    //get one claim
    public Claim getOne(String id);

    //get all claims
    public List<Claim> getAll();

    public void printClaims();
}

