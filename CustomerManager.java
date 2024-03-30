/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    List<Customer> customers = new ArrayList<>();

    public void readCustomerFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line in the file represents a Customer
                // You'll need to implement the fromString method in the Customer class
                customers.add(Customer.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null; // or throw an exception
    }
}
