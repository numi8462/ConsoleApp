/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.List;
import java.util.Scanner;
import claims.Claim;
import claims.ClaimManager;
import claims.ClaimProcessManager;
import customers.CustomerManager;


public class Menu {

    // prints main menu
    public void printMainMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. Add a claim");
        System.out.println("2. Update a claim");
        System.out.println("3. Delete a claim");
        System.out.println("4. Search a claim");
        System.out.println("5. Show all claims");
        System.out.println("6. Exit");
    }

    public void printAddMenu(){
        
    }

    public void printUpdateMenu(){

    }

    // Print search menu. search by claim or user's id
    public void printSearchMenu(ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();

        System.out.println("Type the claim ID or user's ID: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isMatchFound = false;
        for(Claim c : claims){
            if (c.getId().equals(input) || c.getInsuredPerson().getId().equals(input)) {
                System.out.println(c.toString());
            }
        }

        if (!isMatchFound) {
            System.out.println("Error!! No matching claim found");
        }
    }

    // Show all clainms
    public void printShowAllMenu(ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();
        System.out.println("[ List of all Claims ]");
        for(Claim c : claims){
            System.out.println(c.toString());
        }
    }
    
}