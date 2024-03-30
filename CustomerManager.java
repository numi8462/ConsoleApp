/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    List<Customer> customers = new ArrayList<>();

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
