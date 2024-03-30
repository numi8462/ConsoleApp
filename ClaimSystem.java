import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* @author <Youngho Kim - s3726115> 
*/ 
public class ClaimSystem {

    List<Claim> claims = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    public void readClaims(){
        CustomerManager customerManager = new CustomerManager();

        try (BufferedReader reader = new BufferedReader(new FileReader("claims.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(Claim.fromString(line,customerManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //reads claims txt
        
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
