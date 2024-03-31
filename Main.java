/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements ClaimProcessManager {

    List<Claim> claims = new ArrayList<>();
   

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

        try (BufferedReader reader = new BufferedReader(new FileReader("claims.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(Claim.fromString(line,customerManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };


    public static void main(String[] args) {
        //reads claims txt
        CustomerManager customerManager = new CustomerManager();
        customerManager.readPolicyHolderFile("policyHolders.txt");
        customerManager.readDependentFile("dependents.txt");
        // customerManager.printCustomersInfo();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        while(true){
            menu.printMainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Add a claim
                    break;
                case "2":
                    // Update a claim
                    break;
                case "3":
                    // Delete a claim
                    break;
                case "4":
                    // Search a claim
                    break;
                case "5":
                    // Show all claims
                    break;
                case "6":
                    System.out.println("Exiting System...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
