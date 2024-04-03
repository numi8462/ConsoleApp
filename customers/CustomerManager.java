/** 
* @author <Youngho Kim - s3726115> 
*/ 

package customers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import claims.ClaimManager;
import claims.Claim;

public class CustomerManager{
    List<Customer> customers = new ArrayList<>();

    public CustomerManager(){
        this.customers = new ArrayList<>();
    }

    // Getters and Setters
    public List<Customer> getCustomers() { return this.customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers;}
    
    //read policyHolder files and add to customers list
    public void readPolicyHolderFile(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PolicyHolder customer = PolicyHolder.fromString(line);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read dependents files and add to customers list
    public void readDependentFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Dependent customer = Dependent.fromString(line,this);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read insurance card file and sets each customers insurance card
    public void readInsuranceFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                InsuranceCard insuranceCard = InsuranceCard.fromString(line,this);
                for(Customer c : customers){
                    if(insuranceCard.getCardHolder().getId() == c.getId()){
                        c.setInsuranceCard(insuranceCard);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //adds customer to customers list
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //find customer by id
    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null; // or throw an exception
    }

    //prints customer information
    public void printCustomersInfo(){
        for(Customer c : customers){
            System.out.println(c.toString());;
        }
    }

    public void addClaimsToCustomer(ClaimManager claimManager){
        List<Claim> claims = claimManager.getClaims();

        for(Customer customer : customers){
            for(Claim claim : claims){
                if(customer.getId() == claim.getInsuredPerson().getId()){
                    customer.add(claim);
                }
            }
        }
    }
}
