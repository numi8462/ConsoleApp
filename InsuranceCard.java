/** 
* @author <Youngho Kim - s3726115> 
*/ 
import java.util.Date;

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
}
