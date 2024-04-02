package customers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.Date;

import claims.Claim;

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private Customer policyOwner;
    private Date expirationDate;

    public InsuranceCard(){
        this.cardNumber = "";
        this.cardHolder = null;
        this.policyOwner = null;
        this.expirationDate = new Date();
    }

    public InsuranceCard(String cardNumber, Customer cardHolder, Customer policyOwner) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = new Date();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Customer getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(Customer policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    public static InsuranceCard fromString(String str, CustomerManager customerManager) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        String[] parts = str.split(",");

        InsuranceCard insuranceCard = new InsuranceCard();

        insuranceCard.setCardNumber(parts[0]);
        insuranceCard.cardHolder = customerManager.findCustomerById(parts[1]);
        insuranceCard.policyOwner = customerManager.findCustomerById(parts[2]);
        try {
            date = formatter.parse(parts[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        insuranceCard.expirationDate = date;
        return insuranceCard;
    }

    @Override
    public String toString(){
        LocalDate date = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String newDate = date.format(formatter);

        return  "Insurance Card: " + cardNumber + "," +  cardHolder.getId() + ", " + policyOwner.getId() + ", " + newDate;
    }
}
