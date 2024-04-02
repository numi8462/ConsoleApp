/** 
* @author <Youngho Kim - s3726115> 
*/ 
package claims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import customers.CustomerManager;

public class ClaimManager {
    List<Claim> claims = new ArrayList<>();
   
    public ClaimManager(){
        this.claims = new ArrayList<>();
    }

    public List<Claim>  getClaims() { return this.claims;}

    public void add(Claim claim){

    };

    //update a claim
    public void update(Claim claim){

    };

    //delete a claim
    public void delete(Claim claim){

    };

    //get one claim
    public Claim getOne(int id){
        Claim claim = new Claim();
        return claim;
    };

    //get all claims
    public List<Claim> getAll(){
        return this.claims;
    };

    public void readClaimsFromFile(String filename, CustomerManager customerManager){

        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(Claim.fromString(line,customerManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public void printClaims(){
        for(Claim  c : claims){
            System.out.println(c.toString());
        }
    }

}
