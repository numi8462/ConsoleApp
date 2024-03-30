/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.List;

public interface ClaimProcessManager {
    //add a claim
    void add(Claim claim);

    //update a claim
    void update(Claim claim);

    //delete a claim
    void delete(Claim claim);

    //get one claim
    Claim getOne(int id);

    //get all claims
    List<Claim> getAll();
}
