/** 
* @author <Youngho Kim - s3726115> 
*/ 

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Claim {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private Double claimAmount;
    private String status;
    private String reciverBankingInfo;

    public Claim(){
        
    }

    @Override
    public String toString() {
        return "Claim{" +
            "id='" + id + '\'' +
            ", claimDate=" + claimDate +
            ", insuredPerson=" + insuredPerson +
            ", cardNumber='" + cardNumber + '\'' +
            ", examDate=" + examDate +
            ", documents=" + documents +
            ", claimAmount=" + claimAmount +
            ", status='" + status + '\'' +
            ", reciverBankingInfo='" + reciverBankingInfo + '\'' +
            '}';
    }
}
